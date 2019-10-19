public static AddRequest newAddRequest(final DN VAR0){
  return Requests.newAddRequest(VAR0).addControl(TransactionIdControl.newControl(AuditRequestContext.createSubTransactionIdValue()));
}
