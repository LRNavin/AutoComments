public boolean isSelected(){
  ClusterViewer viewer=getViewer();
  return viewer.getPcoaTab() != null && viewer.getPcoaTab().isShowTriPlot();
}
