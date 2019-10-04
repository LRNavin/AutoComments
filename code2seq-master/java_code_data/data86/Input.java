@Override public void touchAuthorAvatar(){
  User u=User.buildUser(model.getPhoto());
  Mysplash.getInstance().setUser(u);
  view.touchAuthorAvatar();
}
