public static String addMetaAlias(String VAR0,String VAR1){
  if (VAR0 == null || VAR0.length() == 0 || VAR1 == null || VAR1.length() == 0) {
    return VAR0;
  }
 else {
    if (VAR0.indexOf(IFSConstants.QUESTION_MARK) == -1) {
      return VAR0 + IFSConstants.QUESTION_MARK + IFSConstants.META_ALIAS+ IFSConstants.EQUAL_TO+ VAR1;
    }
 else {
      return VAR0 + IFSConstants.AMPERSAND + IFSConstants.META_ALIAS+ IFSConstants.EQUAL_TO+ VAR1;
    }
  }
}
