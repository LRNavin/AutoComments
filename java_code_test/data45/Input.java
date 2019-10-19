@Deprecated public boolean isAssignableFrom(Type VAR0){
  if (VAR0 == null) {
    return false;
  }
  if (type.equals(VAR0)) {
    return true;
  }
  if (type instanceof Class<?>) {
    return rawType.isAssignableFrom($Gson$Types.getRawType(VAR0));
  }
 else   if (type instanceof ParameterizedType) {
    return isAssignableFrom(VAR0,(ParameterizedType)type,new HashMap<String,Type>());
  }
 else   if (type instanceof GenericArrayType) {
    return rawType.isAssignableFrom($Gson$Types.getRawType(VAR0)) && isAssignableFrom(VAR0,(GenericArrayType)type);
  }
 else {
    throw buildUnexpectedTypeError(type,Class.class,ParameterizedType.class,GenericArrayType.class);
  }
}
