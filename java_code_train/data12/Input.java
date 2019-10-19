public CDeleteAction(final BackEndDebuggerProvider VAR0,final int[] VAR1){
  super(VAR1.length == 1 ? "Remove Breakpoint" : "Remove Breakpoints");
  m_VAR0=Preconditions.checkNotNull(VAR0,"IE01344: Debugger provider argument can not be null");
  m_VAR1=VAR1.clone();
}
