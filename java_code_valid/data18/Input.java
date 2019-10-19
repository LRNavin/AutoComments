public ShortLookupTable(int VAR0,short VAR1){
  super(VAR0,data.length);
  numComponents=data.length;
  numEntries=data[0].length;
  this.data=new short[numComponents][];
  for (int i=0; i < numComponents; i++) {
    this.data[i]=data[i];
  }
}
