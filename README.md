# AutoComments

## Description: 

We want to create a deep Neural Network that can automatically generate comments for code snippets passed to it.
The motivation behind this is that in software development and maintenance, developers spend around 59% of their time on program comprehension activities. Having comments that are generated automatically will hopefully cut this time down.
In order to do this we will combine the recent paper,
Code2Vec: Learning Distributed Representations of Code by Alon et al. with the paper Deep Code Comment Generation in order to make a better performing model using the newer Code2Vec encoding that was not used in the Deep Code Comment Generation paper.

## Dataset: 

The dataset that we will use is the same dataset used by the Deep Code Comment Generation paper, this is a dataset of more than 500,000 code snippets including comments.
This also gives us a baseline against which to compare.

## :scroll: System Overview 
The pipeline of the system is:
1. Extract the ASTs from the code snippets-comment pairs.
2. Use the extracted ASTs to train the model.
3. Test the trained model on the test data.

The high-level pipeline is shown in the following image:
<p align="center">
  <img src="https://github.com/LRNavin/AutoComments/blob/master/images/pipeline.png" height="111" width="600">
</p>

## :triangular_ruler: Network Architecture 
The Encoder-Decoder architecture of this project is shown in the image below and is influenced by the [work](https://openreview.net/pdf?id=H1gKYo09tX) of U. Alon et al. 

<p align="center">
  <img src="https://github.com/LRNavin/AutoComments/blob/master/images/network_architecture.png" height="331" width="850">
</p>

## Papers:

Deep Code: https://xin-xia.github.io/publication/icpc182.pdf
Code2Vec: https://arxiv.org/abs/1803.09473
