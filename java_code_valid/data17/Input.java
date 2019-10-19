public static char[] copyOfRange(char[] VAR0,int VAR1,int VAR2){
  int newLength=VAR2 - VAR1;
  if (newLength < 0)   throw new IllegalArgumentException(VAR1 + " > " + VAR2);
  char[] copy=new char[newLength];
  System.arraycopy(VAR0,VAR1,copy,0,Math.min(VAR0.length - VAR1,newLength));
  return copy;
}
