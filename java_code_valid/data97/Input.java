protected void invalidate(boolean VAR0){
  super.invalidate(VAR0);
  getParent().invalidate(true);
}
