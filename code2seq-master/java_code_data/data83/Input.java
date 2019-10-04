public static void computeReachableFromObject(Object root,Class<?> declaredRootClass,List<String> currentPath,ReachableClasses reachableClasses) throws IllegalAccessException, ClassNotFoundException {
  final Class<?> concreteRootClass=DeepEqualsTesterUtil.getClass(declaredRootClass,root);
  List<Field> allFields=DeepEqualsTesterUtil.getAllFields(concreteRootClass);
  for (  Field field : allFields) {
    if (!Modifier.isStatic(field.getModifiers())) {
      field.setAccessible(true);
      final Object fieldObject;
      if (root == null) {
        fieldObject=null;
      }
 else {
        fieldObject=field.get(root);
      }
      List<String> childPath=Lists.newArrayList();
      childPath.addAll(currentPath);
      childPath.add(field.toString());
      addToReachableAndRecurse(fieldObject,field.getType(),field.getGenericType(),childPath,reachableClasses);
    }
  }
}
