public static <T>T findValueOfType(Collection<T> collection,Class<? extends T>[] types){
  if (isEmpty(collection) || ObjectUtils.isEmpty(types))   return null;
  for (  Class<? extends T> type : types) {
    T value=findValueOfType(collection,type);
    if (value != null)     return value;
  }
  return null;
}
