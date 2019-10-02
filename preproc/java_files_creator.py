import os
import csv
import json

# Raw Data - Folders & Files
raw_data_files  = ["train", "test", "valid"]
raw_data_folder = "data/"

# Processed java file locations
base_folder = "java_code_"
sub_folder  = "data"

# Get AST - Only First 100 code - boolean
get_ast_full_file = False

def save_code_in_javafile(to_write_path, code):
    f = open(to_write_path + "/Input.java", "w")
    f.write(code)
    f.close()

for file in raw_data_files:
    curr_base_folder = base_folder + file
    os.mkdir(curr_base_folder)
    print(f"Extracting File - {file}")
    file_path = raw_data_folder + file + ".json"
    with open(file_path, 'r') as f:
        for index, line in enumerate(f):
            if not get_ast_full_file and index == 100:
                break
            print(f"Writing Java Snippet No:{index}")
            to_write_path = curr_base_folder + '/' + sub_folder + str(index)
            os.mkdir(to_write_path)
            code = json.loads(line)["code"]
            save_code_in_javafile(to_write_path, code)
        f.close()