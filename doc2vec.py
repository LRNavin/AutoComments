# Instructions
# 1. Download the pre-trained model (the one from Wikipedia) from https://github.com/jhlau/doc2vec
# 2. Put the 'enwiki_dbow' directory inside this project
# 3. Adjust the path of the pre-trained model

from gensim.models.doc2vec import Doc2Vec

# path to pre-trained model
pretrained_model = 'enwiki_dbow/doc2vec.bin'
model = Doc2Vec.load(pretrained_model)


def get_doc2vec(comment):
    """
    Returns the vector embedding of a given comment
    """
    tokens = comment.lower().split()
    vec = model.infer_vector(tokens)
    return vec
