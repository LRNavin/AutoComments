public void cancelAlarm(Context VAR0){
  if (alarmMgr != null) {
    alarmMgr.cancel(alarmIntent);
  }
  ComponentName receiver=new ComponentName(VAR0,BootReceiver.class);
  PackageManager pm=VAR0.getPackageManager();
  pm.setComponentEnabledSetting(receiver,PackageManager.COMPONENT_ENABLED_STATE_DISABLED,PackageManager.DONT_KILL_APP);
}
