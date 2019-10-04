@Override public void onConfigsUpdated(List<ConfigItem> configItems){
  if (configItems != null && !configItems.isEmpty()) {
    for (    ConfigItem configItem : configItems) {
      configValues.put(configItem.getName(),configItem.getValue());
    }
  }
}
