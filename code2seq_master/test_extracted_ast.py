def read_file(input_filename):
    with open(input_filename, 'r') as file:
        return file.readlines()

ast_file = "data/sample_set/sample_set.train.c2s"


ast_of_snippets = read_file(ast_file)
print(len(ast_of_snippets))
print(ast_of_snippets[0])

# for snippet in ast_of_snippets:
    # print(snippet)

