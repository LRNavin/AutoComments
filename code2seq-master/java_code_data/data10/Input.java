public PhotosGetUploadServerQuery(VkApiClient client,UserActor actor){
  super(client,"photos.getUploadServer",PhotoUpload.class);
  accessToken(actor.getAccessToken());
}
