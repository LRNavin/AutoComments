public static long parseDateAsEpoch(String dateStr){
  try {
    return DateUtils.parseDate(dateStr).getTime();
  }
 catch (  DateParseException e) {
    return 0;
  }
}
