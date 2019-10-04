@deprecated protected DictionaryBasedBreakIterator(InputStream compiledRules) throws IOException {
  this.fRData=RBBIDataWrapper.get(compiledRules);
  this.dictionary=null;
  this.usingCTDictionary=true;
}
