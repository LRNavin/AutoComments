public static ContourNextLinkMessage fromBytes(MedtronicCNLSession VAR0,byte[] VAR1) throws ChecksumException, EncryptionException {
  ContourNextLinkMessage message=MedtronicMessage.fromBytes(VAR1);
  if (VAR1.length >= 57) {
    byte encryptedPayloadSize=VAR1[56];
    ByteBuffer encryptedPayload=ByteBuffer.allocate(encryptedPayloadSize);
    encryptedPayload.put(VAR1,57,encryptedPayloadSize);
    byte[] decryptedPayload=decrypt(VAR0.getKey(),VAR0.getIV(),encryptedPayload.array());
    message.mPayload.position(57);
    message.mPayload.put(decryptedPayload);
  }
  return message;
}
