public static String unEscapeString(String str,char escapeChar,char charToEscape){
  return unEscapeString(str,escapeChar,new char[]{charToEscape});
}
