public RqMtFake(final Request VAR0,final Request... VAR1) throws IOException {
  this.fake=new RqMtBase(new RqMtFake.FakeMultipartRequest(VAR0,VAR1));
}
