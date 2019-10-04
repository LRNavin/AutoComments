private static Field[] fieldInfo(Entry entry){
  Field[] fields=null;
synchronized (AbstractEntry.class) {
    if (fieldArrays == null)     fieldArrays=new WeakHashMap();
 else {
      fields=(Field[])fieldArrays.get(entry.getClass());
      if (fields != null)       return fields;
    }
  }
  final int SKIP_MODIFIERS=(Modifier.STATIC | Modifier.TRANSIENT | Modifier.FINAL);
  fields=entry.getClass().getFields();
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
    fieldArrays.put(entry.getClass(),fields);
  }
  return fields;
}
