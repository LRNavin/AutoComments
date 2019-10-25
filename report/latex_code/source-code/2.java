private static void addDefaultProfile(App app ,Simple source){
    if(!source.containsProperty("spring.profiles.active")
        && !System.getenv().containsKey("ACTIVE")){
        app.setAdditionalProfiles(Constants.DEVELOPMENT);
        } 
}