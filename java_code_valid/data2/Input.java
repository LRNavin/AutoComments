public static LogoutResponse generateResponse(Status VAR0,String VAR1,Issuer VAR2,String VAR3,String VAR4,String VAR5){
  if (VAR0 == null) {
    VAR0=SAML2Utils.generateStatus(SAML2Constants.SUCCESS,SAML2Utils.bundle.getString("requestSuccess"));
  }
  LogoutResponse logoutResponse=ProtocolFactory.getInstance().createLogoutResponse();
  String responseID=SAMLUtils.generateID();
  try {
    logoutResponse.setStatus(VAR0);
    logoutResponse.setID(responseID);
    logoutResponse.setInResponseTo(VAR1);
    logoutResponse.setVersion(SAML2Constants.VERSION_2_0);
    logoutResponse.setIssueInstant(newDate());
    logoutResponse.setIssuer(VAR2);
  }
 catch (  SAML2Exception e) {
    debug.error("Error in generating LogoutResponse.",e);
  }
  return logoutResponse;
}
