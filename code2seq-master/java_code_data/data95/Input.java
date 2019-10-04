public void waitUntilFinished(){
  flushTermination();
  flushUpdate();
  flushInsert();
  shutdown();
  for (int i=0; i < numberOfQueues; i++) {
    while (!executors[i].isTerminated()) {
      try {
        executors[i].awaitTermination(10000000,TimeUnit.SECONDS);
      }
 catch (      InterruptedException e) {
      }
    }
  }
  if (useBulkInsert) {
    bulkInsert();
  }
  logFinalResults();
  if (this.error != null) {
    if (error instanceof RuntimeException) {
      throw (RuntimeException)error;
    }
 else {
      throw new RuntimeException("One or more parallel tasks failed",this.error);
    }
  }
}
