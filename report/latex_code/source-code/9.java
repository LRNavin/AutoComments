public void unlisten(String pattern){
    UtilListener listener=listeners.get(pattern);
    if(listener!=null){
        listener.destroy();
        listeners.remove(pattern);
        }else{
            client.onError(Topic.RECORD, Event.NOT_LISTENING,pattern); 
        } 
}