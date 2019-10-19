public static String nullSafeToString(byte[] VAR0){
  if (VAR0 == null) {
    return NULL_STRING;
  }
  int length=VAR0.length;
  if (length == 0) {
    return EMPTY_ARRAY;
  }
  StringBuffer buffer=new StringBuffer();
  for (int i=0; i < length; i++) {
    if (i == 0) {
      buffer.append(ARRAY_START);
    }
 else {
      buffer.append(ARRAY_ELEMENT_SEPARATOR);
    }
    buffer.append(VAR0[i]);
  }
  buffer.append(ARRAY_END);
  return buffer.toString();
}
