public static void computeReachableFromObject(Object VAR0,Class<?> declaredRootClass,List<String> VAR1,ReachableClasses VAR2) throws IllegalAccessException, ClassNotFoundException {
  final Class<?> concreteRootClass=DeepEqualsTesterUtil.getClass(declaredRootClass,VAR0);
  List<Field> allFields=DeepEqualsTesterUtil.getAllFields(concreteRootClass);
  for (  Field field : allFields) {
    if (!Modifier.isStatic(field.getModifiers())) {
      field.setAccessible(true);
      final Object fieldObject;
      if (VAR0 == null) {
        fieldObject=null;
      }
 else {
        fieldObject=field.get(VAR0);
      }
      List<String> childPath=Lists.newArrayList();
      childPath.addAll(VAR1);
      childPath.add(field.toString());
      addToReachableAndRecurse(fieldObject,field.getType(),field.getGenericType(),childPath,VAR2);
    }
  }
}
