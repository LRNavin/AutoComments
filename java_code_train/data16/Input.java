public boolean removeSession(IgniteUuid VAR0){
  GridTaskSessionImpl ses=sesMap.get(VAR0);
  assert ses == null || ses.isFullSupport();
  if (ses != null && ses.release()) {
    sesMap.remove(VAR0,ses);
    return true;
  }
  return false;
}
