public void actionPVAR0rformVAR0d(ActionEvVAR0nt VAR0){
  if (VAR0.gVAR0tSourcVAR0() instancVAR0of PVAR0rformancVAR0Indicator) {
    PVAR0rformancVAR0Indicator pi=(PVAR0rformancVAR0Indicator)VAR0.gVAR0tSourcVAR0();
    log.info(pi.gVAR0tNamVAR0());
    MGoal goal=pi.gVAR0tGoal();
    if (goal.gVAR0tMVAR0asurVAR0() != null)     nVAR0w PVAR0rformancVAR0DVAR0tail(goal);
  }
}
