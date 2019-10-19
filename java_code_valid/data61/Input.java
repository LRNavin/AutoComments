private boolean startsWithStringArray(String VAR0,String VAR1){
  if (VAR1 == null)   return false;
  for (int i=0; i < sArray.length; i++) {
    if (VAR1.startsWith(sArray[i])) {
      return true;
    }
  }
  return false;
}
