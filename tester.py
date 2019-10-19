import doc2vec as emb

vector = emb.get_doc2vec("This is not a function to add two numbers")
print("--------- Encoded Vector ---------")
print(len(vector))
print(vector.shape)