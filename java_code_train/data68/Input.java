private void saveToSettings(){
  List<String> dataToSave=new LinkedList<>();
  for (  UsercolorItem item : data) {
    dataToSave.add(item.getId() + "," + HtmlColors.getColorString(item.getColor()));
  }
  settings.putList("usercolors",dataToSave);
}
