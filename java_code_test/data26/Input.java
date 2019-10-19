private static long writeLogSegment(DistributedLogManager VAR0,int VAR1,long VAR2,int VAR3,boolean VAR4) throws IOException {
  long txid=VAR2;
  LogWriter writer=VAR0.startLogSegmentNonPartitioned();
  for (long j=1; j <= VAR1; j++) {
    if (VAR4) {
      writer.write(DLMTestUtil.getEmptyLogRecordInstance(txid++));
    }
 else {
      writer.write(DLMTestUtil.getLargeLogRecordInstance(txid++));
    }
    if (j % VAR3 == 0) {
      writer.setReadyToFlush();
      writer.flushAndSync();
    }
  }
  writer.setReadyToFlush();
  writer.flushAndSync();
  writer.close();
  return txid;
}
