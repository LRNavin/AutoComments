private boolean doesStoragePortExistsInVArray(StoragePort VAR0,VirtualArray VAR1){
  List<URI> VAR1Ports=returnAllPortsInVArray(VAR1.getId());
  if (VAR1Ports.contains(VAR0.getId())) {
    return true;
  }
  return false;
}
