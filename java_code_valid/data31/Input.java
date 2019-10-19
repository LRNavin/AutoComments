AccessControlContext optimize(){
  AccessControlContext acc;
  DomainCombiner combiner=null;
  AccessControlContext parent=null;
  Permission[] permissions=null;
  if (isPrivileged) {
    acc=privilegedContext;
    if (acc != null) {
      if (acc.isWrapped) {
        permissions=acc.permissions;
        parent=acc.parent;
      }
    }
  }
 else {
    acc=AccessController.getInheritedAccessControlContext();
    if (acc != null) {
      if (acc.isLimited) {
        parent=acc;
      }
    }
  }
  boolean skipStack=(context == null);
  boolean skipAssigned=(acc == null || acc.context == null);
  ProtectionDomain[] assigned=(skipAssigned) ? null : acc.context;
  ProtectionDomain[] pd;
  boolean skipLimited=((acc == null || !acc.isWrapped) && parent == null);
  if (acc != null && acc.combiner != null) {
    if (getDebug() != null) {
      debug.println("AccessControlContext invoking the Combiner");
    }
    combiner=acc.combiner;
    pd=combiner.combine(context,assigned);
  }
 else {
    if (skipStack) {
      if (skipAssigned) {
        calculateFields(acc,parent,permissions);
        return this;
      }
 else       if (skipLimited) {
        return acc;
      }
    }
 else     if (assigned != null) {
      if (skipLimited) {
        if (context.length == 1 && context[0] == assigned[0]) {
          return acc;
        }
      }
    }
    pd=combine(context,assigned);
    if (skipLimited && !skipAssigned && pd == assigned) {
      return acc;
    }
 else     if (skipAssigned && pd == context) {
      calculateFields(acc,parent,permissions);
      return this;
    }
  }
  this.context=pd;
  this.combiner=combiner;
  this.isPrivileged=false;
  calculateFields(acc,parent,permissions);
  return this;
}
