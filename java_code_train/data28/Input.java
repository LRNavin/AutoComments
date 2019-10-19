public PerformanceMonitor(){
  initComponents();
  if (Display.getInstance().getCurrent() != null) {
    refreshFrameActionPerformed(null);
  }
  resultData.setModel(new Model());
  performanceLog.setLineWrap(true);
  resultData.setRowSorter(new TableRowSorter<Model>((Model)resultData.getModel()));
}
