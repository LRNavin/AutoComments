public static String generateTOTP512(byte[] VAR0,String VAR1,String VAR2){
  return generateTOTP(VAR0,VAR1,VAR2,"HmacSHA512");
}
