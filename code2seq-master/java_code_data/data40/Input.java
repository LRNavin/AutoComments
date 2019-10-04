private V doGet(Object okey){
  Comparable<? super K> key=comparable(okey);
  for (; ; ) {
    Node<K,V> n=findNode(key);
    if (n == null)     return null;
    Object v=n.value;
    if (v != null)     return (V)v;
  }
}
