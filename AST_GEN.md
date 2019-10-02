# AutoComments

## Generation of AST - STEPS:

STEP 1 - Run this, python preproc/java_files_creator.py

STEP 2 - Run this, bash preproc/preprocess_custom.sh

RESULTS :
You will see the ASTs of test, train, valid in folder - data/auto_comment_dataset

NOTE:
1. Run all the above processes from the project's root directory
2. Toggle the boolean "get_ast_full_file", to extract AST for full dataset or only first 100 code snippets.
    i.  True -> Runs for full dataset
    ii. Fasle -> Runs for first 100 code snippets