private XtnConfilctCheckIndicators checkTransactionConflict(Context VAR0,IEntryHolder VAR1,ITemplateHolder VAR2,boolean VAR3){
  XtnEntry xtnEntry;
  if ((VAR2.getTemplateOperation() == SpaceOperations.READ || VAR2.getTemplateOperation() == SpaceOperations.READ_IE) && !VAR2.isExclusiveReadLockOperation()) {
    ITransactionalEntryData edata=VAR0.isNonBlockingReadOp() ? VAR0.getLastRawMatchSnapshot() : VAR1.getTxnEntryData();
    xtnEntry=edata.getWriteLockOwner();
    if (xtnEntry == null)     return XtnConfilctCheckIndicators.NO_CONFLICT;
    final XtnStatus VAR1WriteLockStatus=xtnEntry.getStatus();
    final int VAR1WriteLockOperation=edata.getWriteLockOperation();
    final boolean isDirtyRead=indicateDirtyRead(VAR2);
    final boolean isReadCommitted=indicateReadCommitted(edata,VAR2);
    if (VAR2.getXidOriginatedTransaction() == null || !edata.getWriteLockTransaction().equals(VAR2.getXidOriginatedTransaction())) {
      if (isDirtyRead)       return checkTransactionConflictDirtyRead(VAR0,xtnEntry,VAR1WriteLockStatus,VAR1WriteLockOperation,VAR1,edata,VAR3);
      if (isReadCommitted)       return checkTransactionConflictReadCommitted(VAR0,xtnEntry,VAR1WriteLockStatus,VAR1WriteLockOperation,VAR1,edata,VAR3);
      return checkTransactionConflict(xtnEntry,VAR1WriteLockStatus,VAR1WriteLockOperation);
    }
    if (VAR1WriteLockOperation == SpaceOperations.TAKE || VAR1WriteLockOperation == SpaceOperations.TAKE_IE)     return XtnConfilctCheckIndicators.DELETED_BY_OWN_XTN;
    if (isReadCommitted && VAR3)     return XtnConfilctCheckIndicators.XTN_CONFLICT;
    return XtnConfilctCheckIndicators.NO_CONFLICT;
  }
  if ((VAR2.getTemplateOperation() == SpaceOperations.TAKE_IE || VAR2.getTemplateOperation() == SpaceOperations.TAKE)) {
    List<XtnEntry> readWriteLock=VAR1.getReadLockOwners();
    if (VAR1.getWriteLockTransaction() == null && (readWriteLock == null || readWriteLock.isEmpty()))     return XtnConfilctCheckIndicators.NO_CONFLICT;
    if (readWriteLock != null && !readWriteLock.isEmpty()) {
      for (      XtnEntry readLockOwner : readWriteLock) {
        xtnEntry=readLockOwner;
        if (xtnEntry != null) {
          XtnStatus VAR1ReadLockStatus=xtnEntry.getStatus();
          if (VAR1ReadLockStatus == XtnStatus.COMMITED || VAR1ReadLockStatus == XtnStatus.COMMITING || (VAR1ReadLockStatus == XtnStatus.PREPARED && xtnEntry.m_SingleParticipant) || VAR1ReadLockStatus == XtnStatus.ROLLED || (VAR1ReadLockStatus == XtnStatus.ROLLING && !xtnEntry.m_AlreadyPrepared))           continue;
          if (VAR2.getXidOriginatedTransaction() == null || !readLockOwner.m_Transaction.equals(VAR2.getXidOriginatedTransaction()))           return XtnConfilctCheckIndicators.XTN_CONFLICT;
        }
      }
    }
    xtnEntry=VAR1.getWriteLockOwner();
    if (xtnEntry == null)     return XtnConfilctCheckIndicators.NO_CONFLICT;
    XtnStatus VAR1WriteLockStatus=xtnEntry.getStatus();
    int VAR1WriteLockOperation=VAR1.getWriteLockOperation();
    if (VAR2.getXidOriginatedTransaction() == null || !VAR1.getWriteLockTransaction().equals(VAR2.getXidOriginatedTransaction())) {
      return checkTransactionConflict(xtnEntry,VAR1WriteLockStatus,VAR1WriteLockOperation);
    }
    if (VAR1WriteLockOperation == SpaceOperations.TAKE || VAR1WriteLockOperation == SpaceOperations.TAKE_IE)     return XtnConfilctCheckIndicators.DELETED_BY_OWN_XTN;
    return XtnConfilctCheckIndicators.NO_CONFLICT;
  }
  if (VAR2.getTemplateOperation() == SpaceOperations.UPDATE || VAR2.isExclusiveReadLockOperation()) {
    List<XtnEntry> rwLock=VAR1.getReadLockOwners();
    if (VAR1.getWriteLockTransaction() == null && (rwLock == null || rwLock.isEmpty()))     return XtnConfilctCheckIndicators.NO_CONFLICT;
    if (rwLock != null && !rwLock.isEmpty()) {
      for (      XtnEntry readLockOwner : rwLock) {
        xtnEntry=readLockOwner;
        if (xtnEntry != null) {
          XtnStatus VAR1ReadLockStatus=xtnEntry.getStatus();
          if (VAR1ReadLockStatus == XtnStatus.COMMITED || VAR1ReadLockStatus == XtnStatus.COMMITING || (VAR1ReadLockStatus == XtnStatus.PREPARED && xtnEntry.m_SingleParticipant) || VAR1ReadLockStatus == XtnStatus.ROLLED || (VAR1ReadLockStatus == XtnStatus.ROLLING && !xtnEntry.m_AlreadyPrepared))           continue;
          if (VAR2.getXidOriginatedTransaction() == null || !readLockOwner.m_Transaction.equals(VAR2.getXidOriginatedTransaction()))           return XtnConfilctCheckIndicators.XTN_CONFLICT;
        }
      }
    }
    xtnEntry=VAR1.getWriteLockOwner();
    if (xtnEntry == null)     return XtnConfilctCheckIndicators.NO_CONFLICT;
    XtnStatus VAR1WriteLockStatus=xtnEntry.getStatus();
    int VAR1WriteLockOperation=VAR1.getWriteLockOperation();
    if (VAR2.getXidOriginatedTransaction() == null || !VAR1.getWriteLockTransaction().equals(VAR2.getXidOriginatedTransaction())) {
      return checkTransactionConflict(xtnEntry,VAR1WriteLockStatus,VAR1WriteLockOperation);
    }
    if (VAR1WriteLockOperation == SpaceOperations.TAKE || VAR1WriteLockOperation == SpaceOperations.TAKE_IE)     return UpdateModifiers.isUpdateOrWrite(VAR2.getOperationModifiers()) ? XtnConfilctCheckIndicators.NO_CONFLICT : XtnConfilctCheckIndicators.DELETED_BY_OWN_XTN;
    if (VAR2.isFifoGroupPoll() && xtnEntry == VAR2.getXidOriginated() && VAR2.isExclusiveReadLockOperation())     return XtnConfilctCheckIndicators.DELETED_BY_OWN_XTN;
    return XtnConfilctCheckIndicators.NO_CONFLICT;
  }
  return XtnConfilctCheckIndicators.NO_CONFLICT;
}
