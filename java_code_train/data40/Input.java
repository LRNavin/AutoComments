public final int read() throws IOException {
  int result=src.read();
  if (result != -1) {
    ++pointer;
  }
  return result;
}
