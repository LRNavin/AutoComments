public Yaml(BaseConstructor VAR0,Representer VAR1,DumperOptions VAR2,Resolver VAR3){
  if (!VAR0.isExplicitPropertyUtils()) {
    VAR0.setPropertyUtils(VAR1.getPropertyUtils());
  }
 else   if (!VAR1.isExplicitPropertyUtils()) {
    VAR1.setPropertyUtils(VAR0.getPropertyUtils());
  }
  this.VAR0=VAR0;
  VAR1.setDefaultFlowStyle(VAR2.getDefaultFlowStyle());
  VAR1.setDefaultScalarStyle(VAR2.getDefaultScalarStyle());
  VAR1.getPropertyUtils().setAllowReadOnlyProperties(VAR2.isAllowReadOnlyProperties());
  VAR1.setTimeZone(VAR2.getTimeZone());
  this.VAR1=VAR1;
  this.VAR2=VAR2;
  this.VAR3=VAR3;
  this.name="Yaml:" + System.identityHashCode(this);
}
