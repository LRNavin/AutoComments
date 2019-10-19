public String rowGet(String VAR0){
  String resolvedKey=resolveRowKey(VAR0);
  String cachedValue=rowMapCache.get(resolvedKey);
  if (cachedValue != null) {
    return cachedValue;
  }
  String value=rowMap.get(resolvedKey);
  if (value == null && parent != null) {
    value=parent.rowGet(resolvedKey);
  }
  if (value == null) {
    return null;
  }
  String expandedString=expand(value,false);
  rowMapCache.put(resolvedKey,expandedString);
  return expandedString;
}
