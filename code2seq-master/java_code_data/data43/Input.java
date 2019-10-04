public boolean isExpired(Period period,Date now){
  int expiryDays=getExpiryDays();
  return expiryDays != DataSet.NO_EXPIRY && new DateTime(period.getEndDate()).plusDays(expiryDays).isBefore(new DateTime(now));
}
