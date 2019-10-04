public static void writeStringToFile(File file,String data) throws IOException {
  writeStringToFile(file,data,Charset.defaultCharset(),false);
}
