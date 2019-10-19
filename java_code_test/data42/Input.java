private boolean useIsSameNode(Node VAR0){
  if (VAR0 instanceof NodeImpl) {
    return false;
  }
  Document doc=VAR0.getNodeType() == Node.DOCUMENT_NODE ? (Document)VAR0 : VAR0.getOwnerDocument();
  return (doc != null && doc.getImplementation().hasFeature("Core","3.0"));
}
