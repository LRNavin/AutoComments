public void removeRule(Rule VAR0){
  List<Rule> ruleList=(List<Rule>)this.symbolData.getFeatureTypeStyle().rules();
  int indexFound=-1;
  int index=0;
  for (  Rule rule : ruleList) {
    if (rule == VAR0) {
      indexFound=index;
      break;
    }
 else {
      index++;
    }
  }
  if (indexFound > -1) {
    ruleList.remove(indexFound);
  }
}
