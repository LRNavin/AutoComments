public static boolean isBehind(VisibleObject object1,VisibleObject object2){
  float angle=MathUtil.convertHeadingToDegree(object1.getHeading()) + 90;
  if (angle >= 360) {
    angle-=360;
  }
  double radian=Math.toRadians(angle);
  float x0=object1.getX();
  float y0=object1.getY();
  float x1=(float)(Math.cos(radian) * 5) + x0;
  float y1=(float)(Math.sin(radian) * 5) + y0;
  float xA=object2.getX();
  float yA=object2.getY();
  float temp=(x1 - x0) * (yA - y0) - (y1 - y0) * (xA - x0);
  return temp > 0;
}
