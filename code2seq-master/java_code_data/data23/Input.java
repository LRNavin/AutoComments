public void cancelAlarm(Context context){
  if (alarmMgr != null) {
    alarmMgr.cancel(alarmIntent);
  }
  ComponentName receiver=new ComponentName(context,BootReceiver.class);
  PackageManager pm=context.getPackageManager();
  pm.setComponentEnabledSetting(receiver,PackageManager.COMPONENT_ENABLED_STATE_DISABLED,PackageManager.DONT_KILL_APP);
}
