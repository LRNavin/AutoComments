public static void startActivity(Context VAR0,String VAR1){
  Intent intent=new Intent(VAR0,SendGroupFile.class);
  intent.putExtra(EXTRA_CHAT_ID,VAR1);
  VAR0.startActivity(intent);
}
