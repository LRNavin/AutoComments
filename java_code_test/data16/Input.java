public static DataTag buildCreateBasicDataTag(Properties VAR0){
  if (VAR0 == null) {
    VAR0=new Properties();
  }
  DataTag dataTag=DataTag.create("DataTag",Integer.class,new DataTagAddress()).build();
  dataTag.setEquipmentId(10L);
  VAR0.setProperty("name","DataTag");
  VAR0.setProperty("description","<no description provided>");
  VAR0.setProperty("mode",String.valueOf(TagMode.OPERATIONAL.ordinal()));
  VAR0.setProperty("dataType",Integer.class.getName());
  VAR0.setProperty("isLogged",String.valueOf(true));
  VAR0.setProperty("equipmentId",String.valueOf(10l));
  VAR0.setProperty("address",new DataTagAddress().toConfigXML());
  return dataTag;
}
