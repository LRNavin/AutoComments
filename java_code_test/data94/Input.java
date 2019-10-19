public SimpleAsyncPollingContainerConfigurer VAR0Method(Object VAR0,String VAR1){
  MethodEventListenerAdapter methodEventListenerAdapter=new MethodEventListenerAdapter();
  methodEventListenerAdapter.setDelegate(VAR0);
  methodEventListenerAdapter.setMethodName(VAR1);
  methodEventListenerAdapter.afterPropertiesSet();
  pollingEventListenerContainer.setEventListener(methodEventListenerAdapter);
  return this;
}
