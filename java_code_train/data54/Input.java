public boolean useLayoutEditor(SignalMast VAR0){
  if (!destList.containsKey(VAR0)) {
    return false;
  }
  return destList.get(VAR0).useLayoutEditor();
}
