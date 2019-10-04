public static byte[] compressForGzip(String string){
  ByteArrayOutputStream os=null;
  GZIPOutputStream gos=null;
  try {
    os=new ByteArrayOutputStream(string.length());
    gos=new GZIPOutputStream(os);
    gos.write(string.getBytes("UTF-8"));
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
