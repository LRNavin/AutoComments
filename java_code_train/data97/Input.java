public Iterator<AbstractNode> childIterator(final boolean VAR0){
  if (VAR0) {
    return new DirtyChildIterator(this);
  }
 else {
    return new ChildIterator(this);
  }
}
