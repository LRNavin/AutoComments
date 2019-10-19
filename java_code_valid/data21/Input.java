public static final void updateAllWidgets(Context VAR0,boolean VAR1){
  VAR1=VAR1 || !GlobalFlags.partialUpdate(VAR0);
  final AppWidgetManager awm=AppWidgetManager.getInstance(VAR0);
  sPollBattery=false;
  for (  int widgetId : awm.getAppWidgetIds(new ComponentName(VAR0,PCWidgetActivity.class))) {
    sPollBattery|=updateWidget(awm,VAR0,widgetId,VAR1);
  }
  sPollBattery|=updateStatusbarWidget(VAR0);
  setBatteryAlarm(VAR0);
  QTStorage.updateAllWidgets(VAR0,VAR1);
  if (sUpdateHook != null) {
    sUpdateHook.run();
  }
}
