public static <T>T findValueOfType(Collection<T> collection,Class<? extends T>[] VAR0){
  if (isEmpty(collection) || ObjectUtils.isEmpty(VAR0))   return null;
  for (  Class<? extends T> type : VAR0) {
    T value=findValueOfType(collection,type);
    if (value != null)     return value;
  }
  return null;
}
