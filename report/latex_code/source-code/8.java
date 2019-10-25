public void tag(String inputFileName,String outputFileName){
    List sentences=jsc.textFile(inputFileName).collect();
    tag(sentences,outputFileName);
}