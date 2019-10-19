public void processMouseEvent(MouseEvent VAR0){
  int screenX, screenY;
  Point p;
  int i, c, j, d;
  Component mc;
  Rectangle r2;
  int cWidth, cHeight;
  MenuElement menuElement;
  MenuElement subElements[];
  MenuElement path[];
  Vector<MenuElement> tmp;
  int selectionSize;
  p=VAR0.getPoint();
  Component source=VAR0.getComponent();
  if ((source != null) && !source.isShowing()) {
    return;
  }
  int type=VAR0.getID();
  int modifiers=VAR0.getModifiers();
  if ((type == MouseEvent.MOUSE_ENTERED || type == MouseEvent.MOUSE_EXITED) && ((modifiers & (InputEvent.BUTTON1_MASK | InputEvent.BUTTON2_MASK | InputEvent.BUTTON3_MASK)) != 0)) {
    return;
  }
  if (source != null) {
    SwingUtilities.convertPointToScreen(p,source);
  }
  screenX=p.x;
  screenY=p.y;
  tmp=(Vector<MenuElement>)selection.clone();
  selectionSize=tmp.size();
  boolean success=false;
  for (i=selectionSize - 1; i >= 0 && success == false; i--) {
    menuElement=(MenuElement)tmp.elementAt(i);
    subElements=menuElement.getSubElements();
    path=null;
    for (j=0, d=subElements.length; j < d && success == false; j++) {
      if (subElements[j] == null)       continue;
      mc=subElements[j].getComponent();
      if (!mc.isShowing())       continue;
      if (mc instanceof JComponent) {
        cWidth=mc.getWidth();
        cHeight=mc.getHeight();
      }
 else {
        r2=mc.getBounds();
        cWidth=r2.width;
        cHeight=r2.height;
      }
      p.x=screenX;
      p.y=screenY;
      SwingUtilities.convertPointFromScreen(p,mc);
      if ((p.x >= 0 && p.x < cWidth && p.y >= 0 && p.y < cHeight)) {
        int k;
        if (path == null) {
          path=new MenuElement[i + 2];
          for (k=0; k <= i; k++)           path[k]=(MenuElement)tmp.elementAt(k);
        }
        path[i + 1]=subElements[j];
        MenuElement currentSelection[]=getSelectedPath();
        if (currentSelection[currentSelection.length - 1] != path[i + 1] && (currentSelection.length < 2 || currentSelection[currentSelection.length - 2] != path[i + 1])) {
          Component oldMC=currentSelection[currentSelection.length - 1].getComponent();
          MouseEvent exitEvent=new MouseEvent(oldMC,MouseEvent.MOUSE_EXITED,VAR0.getWhen(),VAR0.getModifiers(),p.x,p.y,VAR0.getXOnScreen(),VAR0.getYOnScreen(),VAR0.getClickCount(),VAR0.isPopupTrigger(),MouseEvent.NOBUTTON);
          currentSelection[currentSelection.length - 1].processMouseEvent(exitEvent,path,this);
          MouseEvent enterEvent=new MouseEvent(mc,MouseEvent.MOUSE_ENTERED,VAR0.getWhen(),VAR0.getModifiers(),p.x,p.y,VAR0.getXOnScreen(),VAR0.getYOnScreen(),VAR0.getClickCount(),VAR0.isPopupTrigger(),MouseEvent.NOBUTTON);
          subElements[j].processMouseEvent(enterEvent,path,this);
        }
        MouseEvent mouseEvent=new MouseEvent(mc,VAR0.getID(),VAR0.getWhen(),VAR0.getModifiers(),p.x,p.y,VAR0.getXOnScreen(),VAR0.getYOnScreen(),VAR0.getClickCount(),VAR0.isPopupTrigger(),MouseEvent.NOBUTTON);
        subElements[j].processMouseEvent(mouseEvent,path,this);
        success=true;
        VAR0.consume();
      }
    }
  }
}
