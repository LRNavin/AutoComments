protected BasePeriod(long VAR0){
  super();
  iType=PeriodType.standard();
  int[] values=ISOChronology.getInstanceUTC().get(DUMMY_PERIOD,VAR0);
  iValues=new int[8];
  System.arraycopy(values,0,iValues,4,4);
}
