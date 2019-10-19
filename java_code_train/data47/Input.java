public static RefactoringStatus create(IStatus VAR0){
  if (VAR0.isOK())   return new RefactoringStatus();
  if (!VAR0.isMultiStatus()) {
switch (VAR0.getSeverity()) {
case IStatus.OK:
      return new RefactoringStatus();
case IStatus.INFO:
    return RefactoringStatus.createWarningStatus(VAR0.getMessage());
case IStatus.WARNING:
  return RefactoringStatus.createErrorStatus(VAR0.getMessage());
case IStatus.ERROR:
return RefactoringStatus.createFatalErrorStatus(VAR0.getMessage());
case IStatus.CANCEL:
return RefactoringStatus.createFatalErrorStatus(VAR0.getMessage());
default :
return RefactoringStatus.createFatalErrorStatus(VAR0.getMessage());
}
}
 else {
IStatus[] children=VAR0.getChildren();
RefactoringStatus result=new RefactoringStatus();
for (int i=0; i < children.length; i++) {
result.merge(RefactoringStatus.create(children[i]));
}
return result;
}
}
