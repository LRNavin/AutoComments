# AutoComments

## :pencil2: Description: 

We want to create a deep Neural Network that can automatically generate comments for code snippets passed to it.
The motivation behind this is that in software development and maintenance, developers spend around 59% of their time on program comprehension activities. Having comments that are generated automatically will hopefully cut this time down.
In order to do this we will combine the recent paper,
Code2Vec: Learning Distributed Representations of Code by Alon et al. with the paper Deep Code Comment Generation in order to make a better performing model using the newer Code2Vec encoding that was not used in the Deep Code Comment Generation paper.

## :page_facing_up: Dataset: 

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

## :bar_chart: Results

The BLEU-4 score achieved in the test dataset is presented below:

| Approaches    |     BLEU-4     |
| -------       | -------------- |
| DeepCom       | 38.17          |
| Method-1      | 6.08           |
| Method-2      | 10.02          |


For more information about the results and a detailed description of the 2 methods used, please feel free to take a look at our project report that is included on this repository.


## :office: Project Structure 
The structure of the project is:

*   [`JavaExtractor`](https://github.com/LRNavin/AutoComments/tree/master/data/JavaExtractor) This directory contains the necessary code for exctracting the ASTs from the dataset.
*   [`code2seq_master`](https://github.com/LRNavin/AutoComments/tree/master/code2seq_master) This directory contains the original Code2Seq code.
* [`data`](https://github.com/LRNavin/AutoComments/tree/master/data) here you can find a small portion of the data we used. We couldn't upload the whole dataset because of its size.
*   [`preproc`](https://github.com/LRNavin/AutoComments/tree/master/preproc) Conatins all the necessary ptython files and neccesary scripts for the preprocessing and the proper execution of the AST extraction.
*   [`scripts`](https://github.com/LRNavin/AutoComments/tree/master/scripts) Contains all the extra scripts used, like the perl script for the BLEU score extraction.
*   [`bleu.py`](https://github.com/LRNavin/AutoComments/tree/master/bleu.py) Extracts the BLEU-4 score for a reference and a prediction file.

## Papers:

Deep Code: https://xin-xia.github.io/publication/icpc182.pdf

Code2Vec: https://arxiv.org/abs/1803.09473

## :busts_in_silhouette: Group 3 Team Members 

[Rafail Skoulos](https://github.com/RafailSkoulos17)

[Navin Raj Prabhu](https://github.com/LRNavin)

[Thomas Pfann](https://github.com/ThomasPf)

[Jonathan Katzy](https://github.com/jkatzy)


