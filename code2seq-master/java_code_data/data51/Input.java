public FriendsAddQuery(VkApiClient client,UserActor actor,int userId){
  super(client,"friends.add",AddResponse.class);
  accessToken(actor.getAccessToken());
  userId(userId);
}
