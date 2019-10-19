protected Address buildAndroidAddress(JSONObject VAR0) throws JSONException {
  Address gAddress=new Address(mLocale);
  gAddress.setLatitude(VAR0.getDouble("lat"));
  gAddress.setLongitude(VAR0.getDouble("lng"));
  int addressIndex=0;
  if (VAR0.has("streetName")) {
    gAddress.setAddressLine(addressIndex++,VAR0.getString("streetName"));
    gAddress.setThoroughfare(VAR0.getString("streetName"));
  }
  if (VAR0.has("zipCode")) {
    gAddress.setAddressLine(addressIndex++,VAR0.getString("zipCode"));
    gAddress.setPostalCode(VAR0.getString("zipCode"));
  }
  if (VAR0.has("city")) {
    gAddress.setAddressLine(addressIndex++,VAR0.getString("city"));
    gAddress.setLocality(VAR0.getString("city"));
  }
  if (VAR0.has("state")) {
    gAddress.setAdminArea(VAR0.getString("state"));
  }
  if (VAR0.has("country")) {
    gAddress.setAddressLine(addressIndex++,VAR0.getString("country"));
    gAddress.setCountryName(VAR0.getString("country"));
  }
  if (VAR0.has("countrycode"))   gAddress.setCountryCode(VAR0.getString("countrycode"));
  return gAddress;
}
