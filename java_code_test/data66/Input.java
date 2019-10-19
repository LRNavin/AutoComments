@deprecated protected DictionaryBasedBreakIterator(InputStream VAR0) throws IOException {
  this.fRData=RBBIDataWrapper.get(VAR0);
  this.dictionary=null;
  this.usingCTDictionary=true;
}
