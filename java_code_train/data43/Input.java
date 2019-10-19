public void apply(RecyclerView VAR0,Iterable<Item> VAR1){
  if (VAR1 != null) {
    HashMap<Integer,Stack<RecyclerView.ViewHolder>> cache=new HashMap<>();
    for (    Item d : VAR1) {
      if (!cache.containsKey(d.getType())) {
        cache.put(d.getType(),new Stack<RecyclerView.ViewHolder>());
      }
      if (mCacheSize == -1 || cache.get(d.getType()).size() <= mCacheSize) {
        cache.get(d.getType()).push(d.getViewHolder(VAR0));
      }
      RecyclerView.RecycledViewPool VAR0Pool=new RecyclerView.RecycledViewPool();
      for (      Map.Entry<Integer,Stack<RecyclerView.ViewHolder>> entry : cache.entrySet()) {
        VAR0Pool.setMaxRecycledViews(entry.getKey(),mCacheSize);
        for (        RecyclerView.ViewHolder holder : entry.getValue()) {
          VAR0Pool.putRecycledView(holder);
        }
        entry.getValue().clear();
      }
      cache.clear();
      VAR0.setRecycledViewPool(VAR0Pool);
    }
  }
}
