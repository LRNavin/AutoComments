public void handleEntryExpiredSA(EntryExpiredBusPacket packet) throws Exception {
  handleEntryExpiredCoreSA(packet.getEntryHolder(),packet.getTransaction(),packet.isFromReplication());
}
