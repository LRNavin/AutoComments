public PhotosGetUploadServerQuery(VkApiClient VAR0,UserActor VAR1){
  super(VAR0,"photos.getUploadServer",PhotoUpload.class);
  accessToken(VAR1.getAccessToken());
}
