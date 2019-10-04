public synchronized void openDriver(SurfaceHolder holder) throws IOException {
  Camera theCamera=camera;
  if (theCamera == null) {
    if (requestedCameraId >= 0) {
      theCamera=OpenCameraInterface.open(requestedCameraId);
    }
 else {
      theCamera=OpenCameraInterface.open();
    }
    if (theCamera == null) {
      throw new IOException();
    }
    camera=theCamera;
  }
  theCamera.setPreviewDisplay(holder);
  if (!initialized) {
    initialized=true;
    configManager.initFromCameraParameters(theCamera);
  }
  Camera.Parameters parameters=theCamera.getParameters();
  String parametersFlattened=parameters == null ? null : parameters.flatten();
  try {
    configManager.setDesiredCameraParameters(theCamera,false);
  }
 catch (  RuntimeException re) {
    Log.w(TAG,"Camera rejected parameters. Setting only minimal safe-mode parameters");
    Log.i(TAG,"Resetting to saved camera params: " + parametersFlattened);
    if (parametersFlattened != null) {
      parameters=theCamera.getParameters();
      parameters.unflatten(parametersFlattened);
      try {
        theCamera.setParameters(parameters);
        configManager.setDesiredCameraParameters(theCamera,true);
      }
 catch (      RuntimeException re2) {
        Log.w(TAG,"Camera rejected even safe-mode parameters! No configuration");
      }
    }
  }
}
