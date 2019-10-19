@Override public void shutdown(){
  processServerShutdown(null);
  try {
    writer.flush();
    writer.close();
  }
 catch (  Exception e) {
    errorHandler.handleCloseError(e);
  }
}
