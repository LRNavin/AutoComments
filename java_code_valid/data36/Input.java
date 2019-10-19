public static long readSwappedUnsignedInteger(byte[] VAR0,int VAR1){
  long low=(((VAR0[VAR1 + 0] & 0xff) << 0) + ((VAR0[VAR1 + 1] & 0xff) << 8) + ((VAR0[VAR1 + 2] & 0xff) << 16));
  long high=VAR0[VAR1 + 3] & 0xff;
  return (high << 24) + (0xffffffffL & low);
}
