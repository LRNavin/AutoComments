private static long writeLogSegment(DistributedLogManager dlm,int numRecords,long startTxId,int flushPerNumRecords,boolean emptyRecord) throws IOException {
  long txid=startTxId;
  LogWriter writer=dlm.startLogSegmentNonPartitioned();
  for (long j=1; j <= numRecords; j++) {
    if (emptyRecord) {
      writer.write(DLMTestUtil.getEmptyLogRecordInstance(txid++));
    }
 else {
      writer.write(DLMTestUtil.getLargeLogRecordInstance(txid++));
    }
    if (j % flushPerNumRecords == 0) {
      writer.setReadyToFlush();
      writer.flushAndSync();
    }
  }
  writer.setReadyToFlush();
  writer.flushAndSync();
  writer.close();
  return txid;
}
