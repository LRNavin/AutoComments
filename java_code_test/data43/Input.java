public boolean isExpired(Period VAR0,Date VAR1){
  int expiryDays=getExpiryDays();
  return expiryDays != DataSet.NO_EXPIRY && new DateTime(VAR0.getEndDate()).plusDays(expiryDays).isBefore(new DateTime(VAR1));
}
