protected void animateToState(boolean VAR0){
  if (mProcessAnimator == null) {
    return;
  }
  if (mProcessAnimator.isRunning()) {
    mProcessAnimator.cancel();
  }
  mProcessAnimator.setDuration(mAnimationDuration);
  if (VAR0) {
    mProcessAnimator.setFloatValues(mProcess,1f);
  }
 else {
    mProcessAnimator.setFloatValues(mProcess,0);
  }
  mProcessAnimator.start();
}
