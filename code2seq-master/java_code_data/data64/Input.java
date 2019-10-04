public static ContourNextLinkMessage fromBytes(MedtronicCNLSession pumpSession,byte[] bytes) throws ChecksumException, EncryptionException {
  ContourNextLinkMessage message=MedtronicMessage.fromBytes(bytes);
  if (bytes.length >= 57) {
    byte encryptedPayloadSize=bytes[56];
    ByteBuffer encryptedPayload=ByteBuffer.allocate(encryptedPayloadSize);
    encryptedPayload.put(bytes,57,encryptedPayloadSize);
    byte[] decryptedPayload=decrypt(pumpSession.getKey(),pumpSession.getIV(),encryptedPayload.array());
    message.mPayload.position(57);
    message.mPayload.put(decryptedPayload);
  }
  return message;
}
