public DefaultJobRowBuilder(Function<Map<JobField,String>,String> idGenerator,Function<SecurityContext,String> userIdExtractor,Clock timestampGenerator){
  this.idGenerator=idGenerator;
  this.userIdExtractor=userIdExtractor;
  this.timestampGenerator=timestampGenerator;
}
