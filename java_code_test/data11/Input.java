public ChangeReport onEquipmentUnitAdd(final EquipmentUnitAdd VAR0){
  log.debug("onEquipmentUnitAdd - entering onEquipmentUnitAdd()..");
  ChangeReport changeReport=new ChangeReport(VAR0);
  changeReport.setState(CHANGE_STATE.SUCCESS);
  ProcessConfiguration processConfiguration=configurationController.getProcessConfiguration();
  if (processConfiguration.getEquipmentConfiguration(VAR0.getEquipmentId()) != null) {
    changeReport.appendError("onEquipmentUnitAdd - Equipment unit id: " + VAR0.getEquipmentId() + " is already registered");
    changeReport.setState(CHANGE_STATE.FAIL);
    return changeReport;
  }
  EquipmentConfiguration conf=null;
  try {
    conf=equipmentConfigurationFactory.createEquipmentConfiguration(VAR0.getEquipmentUnitXml());
  }
 catch (  Exception ex) {
    changeReport.setState(CHANGE_STATE.FAIL);
    changeReport.appendError(StackTraceHelper.getStackTrace(ex));
    return changeReport;
  }
  EquipmentMessageHandler equnit=null;
  boolean dynamicTimeDeadbandEnabled=environment.getRequiredProperty(Options.DYNAMIC_TIME_DEADBAND_ENABLED,Boolean.class);
  conf.setDynamicTimeDeadbandEnabled(dynamicTimeDeadbandEnabled);
  log.info("onEquipmentUnitAdd - Dynamic timedeadband enabled for equipment id: " + conf.getId() + " enabled: "+ dynamicTimeDeadbandEnabled);
  EquipmentLoggerFactory equipmentLoggerFactory=EquipmentLoggerFactory.createFactory(conf,processConfiguration,environment.getProperty("c2mon.daq.logging.useEquipmentLoggers",Boolean.class,false),environment.getProperty("c2mon.daq.logging.useEquipmentAppendersOnly",Boolean.class,false));
  EquipmentMessageSender equipmentMessageSender=(EquipmentMessageSender)applicationContext.getBean(EQUIPMENT_MESSAGE_SENDER);
  equipmentMessageSender.init(conf,equipmentLoggerFactory);
  configurationController.addCoreDataTagChanger(conf.getId(),equipmentMessageSender);
  try {
    validateDataTags(conf,equipmentMessageSender);
    validateCommandTags(conf,equipmentMessageSender);
    equnit=EquipmentMessageHandler.createEquipmentMessageHandler(conf.getHandlerClassName(),new EquipmentCommandHandler(conf.getId(),requestController),new EquipmentConfigurationHandler(conf.getId(),configurationController),equipmentMessageSender);
    equnit.setEquipmentLoggerFactory(equipmentLoggerFactory);
    processConfiguration.addEquipmentConfiguration(conf);
  }
 catch (  InstantiationException e) {
    String msg="Error while instantiating " + conf.getHandlerClassName();
    equipmentMessageSender.confirmEquipmentStateIncorrect(msg + ": " + e.getMessage());
    log.error(msg,e);
  }
catch (  IllegalAccessException e) {
    String msg="Access error while calling constructor of " + conf.getHandlerClassName();
    equipmentMessageSender.confirmEquipmentStateIncorrect("Error in code: " + msg);
    log.error(msg,e);
  }
catch (  ClassNotFoundException e) {
    String msg="Handler class not found: " + conf.getHandlerClassName();
    equipmentMessageSender.confirmEquipmentStateIncorrect("Error during configuration: " + msg);
    log.error(msg,e);
  }
  if (equnit != null) {
    if (!registerNewEquipmentUnit(equnit)) {
      changeReport.setState(CHANGE_STATE.REBOOT);
      changeReport.appendWarn("problem detected while registering new equipment. You need to restart the DAQ");
    }
  }
  return changeReport;
}
