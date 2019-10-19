private boolean checkPlayServices(){
  GoogleApiAvailability apiAvailability=GoogleApiAvailability.getInstance();
  int resultCode=apiAvailability.isGooglePlayServicesAvailable(this);
  if (resultCode != ConnectionResult.SUCCESS) {
    if (apiAvailability.isUserResolvableError(resultCode)) {
      apiAvailability.getErrorDialog(this,resultCode,PLAY_SERVICES_RESOLUTION_REQUEST).show();
    }
 else {
      Log.i(TAG,"This device is not supported.");
      finish();
    }
    return false;
  }
  return true;
}
