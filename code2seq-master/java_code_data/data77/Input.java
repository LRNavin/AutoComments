public boolean removeTuple(Tuple t){
  Table table=t.getTable();
  if (m_sets.contains(table)) {
    return table.removeTuple(t);
  }
 else {
    return false;
  }
}
