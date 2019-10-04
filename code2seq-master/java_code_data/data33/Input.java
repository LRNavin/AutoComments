void assignToBlock(BlockId blk){
  internalLock.writeLock().lock();
  try {
    flush();
    this.blk=blk;
    contents.read(blk);
    pins=0;
    lastLsn=LogSeqNum.readFromPage(contents,LAST_LSN_OFFSET);
  }
  finally {
    internalLock.writeLock().unlock();
  }
}
