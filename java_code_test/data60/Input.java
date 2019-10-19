public boolean freePage(int VAR0){
  Page p;
  try {
    p=fetchPage(VAR0);
  }
 catch (  PageException e) {
    return false;
  }
  return freePage(p);
}
