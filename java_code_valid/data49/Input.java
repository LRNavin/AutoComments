protected void finalize(){
synchronized (statsMap) {
    statsMap.remove(statsName);
  }
synchronized (this) {
    if (statsFile == null) {
      return;
    }
    statsState=Stats.OFF;
    statsFile.flush();
    statsFile.close();
    statsFile=null;
  }
}
