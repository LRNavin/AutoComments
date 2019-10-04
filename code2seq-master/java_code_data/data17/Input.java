protected void updateRowCount(){
  int maxrow=m_rows.getMaximumRow() + 1;
  Iterator cols=getColumns();
  while (cols.hasNext()) {
    Column c=(Column)cols.next();
    c.setMaximumRow(maxrow);
  }
}
