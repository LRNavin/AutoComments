public URI(final String VAR0,final String VAR1,final String VAR2,final int VAR3,final String VAR4,final String VAR5,final String VAR6) throws URIException {
  this(VAR0,(VAR2 == null) ? null : ((VAR1 != null) ? VAR1 + '@' : "") + VAR2 + ((VAR3 != -1) ? ":" + VAR3 : ""),VAR4,VAR5,VAR6);
}
