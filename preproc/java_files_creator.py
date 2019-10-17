import os
import csv
import json
import re
import pickle

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

def save_comment_in_txtfile(to_write_path, comment):
    f = open(to_write_path + "/comment.txt", "w")
    f.write(comment)
    f.close()

def extract_replacements(to_write_path, code, comment):
    varEncDict = {}
    varDecDict = {}
    codecopy = re.sub(r"\([A-z]+<.*>", "(type ", code)
    codecopy = re.sub(r"\,[A-z]+<.*>", ",type ", codecopy)
    codecopy = re.sub(r"@+.*(public|private|static)\s", "declaration", codecopy)
    decl = codecopy.split("\n")[0]
    varDecl = re.findall("\((.*?)\)", decl)[0]
    varList = varDecl.split(",")
    if (varList[0] == "" and len(varList) == 1):
        save_comment_in_txtfile(to_write_path, comment)
        save_code_in_javafile(to_write_path, code)
        return
    else:
        i = 0
        print(varList)
        for v in varList:
            name = v.split(" ")[-1]
            varEncDict[name] = "VAR" + str(i)
            varDecDict["VAR" + str(i)] = name 
        
        for name in varEncDict:
            code = code.replace(name, varEncDict[name])
            comment = comment.replace(name, varEncDict[name])
        
        save_comment_in_txtfile(to_write_path, comment)
        save_code_in_javafile(to_write_path, code)
    
        fEnc = open(to_write_path + "/encodeDict" , "bw")
        pickle.dump(varEncDict, fEnc)

        fDec = open(to_write_path + "/decodeDict", "bw")
        pickle.dump(varDecDict, fDec)

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
            comment = json.loads(line)["nl"]
            extract_replacements(to_write_path, code, comment)
        f.close()
