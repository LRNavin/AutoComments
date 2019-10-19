private void skipToEndOfLine(){
  for (; pos < in.length(); pos++) {
    char c=in.charAt(pos);
    if (c == '\r' || c == '\n') {
      pos++;
      break;
    }
  }
}
