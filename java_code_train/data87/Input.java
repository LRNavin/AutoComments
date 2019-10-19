public boolean isInternable(){
  return (classAnnotations != null) && (fieldAnnotations == null) && (methodAnnotations == null)&& (parameterAnnotations == null);
}
