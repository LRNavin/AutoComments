public void createKeyPair(){
  try {
    mKeyPairGenerator.initialize(new KeyGenParameterSpec.Builder(KEY_NAME,KeyProperties.PURPOSE_SIGN).setDigests(KeyProperties.DIGEST_SHA256).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setUserAuthenticationRequired(true).build());
    mKeyPairGenerator.generateKeyPair();
  }
 catch (  InvalidAlgorithmParameterException e) {
    throw new RuntimeException(e);
  }
}
