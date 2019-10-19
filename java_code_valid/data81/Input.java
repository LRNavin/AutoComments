public void testIsSigned(){
  try {
    assertFalse(rsmd.isSigned(1));
  }
 catch (  SQLException e1) {
    fail("ResultSetMetaDataTest.isSigned" + e1.getMessage());
    e1.printStackTrace();
  }
  try {
    rsmd.isSigned(0);
    fail("SQLException is not thrown");
  }
 catch (  SQLException e) {
  }
}
