public SyncValueResponseMessage(SyncValueResponseMessage VAR0){
  __isset_bitfield=VAR0.__isset_bitfield;
  if (VAR0.isSetHeader()) {
    this.header=new AsyncMessageHeader(VAR0.header);
  }
  this.count=VAR0.count;
}
