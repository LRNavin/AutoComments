private static void storeAsTypeWithSignaturesImport(String strTypeToImport,@Nullable Function objScope,PhpIndex objIndex,HashSet<String> objTypesSet){
  if (strTypeToImport.contains("|")) {
    for (    String strOneType : strTypeToImport.split("\\|")) {
      storeAsTypeWithSignaturesImport(Types.getType(strOneType),objScope,objIndex,objTypesSet);
    }
    return;
  }
  if (StringUtil.isEmpty(strTypeToImport) || strTypeToImport.equals("?")) {
    return;
  }
  if (strTypeToImport.contains("#")) {
    TypeFromSignatureResolvingUtil.resolveSignature(strTypeToImport,objScope,objIndex,objTypesSet);
    return;
  }
  objTypesSet.add(Types.getType(strTypeToImport));
}
