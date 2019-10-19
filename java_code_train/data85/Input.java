public long readUnsignedInt(){
  long result=shiftIntoLong(data,position,4);
  position+=4;
  return result;
}
