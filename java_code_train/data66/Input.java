protected void generateNewCursorBox(){
  if ((old_m_x2 != -1) || (old_m_y2 != -1) || (Math.abs(commonValues.m_x2 - old_m_x2) > 5)|| (Math.abs(commonValues.m_y2 - old_m_y2) > 5)) {
    int top_x=commonValues.m_x1;
    if (commonValues.m_x1 > commonValues.m_x2) {
      top_x=commonValues.m_x2;
    }
    int top_y=commonValues.m_y1;
    if (commonValues.m_y1 > commonValues.m_y2) {
      top_y=commonValues.m_y2;
    }
    final int w=Math.abs(commonValues.m_x2 - commonValues.m_x1);
    final int h=Math.abs(commonValues.m_y2 - commonValues.m_y1);
    final int[] currentRectangle={top_x,top_y,w,h};
    decode_pdf.updateCursorBoxOnScreen(currentRectangle,DecoderOptions.highlightColor.getRGB());
    if (!currentCommands.extractingAsImage) {
      final int[] r={commonValues.m_x1,commonValues.m_y1,commonValues.m_x2 - commonValues.m_x1,commonValues.m_y2 - commonValues.m_y1};
      decode_pdf.getTextLines().addHighlights(new int[][]{r},false,commonValues.getCurrentPage());
    }
    old_m_x2=commonValues.m_x2;
    old_m_y2=commonValues.m_y2;
  }
  decode_pdf.repaintPane(commonValues.getCurrentPage());
}
