protected void source(String VAR0){
  String providerPreSrc="provider/" + VAR0 + "_pre.VAR0";
  String providerPostSrc="provider/" + VAR0 + "_post.VAR0";
  String clientSrc="client/" + VAR0 + "_client.VAR0";
  compile(providerPreSrc,providerModuleSrc,providerPackageSrc);
  compile(clientSrc,clientModuleSrc);
  compile(providerPostSrc,providerModuleSrc,providerPackageSrc);
  compile(clientSrc,clientModuleSrc);
}
