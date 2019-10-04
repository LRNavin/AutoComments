public static boolean hasNextKeyTyped(){
synchronized (keyLock) {
    return !keysTyped.isEmpty();
  }
}
