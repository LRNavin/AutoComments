public static void shutdown(){
  if (instance != null) {
    instance.save();
  }
}
