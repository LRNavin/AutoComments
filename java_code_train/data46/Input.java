public void updateUI(){
  setUI((TableHeaderUI)UIManager.getUI(this));
  TableCellRenderer renderer=getDefaultRenderer();
  if (renderer instanceof Component) {
    SwingUtilities.updateComponentTreeUI((Component)renderer);
  }
}
