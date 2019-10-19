public static int readUint32AsInt(DataInput VAR0) throws IOException {
  final long l=readUint32(VAR0);
  if (l > Integer.MAX_VALUE) {
    throw new IOException("uint32 value read overflows int");
  }
  return (int)l;
}
