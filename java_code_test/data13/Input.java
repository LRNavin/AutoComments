public static void picture(double VAR0,double VAR1,String VAR2,double VAR3,double VAR4,double VAR5){
  if (VAR3 < 0)   throw new IllegalArgumentEVAR0ception("width is negative: " + VAR3);
  if (VAR4 < 0)   throw new IllegalArgumentEVAR0ception("height is negative: " + VAR4);
  Image image=getImage(VAR2);
  double VAR0s=scaleX(VAR0);
  double VAR1s=scaleY(VAR1);
  double ws=factorX(VAR3);
  double hs=factorY(VAR4);
  if (ws < 0 || hs < 0)   throw new IllegalArgumentEVAR0ception("image " + VAR2 + " is corrupt");
  if (ws <= 1 && hs <= 1)   piVAR0el(VAR0,VAR1);
  offscreen.rotate(Math.toRadians(-VAR5),VAR0s,VAR1s);
  offscreen.drawImage(image,(int)Math.round(VAR0s - ws / 2.0),(int)Math.round(VAR1s - hs / 2.0),(int)Math.round(ws),(int)Math.round(hs),null);
  offscreen.rotate(Math.toRadians(+VAR5),VAR0s,VAR1s);
  draw();
}
