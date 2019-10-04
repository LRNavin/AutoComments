@Override protected FieldConfigBase createCopy(FieldConfigBase fieldConfigBase){
  FieldConfigWKT copy=null;
  if (fieldConfigBase != null) {
    copy=new FieldConfigWKT(fieldConfigBase.getCommonData());
  }
  return copy;
}
