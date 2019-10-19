public void zoomOut(){
  Matrix save=mViewPortHandler.zoomOut(getWidth() / 2f,-(getHeight() / 2f));
  mViewPortHandler.refresh(save,this,true);
}
