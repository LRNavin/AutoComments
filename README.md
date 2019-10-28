# AutoComments

## :pencil2: Description: 
### Motivation
We want to create a deep Neural Network that can automatically generate comments for code snippets passed to it.
The motivation behind this is that in software development and maintenance, developers spend around 59% of their time on program comprehension activities. Having comments that are generated automatically will hopefully cut this time down.
In order to do this we will combine the recent paper,
[Code2Vec: Learning Distributed Representations of Code](https://openreview.net/pdf?id=H1gKYo09tX) by Alon et al. with the paper [Deep Code Comment Generation](https://ink.library.smu.edu.sg/cgi/viewcontent.cgi?article=5295&context=sis_research) by X. Hu et.al, so as to make a better performing model using the newer Code2Vec encoding that was not used in the Deep Code Comment Generation paper.

### Work done
In this project, 2 experiments were conducted. For the first one, we used the Code2Seq code to create model which will generate comments for code snippets (functions) of Java instead of the function names. For the second one, we repeated the procedure followed in the first experiment with modified ASTs. In particular, we added the precific name of each variable to the AST in order to make the comments generated more descriptive. The evaluation of the experiments were conducted in terms of BLEU-4 score.

The performance of the first experiment was poor (BLEU-4 score  6.08), while with the novelty introduced in the second experiment we achieved an important improvement (BLEU-4 score 10.08).  However, the performance achieved was much worse than the one achieved by X. HU (BLEU-4 score 38.17 ) in Deep Code Comment Generation paper, because our model was not able to produce long comments. Nevertheless, it predicted succesfully the shorter comments, as well as a part of the long ones. The reason for this behavior is that the Code2Seq was built to produce function names which are short, and not long sequences.

All in all, an important main conclusion we can draw regarding our best model, is that with the novelty introduced with the variable names in the AST, it is capable of understanding the syntactic and semantic meaning of Java code regarding the automatic comment generation. However suffers from the incapability to generate longer comments and complete.

## :page_facing_up: Dataset: 

The dataset that we used, is the same dataset used by the Deep Code Comment Generation paper, this is a dataset of more than 500,000 code snippets including comments.
This also gave us a baseline against which to compare.
This dataset can be found [here](https://github.com/xing-hu/DeepCom)

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


For more information about the results and a detailed description of the 2 methods used, please feel free to take a look at our project [report](https://github.com/LRNavin/AutoComments/tree/master/report/ML4SE_group_3_report.pdf) that is included on this repository.


## :office: Project Structure 
The structure of the project is:

*   [`JavaExtractor`](https://github.com/LRNavin/AutoComments/tree/master/data/JavaExtractor) This directory contains the necessary code for exctracting the ASTs from the dataset.
*   [`code2seq_master`](https://github.com/LRNavin/AutoComments/tree/master/code2seq_master) This directory contains the original Code2Seq code.
* [`data`](https://github.com/LRNavin/AutoComments/tree/master/data) here you can find a small portion of the data we used. We couldn't upload the whole dataset because of its size.
*   [`preproc`](https://github.com/LRNavin/AutoComments/tree/master/preproc) Conatins all the necessary ptython files and neccesary scripts for the preprocessing and the proper execution of the AST extraction.
*   [`report`](https://github.com/LRNavin/AutoComments/tree/master/report) Contains the report for this project and its latex code.
*   [`scripts`](https://github.com/LRNavin/AutoComments/tree/master/scripts) Contains all the extra scripts used, like the perl script for the BLEU score extraction.
*   [`bleu.py`](https://github.com/LRNavin/AutoComments/tree/master/bleu.py) Extracts the BLEU-4 score for a reference and a prediction file.

## Papers:

[Code2Vec: Learning Distributed Representations of Code](https://openreview.net/pdf?id=H1gKYo09tX)

[Deep Code Comment Generation](https://ink.library.smu.edu.sg/cgi/viewcontent.cgi?article=5295&context=sis_research) 

## :busts_in_silhouette: Group 3 Team Members 

[Rafail Skoulos](https://github.com/RafailSkoulos17)

[Navin Raj Prabhu](https://github.com/LRNavin)

[Thomas Pfann](https://github.com/ThomasPf)

[Jonathan Katzy](https://github.com/jkatzy)


