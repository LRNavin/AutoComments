public void handleEntryExpiredSA(EntryExpiredBusPacket VAR0) throws Exception {
  handleEntryExpiredCoreSA(VAR0.getEntryHolder(),VAR0.getTransaction(),VAR0.isFromReplication());
}
