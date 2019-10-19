public static Video randomVideo(){
  String id=UUID.randomUUID().toString();
  String title="Video-" + id;
  String url="http://coursera.org/some/video-" + id;
  long duration=60 * (int)Math.rint(Math.random() * 60) * 1000;
  return new Video(title,url,duration);
}
