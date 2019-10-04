from argparse import ArgumentParser

from config import Config
from interactive_predict import InteractivePredictor
from model import Model

extract_AST = True

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

    if args.debug:
        config = Config.get_debug_config(args)
    else:
        config = Config.get_default_config(args)

    model = Model(config)
    print('Created model')
    if config.TRAIN_PATH:
        model.train()
    if config.TEST_PATH and not args.data_path:
        results, precision, recall, f1 = model.evaluate()
        print('Accuracy: ' + str(results))
        print('Precision: ' + str(precision) + ', recall: ' + str(recall) + ', F1: ' + str(f1))
    if args.predict:
        print("Under Prediciton process.....")
        predictor = InteractivePredictor(config, model)
        if extract_AST:
            ast_fetaure_list = predictor.get_ast_paths_for_file()
            print(f"AST Feature for {len(ast_fetaure_list)} snippets")
            print(ast_fetaure_list)
        else:
            predictor.predict()

    if args.release and args.load_path:
        model.evaluate(release=True)
    model.close_session()
