public Pair<Integer,Set<Long>> writeTable(long uuid){
  preBufferAccess();
  int offset=_buffer.position();
  try {
    if (_buffer.remaining() < 4) {
      return Pair.<Integer,Set<Long>>create(-1,ImmutableSet.<Long>of());
    }
    _buffer.position(offset + 4);
    Set<Long> uuids;
    try {
      ByteBuffer tableBuffer=_buffer.slice();
      uuids=getTableSerializer().loadAndSerialize(uuid,new ByteBufferOutputStream(tableBuffer));
      tableBuffer.flip();
      int length=tableBuffer.limit();
      _buffer.position(offset);
      _buffer.putInt(length);
      _buffer.position(offset + 4 + length);
    }
 catch (    UnknownTableException|DroppedTableException e) {
      uuids=ImmutableSet.of(uuid);
      writeUnknownOrDroppedTable(offset,e);
    }
    _modified=true;
    return Pair.create(offset,uuids);
  }
 catch (  BufferOverflowException e) {
    _buffer.position(offset);
    if (offset == 0) {
      _log.error("Table with UUID {} is too large to fit in a single block",uuid);
      throw new IllegalArgumentException("Table too large");
    }
    return Pair.<Integer,Set<Long>>create(-1,ImmutableSet.<Long>of());
  }
catch (  IOException e) {
    throw Throwables.propagate(e);
  }
 finally {
    postBufferAccess();
  }
}
