from config import Config
from extractor import Extractor
from argparse import ArgumentParser

EXTRACTION_API = 'https://po3g2dx2qa.execute-api.us-east-1.amazonaws.com/production/extractmethods'

def read_file(input_filename):
    with open(input_filename, 'r') as file:
        return file.readlines()


if __name__ == '__main__':
    parser = ArgumentParser()
    parser.add_argument("-d", "--data", dest="data_path",
                        help="path to preprocessed dataset", required=False)
    parser.add_argument("-te", "--test", dest="test_path",
                        help="path to test file", metavar="FILE", required=False)

    parser.add_argument("-s", "--save_prefix", dest="save_path_prefix",
                        help="path to save file", metavar="FILE", required=False)
    parser.add_argument("-l", "--load", dest="load_path",
                        help="path to saved file", metavar="FILE", required=False)
    parser.add_argument('--release', action='store_true',
                        help='if specified and loading a trained model, release the loaded model for a smaller model '
                             'size.')
    parser.add_argument('--predict', action='store_true')
    parser.add_argument('--debug', action='store_true')
    args = parser.parse_args()

    print(f"Args - {args}")

    config = Config.get_default_config(args)

    print(f"Config - {config}")

    path_extractor = Extractor(config, EXTRACTION_API, config.MAX_PATH_LENGTH, max_path_width=2)

    input_filename = 'Input.java'
    print('Extraction Begin - AST')
    user_input = ' '.join(read_file(input_filename))
    predict_lines, pc_info_dict = path_extractor.extract_paths(user_input)


    print("*************************** EXTRACTED AST ***************************")
    print(predict_lines)
    print(pc_info_dict)

    model_results = self.model.predict(predict_lines)