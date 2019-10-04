private void listSelectionChanged(IStructuredSelection selection){
  if (editor == null || editor.getSelectionProvider() == null) {
    try {
      contents.reset();
      showAnnotations(svnFile,svnAnnotateBlocks,contents,false);
    }
 catch (    PartInitException e) {
      return;
    }
catch (    IOException e) {
      return;
    }
  }
  ISelectionProvider selectionProvider=editor.getSelectionProvider();
  if (selectionProvider == null) {
    return;
  }
  ITextSelection textSelection=(ITextSelection)selectionProvider.getSelection();
  AnnotateBlock listSelection=null;
  try {
    listSelection=(AnnotateBlock)selection.getFirstElement();
  }
 catch (  ClassCastException cce) {
    return;
  }
  if (listSelection == null) {
    return;
  }
  if (textSelection.getStartLine() == listSelection.getStartLine() && textSelection.getEndLine() == listSelection.getEndLine() && selection.equals(previousListSelection)) {
    return;
  }
  if (!lastSelectionWasText) {
    try {
      int start=document.getLineOffset(listSelection.getStartLine());
      int end=document.getLineOffset(listSelection.getEndLine() + 1);
      editor.selectAndReveal(start,end - start);
      if (editor != null && !page.isPartVisible(editor)) {
        page.activate(editor);
      }
    }
 catch (    BadLocationException e) {
    }
  }
  if (historyView != null) {
    SVNHistoryPage page=(SVNHistoryPage)historyView.getHistoryPage();
    page.selectRevision(new SVNRevision.Number(listSelection.getRevision()));
  }
  lastSelectionWasText=false;
}
