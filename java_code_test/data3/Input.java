protected final boolean handleAllocNode(AllocNode VAR0){
  boolean ret=false;
  Node[] targets=pag.allocLookup(VAR0);
  for (  Node element : targets) {
    if (element.makeP2Set().add(VAR0)) {
      varNodeWorkList.add((VarNode)element);
      ret=true;
    }
  }
  return ret;
}
