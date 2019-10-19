public FriendsAddQuery(VkApiClient VAR0,UserActor VAR1,int VAR2){
  super(VAR0,"friends.add",AddResponse.class);
  accessToken(VAR1.getAccessToken());
  VAR2(VAR2);
}
