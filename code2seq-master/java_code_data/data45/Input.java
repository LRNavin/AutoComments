@Deprecated public boolean isAssignableFrom(Type from){
  if (from == null) {
    return false;
  }
  if (type.equals(from)) {
    return true;
  }
  if (type instanceof Class<?>) {
    return rawType.isAssignableFrom($Gson$Types.getRawType(from));
  }
 else   if (type instanceof ParameterizedType) {
    return isAssignableFrom(from,(ParameterizedType)type,new HashMap<String,Type>());
  }
 else   if (type instanceof GenericArrayType) {
    return rawType.isAssignableFrom($Gson$Types.getRawType(from)) && isAssignableFrom(from,(GenericArrayType)type);
  }
 else {
    throw buildUnexpectedTypeError(type,Class.class,ParameterizedType.class,GenericArrayType.class);
  }
}
