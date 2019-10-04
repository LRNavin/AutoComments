private boolean useIsSameNode(Node node){
  if (node instanceof NodeImpl) {
    return false;
  }
  Document doc=node.getNodeType() == Node.DOCUMENT_NODE ? (Document)node : node.getOwnerDocument();
  return (doc != null && doc.getImplementation().hasFeature("Core","3.0"));
}
