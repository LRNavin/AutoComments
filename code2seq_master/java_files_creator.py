import os
import csv

base_folder = "java_code_data/"
sub_folder  = "data"

dataset = "data/test.csv"

def read_file(input_filename):
    with open(input_filename, 'r') as file:
        return file.readlines()

with open(dataset) as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=',')
    for index, row in enumerate(csv_reader):
        print(f"Wrining Java Snippet No:{index}")
        to_write_path = base_folder+sub_folder+str(index)
        os.mkdir(to_write_path)
        code = row[0]
        f = open(to_write_path+"/Input.java", "w")
        f.write(code)
        f.close()
