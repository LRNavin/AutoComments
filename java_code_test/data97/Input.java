public static String formatMillis(int VAR0){
  int seconds=(int)(VAR0 / 1000);
  int hours=seconds / (60 * 60);
  seconds%=(60 * 60);
  int minutes=seconds / 60;
  seconds%=60;
  String time;
  if (hours > 0) {
    time=String.format(Locale.ROOT,"%d:%02d:%02d",hours,minutes,seconds);
  }
 else {
    time=String.format(Locale.ROOT,"%d:%02d",minutes,seconds);
  }
  return time;
}
