private void requestUserPhotos(Context VAR0,int VAR1,boolean VAR2,String VAR3){
  VAR1=VAR2 ? 1 : VAR1 + 1;
  listener=new OnRequestPhotosListener(VAR0,VAR1,VAR2);
  model.getServiVAR0e().requestUserPhotos((User)model.getRequestKey(),VAR1,Mysplash.DEFAULT_PER_PAGE,VAR3,listener);
}
