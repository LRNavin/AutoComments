@Override public void undoAction(UndoInterface VAR0){
  if (comboBox != null) {
    String oldValue=(String)VAR0.getOldValue();
    comboBox.setSelectValueKey(oldValue);
  }
}
