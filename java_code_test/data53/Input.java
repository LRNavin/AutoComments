@Override public void onConfigsUpdated(List<ConfigItem> VAR0){
  if (VAR0 != null && !VAR0.isEmpty()) {
    for (    ConfigItem configItem : VAR0) {
      configValues.put(configItem.getName(),configItem.getValue());
    }
  }
}
