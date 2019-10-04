protected final boolean handleAllocNode(AllocNode src){
  boolean ret=false;
  Node[] targets=pag.allocLookup(src);
  for (  Node element : targets) {
    if (element.makeP2Set().add(src)) {
      varNodeWorkList.add((VarNode)element);
      ret=true;
    }
  }
  return ret;
}
