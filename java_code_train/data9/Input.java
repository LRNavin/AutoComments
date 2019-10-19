private byte[] calculateUValue(byte[] VAR0,byte[] VAR1,int VAR2) throws GeneralSecurityException, EncryptionUnsupportedByProductException {
  if (VAR2 == 2) {
    Cipher rc4=createRC4Cipher();
    SecretKey key=createRC4Key(VAR0);
    initEncryption(rc4,key);
    return crypt(rc4,PW_PADDING);
  }
 else   if (VAR2 >= 3) {
    MessageDigest md5=createMD5Digest();
    md5.update(PW_PADDING);
    if (VAR1 != null) {
      md5.update(VAR1);
    }
    final byte[] hash=md5.digest();
    Cipher rc4=createRC4Cipher();
    SecretKey key=createRC4Key(VAR0);
    initEncryption(rc4,key);
    final byte[] v=crypt(rc4,hash);
    rc4shuffle(v,VAR0,rc4);
    assert v.length == 16;
    final byte[] entryValue=new byte[32];
    System.arraycopy(v,0,entryValue,0,v.length);
    System.arraycopy(v,0,entryValue,16,v.length);
    return entryValue;
  }
 else {
    throw new EncryptionUnsupportedByProductException("Unsupported standard security handler VAR2 " + VAR2);
  }
}
