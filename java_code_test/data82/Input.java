private void createFilter(Rule VAR0,JsonElement VAR1,JsonElement VAR2,String VAR3){
  if (VAR1 == null)   return;
  if (VAR3 == null) {
    VAR0.setElseFilter(true);
  }
 else {
    List<String> fieldList=new ArrayList<String>();
    JsonArray fieldArray=VAR1.getAsJsonArray();
    for (int fieldIndex=0; fieldIndex < fieldArray.size(); fieldIndex++) {
      JsonElement jsonFieldElement=fieldArray.get(fieldIndex);
      if (jsonFieldElement != null) {
        JsonObject fieldObj=jsonFieldElement.getAsJsonObject();
        fieldList.add(fieldObj.get("name").getAsString());
      }
    }
    String[] VAR3s=null;
    if (VAR2 != null) {
      VAR3s=VAR3.split(VAR2.getAsString());
    }
 else {
      VAR3s=new String[1];
      VAR3s[0]=VAR3;
    }
    List<Filter> filterList=new ArrayList<Filter>();
    int index=0;
    while (index < VAR3s.length) {
      Expression fieldExpression=filterFactory.property(fieldList.get(index));
      Expression VAR3Expression=filterFactory.literal(VAR3s[index]);
      PropertyIsEqualTo filter=filterFactory.equals(fieldExpression,VAR3Expression);
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
    VAR0.setFilter(completeFilter);
  }
}
