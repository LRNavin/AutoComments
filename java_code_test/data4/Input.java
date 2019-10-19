@Override protected FieldConfigBase createCopy(FieldConfigBase VAR0){
  FieldConfigWKT copy=null;
  if (VAR0 != null) {
    copy=new FieldConfigWKT(VAR0.getCommonData());
  }
  return copy;
}
