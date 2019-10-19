public void cleanUpRemoteSessions(){
synchronized (remoteSessionSet) {
    for (Iterator iter=remoteSessionSet.iterator(); iter.hasNext(); ) {
      SessionID sessionID=(SessionID)iter.next();
      String hostServer=null;
      try {
        hostServer=getCurrentHostServer(sessionID);
      }
 catch (      Exception ex) {
      }
      if (!serverConfig.isLocalServer(hostServer)) {
        iter.remove();
      }
    }
  }
}
