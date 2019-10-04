private void createFilter(Rule rule,JsonElement fieldsElement,JsonElement fieldDelimiterElement,String value){
  if (fieldsElement == null)   return;
  if (value == null) {
    rule.setElseFilter(true);
  }
 else {
    List<String> fieldList=new ArrayList<String>();
    JsonArray fieldArray=fieldsElement.getAsJsonArray();
    for (int fieldIndex=0; fieldIndex < fieldArray.size(); fieldIndex++) {
      JsonElement jsonFieldElement=fieldArray.get(fieldIndex);
      if (jsonFieldElement != null) {
        JsonObject fieldObj=jsonFieldElement.getAsJsonObject();
        fieldList.add(fieldObj.get("name").getAsString());
      }
    }
    String[] values=null;
    if (fieldDelimiterElement != null) {
      values=value.split(fieldDelimiterElement.getAsString());
    }
 else {
      values=new String[1];
      values[0]=value;
    }
    List<Filter> filterList=new ArrayList<Filter>();
    int index=0;
    while (index < values.length) {
      Expression fieldExpression=filterFactory.property(fieldList.get(index));
      Expression valueExpression=filterFactory.literal(values[index]);
      PropertyIsEqualTo filter=filterFactory.equals(fieldExpression,valueExpression);
      filterList.add(filter);
      index++;
    }
    Filter completeFilter=null;
    if (filterList.size() > 1) {
      completeFilter=filterFactory.and(filterList);
    }
 else     if (filterList.size() == 1) {
      completeFilter=filterList.get(0);
    }
    rule.setFilter(completeFilter);
  }
}
