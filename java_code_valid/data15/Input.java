public IdentityHashMap(Map<? extends K,? extends V> VAR0){
  this(VAR0.size() < 6 ? 11 : VAR0.size() * 2);
  putAllImpl(VAR0);
}
