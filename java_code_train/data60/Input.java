protected void copyToOpsw(){
  opsw[1]=fullmode.isSelected();
  opsw[2]=twoaspects.isSelected();
  opsw[11]=semaphore.isSelected();
  opsw[12]=pulsed.isSelected();
  opsw[13]=disableDS.isSelected();
  opsw[14]=fromloconet.isSelected();
  opsw[15]=disablelocal.isSelected();
  opsw[17]=sigaddress.isSelected();
  opsw[18]=bcastaddress.isSelected();
  opsw[19]=semaddress.isSelected();
  opsw[20]=setdefault.isSelected();
  opsw[21]=exercise.isSelected();
  int value=section1to4mode.getSelectedIndex();
  if ((value & 0x01) != 0) {
    opsw[5]=true;
  }
 else {
    opsw[5]=false;
  }
  if ((value & 0x02) != 0) {
    opsw[4]=true;
  }
 else {
    opsw[4]=false;
  }
  if ((value & 0x04) != 0) {
    opsw[3]=true;
  }
 else {
    opsw[3]=false;
  }
  value=section5to8mode.getSelectedIndex();
  if ((value & 0x01) != 0) {
    opsw[8]=true;
  }
 else {
    opsw[8]=false;
  }
  if ((value & 0x02) != 0) {
    opsw[7]=true;
  }
 else {
    opsw[7]=false;
  }
  if ((value & 0x04) != 0) {
    opsw[6]=true;
  }
 else {
    opsw[6]=false;
  }
  value=fourthAspect.getSelectedIndex();
  if ((value & 0x01) != 0) {
    opsw[10]=true;
  }
 else {
    opsw[10]=false;
  }
  if ((value & 0x02) != 0) {
    opsw[9]=true;
  }
 else {
    opsw[9]=false;
  }
}
