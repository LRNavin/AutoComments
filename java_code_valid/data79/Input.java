@Override public void execute() throws BuildException {
  if (path == null) {
    throw new BuildException("Must specify 'path'");
  }
  File file=new File(path,Constants.ApplicationWebXml);
  if (!file.canRead()) {
    throw new BuildException("Cannot find web.xml");
  }
  ClassLoader oldCL=Thread.currentThread().getContextClassLoader();
  Thread.currentThread().setContextClassLoader(ValidatorTask.class.getClassLoader());
  Digester digester=DigesterFactory.newDigester(true,true,null,Globals.IS_SECURITY_ENABLED);
  try (InputStream stream=new BufferedInputStream(new FileInputStream(file.getCanonicalFile()))){
    InputSource is=new InputSource(file.toURI().toURL().toExternalForm());
    is.setByteStream(stream);
    digester.parse(is);
    handleOutput("web.xml validated");
  }
 catch (  Exception e) {
    if (isFailOnError()) {
      throw new BuildException("Validation failure",e);
    }
 else {
      handleErrorOutput("Validation failure: " + e);
    }
  }
 finally {
    Thread.currentThread().setContextClassLoader(oldCL);
    closeRedirector();
  }
}
