protected void resetInputValue(){
  if (inputComponent != null && (inputComponent instanceof JTextField)) {
    optionPane.setInputValue(((JTextField)inputComponent).getText());
  }
 else   if (inputComponent != null && (inputComponent instanceof JComboBox)) {
    optionPane.setInputValue(((JComboBox)inputComponent).getSelectedItem());
  }
 else   if (inputComponent != null) {
    optionPane.setInputValue(((JList)inputComponent).getSelectedValue());
  }
}
