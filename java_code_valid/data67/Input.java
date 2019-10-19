public static void invokeListeners(SessionEvent VAR0){
  Reject.ifNull(VAR0,VAR0.getSession());
  final Session session=VAR0.getSession();
  for (  SessionListener listener : session.getLocalSessionEventListeners()) {
    listener.sessionChanged(VAR0);
  }
}
