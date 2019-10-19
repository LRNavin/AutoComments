public static int computeNumberOfThreads(int VAR0,float VAR1){
  Reject.ifTrue(VAR1 < 0,"Multiplier must be a positive number");
  return Math.max(VAR0,(int)(Runtime.getRuntime().availableProcessors() * VAR1));
}
