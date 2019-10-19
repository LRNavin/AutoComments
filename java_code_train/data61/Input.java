@Override public void onRequestPermissionsResult(int VAR0,@NonNull String[] VAR1,@NonNull int[] VAR2){
  if (VAR0 == ALLOW_PERMISSIONS && VAR2.length > 0) {
    List<String> VAR1NotAllowed=new ArrayList<>();
    for (int i=0; i < VAR1.length; i++) {
      if (VAR2[i] == PackageManager.PERMISSION_DENIED) {
        VAR1NotAllowed.add(VAR1[i]);
      }
    }
    if (VAR1NotAllowed.isEmpty()) {
      initEvent();
    }
 else {
      permissionNotEnabled();
    }
  }
 else {
    permissionNotEnabled();
  }
}
