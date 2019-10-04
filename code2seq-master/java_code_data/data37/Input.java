protected Highlight buildHighlight(IDataSet set,int dataSetIndex,float xVal,DataSet.Rounding rounding){
  final Entry e=set.getEntryForXPos(xVal,rounding);
  if (e == null)   return null;
  MPPointD pixels=mChart.getTransformer(set.getAxisDependency()).getPixelsForValues(e.getX(),e.getY());
  return new Highlight(e.getX(),e.getY(),(float)pixels.x,(float)pixels.y,dataSetIndex,set.getAxisDependency());
}
