private XtnConfilctCheckIndicators checkTransactionConflict(Context context,IEntryHolder entry,ITemplateHolder template,boolean isShadow){
  XtnEntry xtnEntry;
  if ((template.getTemplateOperation() == SpaceOperations.READ || template.getTemplateOperation() == SpaceOperations.READ_IE) && !template.isExclusiveReadLockOperation()) {
    ITransactionalEntryData edata=context.isNonBlockingReadOp() ? context.getLastRawMatchSnapshot() : entry.getTxnEntryData();
    xtnEntry=edata.getWriteLockOwner();
    if (xtnEntry == null)     return XtnConfilctCheckIndicators.NO_CONFLICT;
    final XtnStatus entryWriteLockStatus=xtnEntry.getStatus();
    final int entryWriteLockOperation=edata.getWriteLockOperation();
    final boolean isDirtyRead=indicateDirtyRead(template);
    final boolean isReadCommitted=indicateReadCommitted(edata,template);
    if (template.getXidOriginatedTransaction() == null || !edata.getWriteLockTransaction().equals(template.getXidOriginatedTransaction())) {
      if (isDirtyRead)       return checkTransactionConflictDirtyRead(context,xtnEntry,entryWriteLockStatus,entryWriteLockOperation,entry,edata,isShadow);
      if (isReadCommitted)       return checkTransactionConflictReadCommitted(context,xtnEntry,entryWriteLockStatus,entryWriteLockOperation,entry,edata,isShadow);
      return checkTransactionConflict(xtnEntry,entryWriteLockStatus,entryWriteLockOperation);
    }
    if (entryWriteLockOperation == SpaceOperations.TAKE || entryWriteLockOperation == SpaceOperations.TAKE_IE)     return XtnConfilctCheckIndicators.DELETED_BY_OWN_XTN;
    if (isReadCommitted && isShadow)     return XtnConfilctCheckIndicators.XTN_CONFLICT;
    return XtnConfilctCheckIndicators.NO_CONFLICT;
  }
  if ((template.getTemplateOperation() == SpaceOperations.TAKE_IE || template.getTemplateOperation() == SpaceOperations.TAKE)) {
    List<XtnEntry> readWriteLock=entry.getReadLockOwners();
    if (entry.getWriteLockTransaction() == null && (readWriteLock == null || readWriteLock.isEmpty()))     return XtnConfilctCheckIndicators.NO_CONFLICT;
    if (readWriteLock != null && !readWriteLock.isEmpty()) {
      for (      XtnEntry readLockOwner : readWriteLock) {
        xtnEntry=readLockOwner;
        if (xtnEntry != null) {
          XtnStatus entryReadLockStatus=xtnEntry.getStatus();
          if (entryReadLockStatus == XtnStatus.COMMITED || entryReadLockStatus == XtnStatus.COMMITING || (entryReadLockStatus == XtnStatus.PREPARED && xtnEntry.m_SingleParticipant) || entryReadLockStatus == XtnStatus.ROLLED || (entryReadLockStatus == XtnStatus.ROLLING && !xtnEntry.m_AlreadyPrepared))           continue;
          if (template.getXidOriginatedTransaction() == null || !readLockOwner.m_Transaction.equals(template.getXidOriginatedTransaction()))           return XtnConfilctCheckIndicators.XTN_CONFLICT;
        }
      }
    }
    xtnEntry=entry.getWriteLockOwner();
    if (xtnEntry == null)     return XtnConfilctCheckIndicators.NO_CONFLICT;
    XtnStatus entryWriteLockStatus=xtnEntry.getStatus();
    int entryWriteLockOperation=entry.getWriteLockOperation();
    if (template.getXidOriginatedTransaction() == null || !entry.getWriteLockTransaction().equals(template.getXidOriginatedTransaction())) {
      return checkTransactionConflict(xtnEntry,entryWriteLockStatus,entryWriteLockOperation);
    }
    if (entryWriteLockOperation == SpaceOperations.TAKE || entryWriteLockOperation == SpaceOperations.TAKE_IE)     return XtnConfilctCheckIndicators.DELETED_BY_OWN_XTN;
    return XtnConfilctCheckIndicators.NO_CONFLICT;
  }
  if (template.getTemplateOperation() == SpaceOperations.UPDATE || template.isExclusiveReadLockOperation()) {
    List<XtnEntry> rwLock=entry.getReadLockOwners();
    if (entry.getWriteLockTransaction() == null && (rwLock == null || rwLock.isEmpty()))     return XtnConfilctCheckIndicators.NO_CONFLICT;
    if (rwLock != null && !rwLock.isEmpty()) {
      for (      XtnEntry readLockOwner : rwLock) {
        xtnEntry=readLockOwner;
        if (xtnEntry != null) {
          XtnStatus entryReadLockStatus=xtnEntry.getStatus();
          if (entryReadLockStatus == XtnStatus.COMMITED || entryReadLockStatus == XtnStatus.COMMITING || (entryReadLockStatus == XtnStatus.PREPARED && xtnEntry.m_SingleParticipant) || entryReadLockStatus == XtnStatus.ROLLED || (entryReadLockStatus == XtnStatus.ROLLING && !xtnEntry.m_AlreadyPrepared))           continue;
          if (template.getXidOriginatedTransaction() == null || !readLockOwner.m_Transaction.equals(template.getXidOriginatedTransaction()))           return XtnConfilctCheckIndicators.XTN_CONFLICT;
        }
      }
    }
    xtnEntry=entry.getWriteLockOwner();
    if (xtnEntry == null)     return XtnConfilctCheckIndicators.NO_CONFLICT;
    XtnStatus entryWriteLockStatus=xtnEntry.getStatus();
    int entryWriteLockOperation=entry.getWriteLockOperation();
    if (template.getXidOriginatedTransaction() == null || !entry.getWriteLockTransaction().equals(template.getXidOriginatedTransaction())) {
      return checkTransactionConflict(xtnEntry,entryWriteLockStatus,entryWriteLockOperation);
    }
    if (entryWriteLockOperation == SpaceOperations.TAKE || entryWriteLockOperation == SpaceOperations.TAKE_IE)     return UpdateModifiers.isUpdateOrWrite(template.getOperationModifiers()) ? XtnConfilctCheckIndicators.NO_CONFLICT : XtnConfilctCheckIndicators.DELETED_BY_OWN_XTN;
    if (template.isFifoGroupPoll() && xtnEntry == template.getXidOriginated() && template.isExclusiveReadLockOperation())     return XtnConfilctCheckIndicators.DELETED_BY_OWN_XTN;
    return XtnConfilctCheckIndicators.NO_CONFLICT;
  }
  return XtnConfilctCheckIndicators.NO_CONFLICT;
}
