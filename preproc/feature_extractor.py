import json
import numpy as np
import pandas as pd

data_folder = "../data/"
data_files  = ["train", "test", "valid"]

def save_dataset(feature, label, filename):
    print(f"Saving File - {filename}")
    dataset = np.array([feature, label])
    dataset = np.transpose(dataset)
    pd.DataFrame(dataset).to_csv(data_folder + filename, index=False, header=False)

for file in data_files:
    print(f"Extracting File - {file}")
    code_feat = []
    nl_label = []
    file_path = data_folder + file + ".json"
    with open(file_path, 'r') as f:
        for line in f:
            code_feat.append(json.loads(line)["code"])
            nl_label.append(json.loads(line)["nl"])
            if len(code_feat) == 100:
                break
    save_dataset(code_feat, nl_label, file + ".csv")
