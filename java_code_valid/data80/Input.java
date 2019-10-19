public void swap(final Type VAR0,final Type VAR1){
  if (VAR1.getSize() == 1) {
    if (VAR0.getSize() == 1) {
      swap();
    }
 else {
      dupX2();
      pop();
    }
  }
 else {
    if (VAR0.getSize() == 1) {
      dup2X1();
      pop2();
    }
 else {
      dup2X2();
      pop2();
    }
  }
}
