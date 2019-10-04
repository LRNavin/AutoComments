public int next(){
  if (!hasNextLine())   return -1;
  String line=nextLine();
  while (hasNextLine() && !line.startsWith(">")) {
    line=nextLine();
  }
  if (line == null || !line.startsWith(">"))   return -1;
  final String queryName=Basic.getReadName(line);
  matchesTextLength=0;
  byte[] bytes=makeSAM(queryName,Basic.replaceSpaces(line,' ')).getBytes();
  if (matchesTextLength + bytes.length >= matchesText.length) {
    byte[] tmp=new byte[2 * (matchesTextLength + bytes.length)];
    System.arraycopy(matchesText,0,tmp,0,matchesTextLength);
    matchesText=tmp;
  }
  System.arraycopy(bytes,0,matchesText,matchesTextLength,bytes.length);
  matchesTextLength+=bytes.length;
  return 1;
}
