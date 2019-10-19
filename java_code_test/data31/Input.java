public Pair<Integer,Set<Long>> writeTable(long VAR0){
  preBufferAccess();
  int offset=_buffer.position();
  try {
    if (_buffer.remaining() < 4) {
      return Pair.<Integer,Set<Long>>create(-1,ImmutableSet.<Long>of());
    }
    _buffer.position(offset + 4);
    Set<Long> VAR0s;
    try {
      ByteBuffer tableBuffer=_buffer.slice();
      VAR0s=getTableSerializer().loadAndSerialize(VAR0,new ByteBufferOutputStream(tableBuffer));
      tableBuffer.flip();
      int length=tableBuffer.limit();
      _buffer.position(offset);
      _buffer.putInt(length);
      _buffer.position(offset + 4 + length);
    }
 catch (    UnknownTableException|DroppedTableException e) {
      VAR0s=ImmutableSet.of(VAR0);
      writeUnknownOrDroppedTable(offset,e);
    }
    _modified=true;
    return Pair.create(offset,VAR0s);
  }
 catch (  BufferOverflowException e) {
    _buffer.position(offset);
    if (offset == 0) {
      _log.error("Table with UUID {} is too large to fit in a single block",VAR0);
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
