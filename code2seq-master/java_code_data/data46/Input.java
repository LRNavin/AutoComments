private Collection<Var> migrateColumnValueAsRelation(Var parent,String fkName,String childType,Object childId){
  if (childId == null) {
    return Collections.emptyList();
  }
  String relationType=namer.relationName(fkName);
  String childRole=namer.roleChildName(fkName);
  String parentRole=namer.roleParentName(fkName);
  String foreignPrimaryKey=namer.primaryKey(childType,Collections.singleton(childId.toString()));
  Var child=var().isa(childType).id(foreignPrimaryKey);
  Var relation=var().rel(childRole,var().id(id(child))).rel(parentRole,var().id(id(parent))).isa(relationType);
  return Arrays.asList(child,relation);
}
