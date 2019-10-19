public void testConstrDoublePosInfinity(){
  double a=Double.POSITIVE_INFINITY;
  try {
    new BigDecimal(a);
    fail("NumberFormatException has not been caught");
  }
 catch (  NumberFormatException e) {
  }
}
