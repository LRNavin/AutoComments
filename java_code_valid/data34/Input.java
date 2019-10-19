public boolean isLockedOut(AccountLockoutInfo VAR0){
  boolean isLockedOut=VAR0.isLockout();
  if (debug.messageEnabled()) {
    debug.message("ISAccoutLockout.isLockedOut : " + isLockedOut);
  }
  if ((VAR0 != null) && isLockedOut) {
    long now=currentTimeMillis();
    long lockOutTime=VAR0.getLockoutAt();
    if ((lockOutTime + VAR0.getActualLockoutDuration()) < now) {
      if (debug.messageEnabled()) {
        debug.message("isLockedOut returns false. " + "loginFailureLockoutDuration=" + VAR0.getActualLockoutDuration() + " lockOutTime="+ lockOutTime+ " now="+ now);
      }
      isLockedOut=false;
    }
  }
  return isLockedOut;
}
