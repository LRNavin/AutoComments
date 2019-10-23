from common import Common
from extractor import Extractor
import json
import time

SHOW_TOP_CONTEXTS = 10
MAX_PATH_LENGTH = 8
MAX_PATH_WIDTH = 2
EXTRACTION_API = 'https://po3g2dx2qa.execute-api.us-east-1.amazonaws.com/production/extractmethods'


class InteractivePredictor:
    exit_keywords = ['exit', 'quit', 'q']
    test_extractor = True

    def __init__(self, config, model):
        model.predict([])
        self.model = model
        self.config = config
        self.path_extractor = Extractor(config, EXTRACTION_API, self.config.MAX_PATH_LENGTH, max_path_width=2)

    @staticmethod
    def read_file(input_filename):
        with open(input_filename, 'r') as file:
            return file.readlines()


    def read_raw_code_data(self, data_file, take=1):
        raw_data_snippets = []
        lines = self.read_file(data_file)
        for line in lines[:take]:
            raw_data_snippets.append(json.loads(line)["code"])
        return raw_data_snippets

    def get_ast_paths_for_file(self):
        data_file = '/Users/navinLR/Desktop/ML_for_SE/AutoComments/data/test.json'
        print("Begin Extraction")
        ast_fetaure_list = []
        raw_data_snippets = self.read_raw_code_data(data_file)
        for ind, snippet in enumerate(raw_data_snippets):
            predict_lines = self.get_ast_path_for_snippet(snippet)
            # print(f"Extracted AST for Snippet - {ind}")
            # print(f"AST Size - {len(predict_lines)}")
            ast_fetaure_list.extend(predict_lines)
        return ast_fetaure_list

    def get_ast_path_for_snippet(self, snippet):
        time.sleep(2)
        predict_lines, pc_info_dict = self.path_extractor.extract_paths(snippet)
        return predict_lines

    def predict(self):
        input_filename = 'Input.java'
        print('Serving')
        while True:
            print('Modify the file: "' + input_filename + '" and press any key when ready, or "q" / "exit" to exit')
            user_input = input()
            if user_input.lower() in self.exit_keywords:
                print('Exiting...')
                return
            user_input = ' '.join(self.read_file(input_filename))
            try:
                predict_lines, pc_info_dict = self.path_extractor.extract_paths(user_input)
            except ValueError:
                continue

            # Navin's Modif
            if self.test_extractor:
                print("Testing Extracted ASTs")
                predict_lines = [self.read_file("../data/auto_comment_dataset/auto_comment_dataset.test.c2s")[1].replace("\n","")] # Take first Line

            # print(f"Path Extractor o/p - \n {predict_lines}")

            model_results = self.model.predict(predict_lines)

            # print(f"Model Resutls -------- \n{model_results}")

            prediction_results = Common.parse_results(model_results, pc_info_dict, topk=SHOW_TOP_CONTEXTS)
            for index, method_prediction in prediction_results.items():
                print('Original name:\t' + method_prediction.original_name)
                if self.config.BEAM_WIDTH == 0:
                    print('Predicted:\t%s' % [step.prediction for step in method_prediction.predictions])
                    for timestep, single_timestep_prediction in enumerate(method_prediction.predictions):
                        print('Attention:')
                        print('TIMESTEP: %d\t: %s' % (timestep, single_timestep_prediction.prediction))
                        for attention_obj in single_timestep_prediction.attention_paths:
                            print('%f\tcontext: %s,%s,%s' % (
                                attention_obj['score'], attention_obj['token1'], attention_obj['path'],
                                attention_obj['token2']))
                else:
                    print('Predicted:')
                    for predicted_seq in method_prediction.predictions:
                        print('\t%s' % predicted_seq.prediction)
