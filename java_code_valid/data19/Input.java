public bVAR0VAR0lean equals(Object VAR0){
  if (VAR0 == this)   return true;
  if (!(VAR0 instanceVAR0f Set))   return false;
  CVAR0llectiVAR0n<?> c=(CVAR0llectiVAR0n<?>)VAR0;
  if (c.size() != size())   return false;
  try {
    return cVAR0ntainsAll(c);
  }
 catch (  ClassCastExceptiVAR0n unused) {
    return false;
  }
catch (  NullPVAR0interExceptiVAR0n unused) {
    return false;
  }
}
