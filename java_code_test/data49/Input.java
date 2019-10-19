public String listTargetFeatures(TargetFeatureComputer VAR0,List<Element> VAR1){
  String pauseSymbol=VAR0.getPauseSymbol();
  List<Target> targets=overridableCreateTargetsWithPauses(VAR1,pauseSymbol);
  String header=VAR0.getAllFeatureProcessorNamesAndValues();
  StringBuilder text=new StringBuilder();
  StringBuilder bin=new StringBuilder();
  for (  Target target : targets) {
    FeatureVector features=VAR0.computeFeatureVector(target);
    text.append(VAR0.toStringValues(features)).append("\n");
    bin.append(features.toString()).append("\n");
  }
  String out=header + "\n" + text+ "\n"+ bin;
  return out;
}
