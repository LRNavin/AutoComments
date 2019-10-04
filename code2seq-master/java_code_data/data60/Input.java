public boolean freePage(int pageNum){
  Page p;
  try {
    p=fetchPage(pageNum);
  }
 catch (  PageException e) {
    return false;
  }
  return freePage(p);
}
