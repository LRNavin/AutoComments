public boolean equals(Object obj){
  return obj == this || (obj != null && obj.getClass() == getClass() && instance.equals(((MarshalledWrapper)obj).instance));
}
