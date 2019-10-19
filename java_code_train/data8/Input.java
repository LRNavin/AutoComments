@Override public void run(){
  while (doWork) {
    deliverLock();
    while (tomLayer.isRetrievingState()) {
      System.out.println("-- Retrieving State");
      canDeliver.awaitUninterruptibly();
      if (tomLayer.getLastExec() == -1)       System.out.println("-- Ready to process operations");
    }
    try {
      ArrayList<Decision> decisions=new ArrayList<Decision>();
      decidedLock.lock();
      if (decided.isEmpty()) {
        notEmptyQueue.await();
      }
      decided.drainTo(decisions);
      decidedLock.unlock();
      if (!doWork)       break;
      if (decisions.size() > 0) {
        TOMMessage[][] requests=new TOMMessage[decisions.size()][];
        int[] consensusIds=new int[requests.length];
        int[] leadersIds=new int[requests.length];
        int[] regenciesIds=new int[requests.length];
        CertifiedDecision[] cDecs;
        cDecs=new CertifiedDecision[requests.length];
        int count=0;
        for (        Decision d : decisions) {
          requests[count]=extractMessagesFromDecision(d);
          consensusIds[count]=d.getConsensusId();
          leadersIds[count]=d.getLeader();
          regenciesIds[count]=d.getRegency();
          CertifiedDecision cDec=new CertifiedDecision(this.controller.getStaticConf().getProcessId(),d.getConsensusId(),d.getValue(),d.getDecisionEpoch().proof);
          cDecs[count]=cDec;
          if (requests[count][0].equals(d.firstMessageProposed)) {
            long time=requests[count][0].timestamp;
            long seed=requests[count][0].seed;
            int numOfNonces=requests[count][0].numOfNonces;
            requests[count][0]=d.firstMessageProposed;
            requests[count][0].timestamp=time;
            requests[count][0].seed=seed;
            requests[count][0].numOfNonces=numOfNonces;
          }
          count++;
        }
        Decision lastDecision=decisions.get(decisions.size() - 1);
        if (requests != null && requests.length > 0) {
          deliverMessages(consensusIds,regenciesIds,leadersIds,cDecs,requests);
          if (controller.hasUpdates()) {
            processReconfigMessages(lastDecision.getConsensusId());
            tomLayer.setLastExec(lastDecision.getConsensusId());
            tomLayer.setInExec(-1);
          }
        }
        int cid=lastDecision.getConsensusId();
        if (cid > 2) {
          int stableConsensus=cid - 3;
          tomLayer.execManager.removeConsensus(stableConsensus);
        }
      }
    }
 catch (    Exception e) {
      e.printStackTrace(System.err);
    }
    deliverUnlock();
  }
  java.util.logging.Logger.getLogger(DeliveryThread.class.getName()).log(Level.INFO,"DeliveryThread stopped.");
}
