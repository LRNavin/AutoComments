public MemoryBackend clear(){
synchronized (writeLock) {
    entries.clear();
  }
  return this;
}
