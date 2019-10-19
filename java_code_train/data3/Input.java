public long size(){
  long size=0;
  if (parsedGeneExpressions == null)   parseGenes();
  for (int i=0; i < parsedGeneExpressions.length; i++)   size+=parsedGeneExpressions[i].numberOfNodes();
  return size;
}
