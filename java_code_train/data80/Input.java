boolean contains(ProtocolVersion VAR0){
  if (VAR0 == ProtocolVersion.SSL20Hello) {
    return false;
  }
  return protocols.contains(VAR0);
}
