public static DataTag buildCreateBasicDataTag(Properties properties){
  if (properties == null) {
    properties=new Properties();
  }
  DataTag dataTag=DataTag.create("DataTag",Integer.class,new DataTagAddress()).build();
  dataTag.setEquipmentId(10L);
  properties.setProperty("name","DataTag");
  properties.setProperty("description","<no description provided>");
  properties.setProperty("mode",String.valueOf(TagMode.OPERATIONAL.ordinal()));
  properties.setProperty("dataType",Integer.class.getName());
  properties.setProperty("isLogged",String.valueOf(true));
  properties.setProperty("equipmentId",String.valueOf(10l));
  properties.setProperty("address",new DataTagAddress().toConfigXML());
  return dataTag;
}
