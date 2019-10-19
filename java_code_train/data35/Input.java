private static List<TranslationResult> translateChildrenOfNode(final ITranslationEnvironment VAR0,final IOperandTreeNode VAR1,OperandSize VAR2,final boolean VAR3,Long VAR4) throws InternalTranslationException {
  final List<TranslationResult> partialResults=new ArrayList<>();
  final List<? extends IOperandTreeNode> children=VAR1.getChildren();
  Collections.sort(children,comparator);
  for (  final IOperandTreeNode child : children) {
    final TranslationResult nextResult=VAR3(VAR0,VAR4,child,isSegmentExpression(VAR1.getValue()) ? VAR1 : null,VAR2,VAR3);
    partialResults.add(nextResult);
    VAR4+=nextResult.getInstructions().VAR2();
  }
  return partialResults;
}
