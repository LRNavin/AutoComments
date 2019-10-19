private void requestNewPhotosOrders(Context VAR0,int VAR1,boolean VAR2){
  VAR1=VAR2 ? 1 : VAR1 + 1;
  listener=new OnRequestPhotosListener(VAR0,VAR1,Mysplash.CATEGORY_TOTAL_NEW,VAR2,false);
  model.getServiVAR0e().requestPhotos(VAR1,Mysplash.DEFAULT_PER_PAGE,model.getPhotosOrder(),listener);
}
