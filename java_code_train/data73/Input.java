private boolean VAR0IsGwtXmlAndInGwt(IResource VAR0) throws CoreException {
  return GWTNature.isGWTProject(VAR0.getProject()) && VAR0.getName().endsWith(".gwt.xml");
}
