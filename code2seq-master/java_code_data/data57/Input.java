protected static Dfp atanInternal(final Dfp a){
  Dfp y=new Dfp(a);
  Dfp x=new Dfp(y);
  Dfp py=new Dfp(y);
  for (int i=3; i < 90; i+=2) {
    x=x.multiply(a);
    x=x.multiply(a);
    x=x.negate();
    y=y.add(x.divide(i));
    if (y.equals(py)) {
      break;
    }
    py=new Dfp(y);
  }
  return y;
}
