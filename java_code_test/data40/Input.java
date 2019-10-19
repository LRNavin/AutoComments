private V doGet(Object VAR0){
  Comparable<? super K> key=comparable(VAR0);
  for (; ; ) {
    Node<K,V> n=findNode(key);
    if (n == null)     return null;
    Object v=n.value;
    if (v != null)     return (V)v;
  }
}
