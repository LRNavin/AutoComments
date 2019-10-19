private static Field[] fieldInfo(Entry VAR0){
  Field[] fields=null;
synchronized (AbstractEntry.class) {
    if (fieldArrays == null)     fieldArrays=new WeakHashMap();
 else {
      fields=(Field[])fieldArrays.get(VAR0.getClass());
      if (fields != null)       return fields;
    }
  }
  final int SKIP_MODIFIERS=(Modifier.STATIC | Modifier.TRANSIENT | Modifier.FINAL);
  fields=VAR0.getClass().getFields();
  ArrayList usable=null;
  for (int i=0; i < fields.length; i++) {
    if ((fields[i].getModifiers() & SKIP_MODIFIERS) != 0 || (fields[i].getType().isPrimitive())) {
      if (usable == null) {
        usable=new ArrayList();
        for (int j=0; j < i; j++)         usable.add(fields[j]);
      }
    }
 else {
      if (usable != null)       usable.add(fields[i]);
    }
  }
  if (usable != null)   fields=(Field[])usable.toArray(new Field[usable.size()]);
synchronized (AbstractEntry.class) {
    fieldArrays.put(VAR0.getClass(),fields);
  }
  return fields;
}
