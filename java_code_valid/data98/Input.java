public void test_Constructor_Throwable_String() throws Exception {
  UndeclaredThrowableException e=new UndeclaredThrowableException(throwable,msg);
  assertEquals("Wrong cause returned",throwable,e.getCause());
  assertEquals("Wrong throwable returned",throwable,e.getUndeclaredThrowable());
  assertEquals("Wrong message returned",msg,e.getMessage());
}
