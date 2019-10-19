public static boolean isBehind(VisibleObject VAR0,VisibleObject VAR1){
  float angle=MathUtil.convertHeadingToDegree(VAR0.getHeading()) + 90;
  if (angle >= 360) {
    angle-=360;
  }
  double radian=Math.toRadians(angle);
  float x0=VAR0.getX();
  float y0=VAR0.getY();
  float x1=(float)(Math.cos(radian) * 5) + x0;
  float y1=(float)(Math.sin(radian) * 5) + y0;
  float xA=VAR1.getX();
  float yA=VAR1.getY();
  float temp=(x1 - x0) * (yA - y0) - (y1 - y0) * (xA - x0);
  return temp > 0;
}
