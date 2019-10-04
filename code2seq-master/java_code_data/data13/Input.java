public static void picture(double x,double y,String filename,double scaledWidth,double scaledHeight,double degrees){
  if (scaledWidth < 0)   throw new IllegalArgumentException("width is negative: " + scaledWidth);
  if (scaledHeight < 0)   throw new IllegalArgumentException("height is negative: " + scaledHeight);
  Image image=getImage(filename);
  double xs=scaleX(x);
  double ys=scaleY(y);
  double ws=factorX(scaledWidth);
  double hs=factorY(scaledHeight);
  if (ws < 0 || hs < 0)   throw new IllegalArgumentException("image " + filename + " is corrupt");
  if (ws <= 1 && hs <= 1)   pixel(x,y);
  offscreen.rotate(Math.toRadians(-degrees),xs,ys);
  offscreen.drawImage(image,(int)Math.round(xs - ws / 2.0),(int)Math.round(ys - hs / 2.0),(int)Math.round(ws),(int)Math.round(hs),null);
  offscreen.rotate(Math.toRadians(+degrees),xs,ys);
  draw();
}
