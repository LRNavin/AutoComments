private static void storeAsTypeWithSignaturesImport(String VAR0,@Nullable Function VAR1,PhpIndex VAR2,HashSet<String> VAR3){
  if (VAR0.contains("|")) {
    for (    String strOneType : VAR0.split("\\|")) {
      storeAsTypeWithSignaturesImport(Types.getType(strOneType),VAR1,VAR2,VAR3);
    }
    return;
  }
  if (StringUtil.isEmpty(VAR0) || VAR0.equals("?")) {
    return;
  }
  if (VAR0.contains("#")) {
    TypeFromSignatureResolvingUtil.resolveSignature(VAR0,VAR1,VAR2,VAR3);
    return;
  }
  VAR3.add(Types.getType(VAR0));
}
