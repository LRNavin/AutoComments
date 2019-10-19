public PluginResult.PostOperation invokePostOperationExtendedPlugins(PostOperationExtendedOperation VAR0){
  PluginResult.PostOperation result=null;
  PluginResult.PostOperation finalResult=null;
  ArrayList<DirectoryServerPlugin> skippedPlugins=skippedPreOperationPlugins.remove(VAR0);
  for (  DirectoryServerPlugin p : postOperationExtendedPlugins) {
    if (isInternalOperation(VAR0,p) || isSkipped(skippedPlugins,p)) {
      continue;
    }
    try {
      result=p.doPostOperation(VAR0);
    }
 catch (    Exception e) {
      logException(VAR0,p,e,ERR_PLUGIN_POST_OPERATION_PLUGIN_EXCEPTION);
    }
    if (result == null) {
      logNullResult(VAR0,p,ERR_PLUGIN_POST_OPERATION_PLUGIN_RETURNED_NULL);
    }
 else     if (!result.continueProcessing()) {
      finalResult=result;
    }
  }
  if (result == null) {
    finalResult=PluginResult.PostOperation.continueOperationProcessing();
  }
 else   if (finalResult == null) {
    finalResult=result;
  }
  return finalResult;
}
