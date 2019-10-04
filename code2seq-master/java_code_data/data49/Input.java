public String listTargetFeatures(TargetFeatureComputer featureComputer,List<Element> segmentsAndBoundaries){
  String pauseSymbol=featureComputer.getPauseSymbol();
  List<Target> targets=overridableCreateTargetsWithPauses(segmentsAndBoundaries,pauseSymbol);
  String header=featureComputer.getAllFeatureProcessorNamesAndValues();
  StringBuilder text=new StringBuilder();
  StringBuilder bin=new StringBuilder();
  for (  Target target : targets) {
    FeatureVector features=featureComputer.computeFeatureVector(target);
    text.append(featureComputer.toStringValues(features)).append("\n");
    bin.append(features.toString()).append("\n");
  }
  String out=header + "\n" + text+ "\n"+ bin;
  return out;
}
