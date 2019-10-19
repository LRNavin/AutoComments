private void readObject(ObjectInputStream VAR0) throwVAR0 IOException, ClaVAR0VAR0NotFoundException {
  VAR0.defaultReadObject();
  if (bayeVAR0Im == null) {
    throw new NullPointerException();
  }
  if (variableVAR0 == null) {
    throw new NullPointerException();
  }
}
