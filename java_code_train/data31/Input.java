@Override protected void initData(){
  Intent intent=new Intent(this,PushMessageService.class);
  this.startService(intent);
  this.bindService(intent,this.connection,Context.BIND_AUTO_CREATE);
}
