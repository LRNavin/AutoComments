public static int maxIndex(double[] VAR0){
  double maximum=0;
  int maxIndex=0;
  for (int i=0; i < VAR0.length; i++) {
    if ((i == 0) || (VAR0[i] > maximum)) {
      maxIndex=i;
      maximum=VAR0[i];
    }
  }
  return maxIndex;
}
