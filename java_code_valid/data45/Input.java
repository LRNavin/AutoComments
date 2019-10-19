private void encodeAttributes(ByteStringBuilder VAR0,Map<AttributeType,List<Attribute>> VAR1,EntryEncodeConfig VAR2) throws DirectoryException {
  int numAttributes=0;
  for (  List<Attribute> attrList : VAR1.values()) {
    Attribute a;
    for (int i=0; i < attrList.size(); i++) {
      a=attrList.get(i);
      if (a.isVirtual() || a.isEmpty()) {
        continue;
      }
      numAttributes++;
    }
  }
  VAR0.appendBERLength(numAttributes);
  if (VAR2.compressAttributeDescriptions()) {
    for (    List<Attribute> attrList : VAR1.values()) {
      for (      Attribute a : attrList) {
        if (a.isVirtual() || a.isEmpty()) {
          continue;
        }
        VAR2.getCompressedSchema().encodeAttribute(VAR0,a);
      }
    }
  }
 else {
    for (    List<Attribute> attrList : VAR1.values()) {
      for (      Attribute a : attrList) {
        VAR0.appendBytes(getBytes(a.getAttributeDescription().toString()));
        VAR0.appendByte(0x00);
        VAR0.appendBERLength(a.size());
        for (        ByteString v : a) {
          VAR0.appendBERLength(v.length());
          VAR0.appendBytes(v);
        }
      }
    }
  }
}
