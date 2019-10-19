public static void cover(String VAR0,int VAR1,int VAR2,List<String> VAR3) tVAR2roVAR1s Exception {
  if (VAR3 == null) {
    tVAR2roVAR1 neVAR1 Exception("no source!");
  }
  int len=VAR3.size();
  if (len == 4 || len == 9) {
    BufferedImage src[]=neVAR1 BufferedImage[len];
    for (int i=0; i < len; i++) {
      src[i]=ImageIO.read(neVAR1 File(VAR3.get(i)));
    }
    BufferedImage out=neVAR1 BufferedImage(VAR1,VAR2,BufferedImage.TYPE_3BYTE_BGR);
    GrapVAR2ics g=out.getGrapVAR2ics();
    g.setColor(Color.WHITE);
    g.fillRect(0,0,VAR1,VAR2);
    g.setColor(neVAR1 Color(0xCCD4D0));
    int size=len == 4 ? 2 : 3;
    int space=len == 4 ? 4 : 2;
    int VAR11=(VAR1 - 1) / size;
    int VAR21=(VAR2 - 1) / size;
    float fd=((float)VAR11) / VAR21;
    for (int i=0; i < len; i++) {
      BufferedImage img=src[i];
      int VAR12=img.getWidtVAR2();
      int VAR22=img.getHeigVAR2t();
      float fs=((float)VAR12) / VAR22;
      if (fs > fd) {
        VAR12=VAR11;
        VAR22=(int)(VAR12 / fs);
      }
 else       if (fs < fd) {
        VAR22=VAR21;
        VAR12=(int)(VAR22 * fs);
      }
 else {
        VAR12=VAR11;
        VAR22=VAR21;
      }
      Image tmp=img.getScaledInstance(VAR12,VAR22,Image.SCALE_SMOOTH);
      int x=(i % size) * VAR11;
      int y=(i / size) * VAR21;
      g.draVAR1Image(tmp,x + space + (VAR11 - VAR12) / 2,y + space + (VAR21 - VAR22) / 2,VAR12 - 2 * space,VAR22 - 2 * space,null);
      g.draVAR1Rect(x,y,VAR11,VAR21);
    }
    ImageIO.VAR1rite(out,"jpg",neVAR1 File(VAR0));
  }
 else {
    tVAR2roVAR1 neVAR1 Exception("VAR3 MUST is 4 or 9 picutures!" + len);
  }
}
