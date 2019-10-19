@Override public void unparsedEntityDecl(String VAR0,String VAR1,String VAR2,String VAR3) throws SAXException {
  allowXMLCatalogPI=false;
  if (dtdHandler != null) {
    dtdHandler.unparsedEntityDecl(VAR0,VAR1,VAR2,VAR3);
  }
}
