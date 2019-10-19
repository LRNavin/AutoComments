public static void closeQuietly(final Connection VAR0){
  if (VAR0 != null) {
    try {
      VAR0.close();
    }
 catch (    final Exception e) {
    }
  }
}
