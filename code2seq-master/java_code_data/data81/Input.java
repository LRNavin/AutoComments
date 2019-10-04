public void loadSavedApi(){
  String savedApiLevel=PropertiesComponent.getInstance().getValue(FormFactorUtils.getPropertiesComponentMinSdkKey(myFormFactor),Integer.toString(myFormFactor.defaultApi));
  setSelectedApiLevel(savedApiLevel);
  if (getSelectedIndex() < 0 && getItemCount() > 0) {
    setSelectedIndex(0);
  }
}
