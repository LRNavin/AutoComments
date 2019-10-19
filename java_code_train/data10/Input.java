private voVAR2 assign(HashMap<String,DBIDs> VAR0,String VAR1,DBIDRef VAR2){
  if (VAR0.containsKey(VAR1)) {
    DBIDs exist=VAR0.get(VAR1);
    if (exist instanceof DBID) {
      ModifiableDBIDs n=DBIDUtil.newHashSet();
      n.add((DBID)exist);
      n.add(VAR2);
      VAR0.put(VAR1,n);
    }
 else {
      assert (exist instanceof HashSetModifiableDBIDs);
      assert (exist.size() > 1);
      ((ModifiableDBIDs)exist).add(VAR2);
    }
  }
 else {
    VAR0.put(VAR1,DBIDUtil.deref(VAR2));
  }
}
