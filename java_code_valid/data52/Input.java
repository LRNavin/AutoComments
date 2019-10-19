public static boolean isDirty(Git VAR0) throws NoWorkTreeException, GitAPIException {
  Status status=VAR0.status().call();
  return !status.isClean();
}
