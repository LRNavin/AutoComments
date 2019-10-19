private Collection<Var> migrateColumnValueAsRelation(Var VAR0,String VAR1,String VAR2,Object VAR3){
  if (VAR3 == null) {
    return Collections.emptyList();
  }
  String relationType=namer.relationName(VAR1);
  String childRole=namer.roleChildName(VAR1);
  String VAR0Role=namer.roleParentName(VAR1);
  String foreignPrimaryKey=namer.primaryKey(VAR2,Collections.singleton(VAR3.toString()));
  Var child=var().isa(VAR2).id(foreignPrimaryKey);
  Var relation=var().rel(childRole,var().id(id(child))).rel(VAR0Role,var().id(id(VAR0))).isa(relationType);
  return Arrays.asList(child,relation);
}
