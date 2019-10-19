private void flush(){
  myPage.write(currentBlk);
  lastFlushedLsn=lastLsn;
}
