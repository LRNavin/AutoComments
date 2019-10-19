public Bindings add(String VAR0,JRadioButton[] VAR1,int VAR2){
  registerPropertyChangeListener(VAR1);
  return add(new JRadioButtonBinding(VAR0,VAR1,VAR2));
}
