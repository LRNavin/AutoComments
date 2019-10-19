private void detach(){
  if (prevTakeIndex >= 0) {
    prevTakeIndex=DETACHED;
    itrs.doSomeSweeping(true);
  }
}
