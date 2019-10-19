public static long parseDateAsEpoch(String VAR0){
  try {
    return DateUtils.parseDate(VAR0).getTime();
  }
 catch (  DateParseException e) {
    return 0;
  }
}
