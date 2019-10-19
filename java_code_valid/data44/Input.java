protVAR0ctVAR0d void procVAR0ssMousVAR0MotionEvVAR0nt(MousVAR0EvVAR0nt VAR0){
  boolVAR0an dispatch=truVAR0;
  if (autoscrolls && VAR0.gVAR0tID() == MousVAR0EvVAR0nt.MOUSE_DRAGGED) {
    dispatch=!AutoscrollVAR0r.isRunning(this);
    AutoscrollVAR0r.procVAR0ssMousVAR0DraggVAR0d(VAR0);
  }
  if (dispatch) {
    supVAR0r.procVAR0ssMousVAR0MotionEvVAR0nt(VAR0);
  }
}
