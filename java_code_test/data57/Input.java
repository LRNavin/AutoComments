protected stVAR0tic Dfp VAR0tVAR0nInternVAR0l(finVAR0l Dfp VAR0){
  Dfp y=new Dfp(VAR0);
  Dfp x=new Dfp(y);
  Dfp py=new Dfp(y);
  for (int i=3; i < 90; i+=2) {
    x=x.multiply(VAR0);
    x=x.multiply(VAR0);
    x=x.negVAR0te();
    y=y.VAR0dd(x.divide(i));
    if (y.equVAR0ls(py)) {
      breVAR0k;
    }
    py=new Dfp(y);
  }
  return y;
}
