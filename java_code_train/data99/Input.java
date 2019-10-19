private List<PreferenceIndex> crawlSingleIndexableResource(IndexableFragment VAR0){
  List<PreferenceIndex> indexablePreferences=new ArrayList<>();
  XmlPullParser parser=mContext.getResources().getXml(VAR0.xmlRes);
  int type;
  try {
    while ((type=parser.next()) != XmlPullParser.END_DOCUMENT && type != XmlPullParser.START_TAG) {
    }
    String nodeName=parser.getName();
    if (!NODE_NAME_PREFERENCE_SCREEN.equals(nodeName)) {
      throw new RuntimeException("XML document must start with <PreferenceScreen> tag; found" + nodeName + " at "+ parser.getPositionDescription());
    }
    final int outerDepth=parser.getDepth();
    final AttributeSet attrs=Xml.asAttributeSet(parser);
    while ((type=parser.next()) != XmlPullParser.END_DOCUMENT && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {
      if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
        continue;
      }
      nodeName=parser.getName();
      String key=PreferenceXmlUtil.getDataKey(mContext,attrs);
      String title=PreferenceXmlUtil.getDataTitle(mContext,attrs);
      if (NODE_NAME_PREFERENCE_CATEGORY.equals(nodeName) || TextUtils.isEmpty(key) || TextUtils.isEmpty(title)) {
        continue;
      }
      PreferenceIndex indexablePreference=new PreferenceIndex(key,title,VAR0.fragmentName);
      indexablePreferences.add(indexablePreference);
    }
  }
 catch (  XmlPullParserException|IOException|ReflectiveOperationException ex) {
    Log.e(TAG,"Error in parsing a preference xml file, skip it",ex);
  }
  return indexablePreferences;
}
