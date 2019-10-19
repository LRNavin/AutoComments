public void runTest() throws Throwable {
  Document doc;
  Element rootNode;
  NodeList childList;
  Node childToRemove;
  Node removedChild;
  Node parentNode;
  doc=(Document)load("staff",true);
  rootNode=doc.getDocumentElement();
  childList=rootNode.getChildNodes();
  childToRemove=childList.item(1);
  removedChild=rootNode.removeChild(childToRemove);
  parentNode=removedChild.getParentNode();
  assertNull("nodeRemoveChildAssert1",parentNode);
}
