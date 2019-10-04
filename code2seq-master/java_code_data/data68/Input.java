@Override public void undoAction(UndoInterface undoRedoObject){
  if (comboBox != null) {
    String oldValue=(String)undoRedoObject.getOldValue();
    comboBox.setSelectValueKey(oldValue);
  }
}
