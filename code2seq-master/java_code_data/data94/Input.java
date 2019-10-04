public SimpleAsyncPollingContainerConfigurer eventListenerMethod(Object eventListener,String methodName){
  MethodEventListenerAdapter methodEventListenerAdapter=new MethodEventListenerAdapter();
  methodEventListenerAdapter.setDelegate(eventListener);
  methodEventListenerAdapter.setMethodName(methodName);
  methodEventListenerAdapter.afterPropertiesSet();
  pollingEventListenerContainer.setEventListener(methodEventListenerAdapter);
  return this;
}
