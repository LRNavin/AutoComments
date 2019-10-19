@KnownFailure("Fixed on DonutBurger, Wrong Exception thrown") public void test_unwrap_ByteBuffer$ByteBuffer_02(){
  String host="new host";
  int port=8080;
  ByteBuffer bbs=ByteBuffer.allocate(10);
  ByteBuffer bbR=ByteBuffer.allocate(100).asReadOnlyBuffer();
  ByteBuffer[] bbA={bbR,ByteBuffer.allocate(10),ByteBuffer.allocate(100)};
  SSLEngine sse=getEngine(host,port);
  sse.setUseClientMode(true);
  try {
    sse.unwrap(bbs,bbA);
    fail("ReadOnlyBufferException wasn't thrown");
  }
 catch (  ReadOnlyBufferException iobe) {
  }
catch (  Exception e) {
    fail(e + " was thrown instead of ReadOnlyBufferException");
  }
}
