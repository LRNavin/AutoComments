public Bindings add(String property,JRadioButton[] cs,int defaultValue){
  registerPropertyChangeListener(cs);
  return add(new JRadioButtonBinding(property,cs,defaultValue));
}
