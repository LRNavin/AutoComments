@DSGenerator(tool_name="Doppelganger",tool_version="2.0",generated_on="2014-09-03 15:01:15.190 -0400",hash_original_method="F262A3A18BABECF7EC492736953EAF6E",hash_generated_method="94A4545C167C029CC38AACEACF2087E9") private void unparkSuccessor(Node VAR0){
  int ws=VAR0.waitStatus;
  if (ws < 0)   compareAndSetWaitStatus(VAR0,ws,0);
  Node s=VAR0.next;
  if (s == null || s.waitStatus > 0) {
    s=null;
    for (Node t=tail; t != null && t != VAR0; t=t.prev)     if (t.waitStatus <= 0)     s=t;
  }
  if (s != null)   LockSupport.unpark(s.thread);
}
