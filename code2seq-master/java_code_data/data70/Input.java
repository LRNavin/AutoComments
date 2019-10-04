public void loadMoreComplate(){
  isLoadingMoreData=false;
  if (mFooterView != null) {
    if (isManualLoadMoreData) {
      mFooterView.getLayoutParams().height=0;
    }
 else {
      mFooterView.setVisibility(GONE);
    }
  }
  getAdapter().notifyDataSetChanged();
}
