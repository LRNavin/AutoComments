# AutoComments

## Description: 

We want to create a deep Neural Network that can automatically generate comments for code snippets passed to it.
The motivation behind this is that in software development and maintenance, developers spend around 59% of their time on program comprehension activities. Having comments that are generated automatically will hopefully cut this time down.
In order to do this we will combine the recent paper,
Code2Vec: Learning Distributed Representations of Code by Alon et al. with the paper Deep Code Comment Generation in order to make a better performing model using the newer Code2Vec encoding that was not used in the Deep Code Comment Generation paper.

## Dataset: 

The dataset that we will use is the same dataset used by the Deep Code Comment Generation paper, this is a dataset of more than 500,000 code snippets including comments.
This also gives us a baseline against which to compare.

## Papers:

Deep Code: https://xin-xia.github.io/publication/icpc182.pdf
Code2Vec: https://arxiv.org/abs/1803.09473
