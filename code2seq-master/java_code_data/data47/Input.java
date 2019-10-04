protected void animateToState(boolean checked){
  if (mProcessAnimator == null) {
    return;
  }
  if (mProcessAnimator.isRunning()) {
    mProcessAnimator.cancel();
  }
  mProcessAnimator.setDuration(mAnimationDuration);
  if (checked) {
    mProcessAnimator.setFloatValues(mProcess,1f);
  }
 else {
    mProcessAnimator.setFloatValues(mProcess,0);
  }
  mProcessAnimator.start();
}
