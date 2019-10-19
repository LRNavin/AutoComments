public AbstractColorChooserPanel removeChooserPanel(AbstractColorChooserPanel VAR0){
  int containedAt=-1;
  for (int i=0; i < chooserPanels.length; i++) {
    if (chooserPanels[i] == VAR0) {
      containedAt=i;
      break;
    }
  }
  if (containedAt == -1) {
    throw new IllegalArgumentException("chooser VAR0 not in this chooser");
  }
  AbstractColorChooserPanel[] newArray=new AbstractColorChooserPanel[chooserPanels.length - 1];
  if (containedAt == chooserPanels.length - 1) {
    System.arraycopy(chooserPanels,0,newArray,0,newArray.length);
  }
 else   if (containedAt == 0) {
    System.arraycopy(chooserPanels,1,newArray,0,newArray.length);
  }
 else {
    System.arraycopy(chooserPanels,0,newArray,0,containedAt);
    System.arraycopy(chooserPanels,containedAt + 1,newArray,containedAt,(chooserPanels.length - containedAt - 1));
  }
  setChooserPanels(newArray);
  return VAR0;
}
