void assignToBlock(BlockId VAR0){
  internalLock.writeLock().lock();
  try {
    flush();
    this.VAR0=VAR0;
    contents.read(VAR0);
    pins=0;
    lastLsn=LogSeqNum.readFromPage(contents,LAST_LSN_OFFSET);
  }
  finally {
    internalLock.writeLock().unlock();
  }
}
