public static byte[] compressForGzip(String VAR0){
  ByteArrayOutputStream os=null;
  GZIPOutputStream gos=null;
  try {
    os=new ByteArrayOutputStream(VAR0.length());
    gos=new GZIPOutputStream(os);
    gos.write(VAR0.getBytes("UTF-8"));
    byte[] compressed=os.toByteArray();
    return compressed;
  }
 catch (  IOException e) {
    e.printStackTrace();
  }
 finally {
    okhttp3.internal.Util.closeQuietly(gos);
    okhttp3.internal.Util.closeQuietly(os);
  }
  return null;
}
