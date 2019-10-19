public static final Tag findAncestorWithClass(Tag VAR0,VAR1) Class klass){
  boolean isInterface=false;
  if (VAR0 == null || klass == null || (!Tag.class.isAssignableFrom(klass) && !(isInterface=klass.isInterface()))) {
    return null;
  }
  for (; ; ) {
    Tag tag=VAR0.getParent();
    if (tag == null) {
      return null;
    }
    if ((isInterface && klass.isInstance(tag)) || ((Class<?>)klass).isAssignableFrom(tag.getClass())) {
      return tag;
    }
    VAR0=tag;
  }
}
