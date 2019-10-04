public static void cover(String dest,int w,int h,List<String> sources) throws Exception {
  if (sources == null) {
    throw new Exception("no source!");
  }
  int len=sources.size();
  if (len == 4 || len == 9) {
    BufferedImage src[]=new BufferedImage[len];
    for (int i=0; i < len; i++) {
      src[i]=ImageIO.read(new File(sources.get(i)));
    }
    BufferedImage out=new BufferedImage(w,h,BufferedImage.TYPE_3BYTE_BGR);
    Graphics g=out.getGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0,0,w,h);
    g.setColor(new Color(0xCCD4D0));
    int size=len == 4 ? 2 : 3;
    int space=len == 4 ? 4 : 2;
    int w1=(w - 1) / size;
    int h1=(h - 1) / size;
    float fd=((float)w1) / h1;
    for (int i=0; i < len; i++) {
      BufferedImage img=src[i];
      int w2=img.getWidth();
      int h2=img.getHeight();
      float fs=((float)w2) / h2;
      if (fs > fd) {
        w2=w1;
        h2=(int)(w2 / fs);
      }
 else       if (fs < fd) {
        h2=h1;
        w2=(int)(h2 * fs);
      }
 else {
        w2=w1;
        h2=h1;
      }
      Image tmp=img.getScaledInstance(w2,h2,Image.SCALE_SMOOTH);
      int x=(i % size) * w1;
      int y=(i / size) * h1;
      g.drawImage(tmp,x + space + (w1 - w2) / 2,y + space + (h1 - h2) / 2,w2 - 2 * space,h2 - 2 * space,null);
      g.drawRect(x,y,w1,h1);
    }
    ImageIO.write(out,"jpg",new File(dest));
  }
 else {
    throw new Exception("sources MUST is 4 or 9 picutures!" + len);
  }
}
