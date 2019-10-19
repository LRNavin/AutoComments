private static void normalizeDCArrays(XMPNode VAR0) throws XMPException {
  for (int i=1; i <= VAR0.getChildrenLength(); i++) {
    XMPNode currProp=VAR0.getChild(i);
    PropertyOptions arrayForm=(PropertyOptions)dcArrayForms.get(currProp.getName());
    if (arrayForm == null) {
      continue;
    }
 else     if (currProp.getOptions().isSimple()) {
      XMPNode newArray=new XMPNode(currProp.getName(),arrayForm);
      currProp.setName(XMPConst.ARRAY_ITEM_NAME);
      newArray.addChild(currProp);
      VAR0.replaceChild(i,newArray);
      if (arrayForm.isArrayAltText() && !currProp.getOptions().getHasLanguage()) {
        XMPNode newLang=new XMPNode(XMPConst.XML_LANG,XMPConst.X_DEFAULT,null);
        currProp.addQualifier(newLang);
      }
    }
 else {
      currProp.getOptions().setOption(PropertyOptions.ARRAY | PropertyOptions.ARRAY_ORDERED | PropertyOptions.ARRAY_ALTERNATE| PropertyOptions.ARRAY_ALT_TEXT,false);
      currProp.getOptions().mergeWith(arrayForm);
      if (arrayForm.isArrayAltText()) {
        repairAltText(currProp);
      }
    }
  }
}
