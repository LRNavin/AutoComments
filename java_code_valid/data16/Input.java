public void executeCharsToContentHandler(XPathContext VAR0,ContentHandler VAR1) throws javax.xml.transform.TransformerException, org.xml.sax.SAXException {
  if (Arg0IsNodesetExpr()) {
    int node=getArg0AsNode(VAR0);
    if (DTM.NULL != node) {
      DTM dtm=VAR0.getDTM(node);
      dtm.dispatchCharactersEvents(node,VAR1,true);
    }
  }
 else {
    XObject obj=execute(VAR0);
    obj.dispatchCharactersEvents(VAR1);
  }
}
