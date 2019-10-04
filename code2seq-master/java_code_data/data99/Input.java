@Override public void unparsedEntityDecl(String name,String publicId,String systemId,String notationName) throws SAXException {
  allowXMLCatalogPI=false;
  if (dtdHandler != null) {
    dtdHandler.unparsedEntityDecl(name,publicId,systemId,notationName);
  }
}
