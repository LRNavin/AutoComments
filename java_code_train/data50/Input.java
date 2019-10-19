public Diff decode() throws UnsupportedEncodingException, DecodingException {
  int header=r.read(3);
  if (DiffAction.parse(header) != DiffAction.DECODER_DATA) {
    throw new DecodingException("Invalid codecData code: " + header);
  }
  int blockSize_C=3;
  int blockSize_S=r.read(5);
  int blockSize_E=r.read(5);
  int blockSize_B=r.read(5);
  int blockSize_L=r.read(5);
  r.read(1);
  if (blockSize_S < 0 || blockSize_S > 31) {
    throw new DecodingException("blockSize_S out of range: " + blockSize_S);
  }
  if (blockSize_E < 0 || blockSize_E > 31) {
    throw new DecodingException("blockSize_E out of range: " + blockSize_E);
  }
  if (blockSize_B < 0 || blockSize_B > 31) {
    throw new DecodingException("blockSize_B out of range: " + blockSize_B);
  }
  if (blockSize_L < 0 || blockSize_L > 31) {
    throw new DecodingException("blockSize_L out of range: " + blockSize_L);
  }
  return decode(blockSize_C,blockSize_S,blockSize_E,blockSize_B,blockSize_L);
}
