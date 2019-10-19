public void runTest() throws Throwable {
  Document doc1;
  Document doc2;
  Node oldChild;
  Node newChild;
  NodeList elementList;
  Node elementNode;
  Node replacedChild;
  doc1=(Document)load("staff",false);
  doc2=(Document)load("staff",true);
  newChild=doc1.createElement("newChild");
  elementList=doc2.getElementsByTagName("employee");
  elementNode=elementList.item(1);
  oldChild=elementNode.getFirstChild();
{
    boolean success=false;
    try {
      replacedChild=elementNode.replaceChild(newChild,oldChild);
    }
 catch (    DOMException ex) {
      success=(ex.code == DOMException.WRONG_DOCUMENT_ERR);
    }
    assertTrue("throw_WRONG_DOCUMENT_ERR",success);
  }
}
