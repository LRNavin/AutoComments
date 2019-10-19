public void removeBeanContextMembershipListener(BeanContextMembershipListener VAR0){
  if (VAR0 == null)   throw new NullPointerException("listener");
synchronized (bcmListeners) {
    if (!bcmListeners.contains(VAR0))     return;
 else     bcmListeners.remove(VAR0);
  }
}
