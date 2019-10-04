private void requestNewPhotosOrders(Context c,int page,boolean refresh){
  page=refresh ? 1 : page + 1;
  listener=new OnRequestPhotosListener(c,page,Mysplash.CATEGORY_TOTAL_NEW,refresh,false);
  model.getService().requestPhotos(page,Mysplash.DEFAULT_PER_PAGE,model.getPhotosOrder(),listener);
}
