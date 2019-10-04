public static String nullSafeToString(byte[] array){
  if (array == null) {
    return NULL_STRING;
  }
  int length=array.length;
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
    buffer.append(array[i]);
  }
  buffer.append(ARRAY_END);
  return buffer.toString();
}
