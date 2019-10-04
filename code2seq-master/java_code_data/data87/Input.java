private void requestUserPhotos(Context c,int page,boolean refresh,String order){
  page=refresh ? 1 : page + 1;
  listener=new OnRequestPhotosListener(c,page,refresh);
  model.getService().requestUserPhotos((User)model.getRequestKey(),page,Mysplash.DEFAULT_PER_PAGE,order,listener);
}
