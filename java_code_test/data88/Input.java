private void listSelectionChanged(IStructuredSelection VAR0){
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
  ISelectionProvider VAR0Provider=editor.getSelectionProvider();
  if (VAR0Provider == null) {
    return;
  }
  ITextSelection textSelection=(ITextSelection)VAR0Provider.getSelection();
  AnnotateBlock listSelection=null;
  try {
    listSelection=(AnnotateBlock)VAR0.getFirstElement();
  }
 catch (  ClassCastException cce) {
    return;
  }
  if (listSelection == null) {
    return;
  }
  if (textSelection.getStartLine() == listSelection.getStartLine() && textSelection.getEndLine() == listSelection.getEndLine() && VAR0.equals(previousListSelection)) {
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
