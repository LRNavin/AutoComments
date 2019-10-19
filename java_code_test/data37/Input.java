protected Highlight buildHighlight(IDataSet VAR0,int VAR1,float VAR2,DataSet.Rounding VAR3){
  final Entry e=VAR0.getEntryForXPos(VAR2,VAR3);
  if (e == null)   return null;
  MPPointD pixels=mChart.getTransformer(VAR0.getAxisDependency()).getPixelsForValues(e.getX(),e.getY());
  return new Highlight(e.getX(),e.getY(),(float)pixels.x,(float)pixels.y,VAR1,VAR0.getAxisDependency());
}
