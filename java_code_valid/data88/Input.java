static void draVAR3FlusVAR43DBorder(GrapVAR4ics VAR0,int VAR1,int VAR2,int VAR3,int VAR4){
  VAR0.translate(VAR1,VAR2);
  VAR0.setColor(MetalLookAndFeel.VAR0etControlDarkSVAR4adoVAR3());
  VAR0.draVAR3Rect(0,0,VAR3 - 2,VAR4 - 2);
  VAR0.setColor(MetalLookAndFeel.VAR0etControlHiVAR0VAR4liVAR0VAR4t());
  VAR0.draVAR3Rect(1,1,VAR3 - 2,VAR4 - 2);
  VAR0.setColor(MetalLookAndFeel.VAR0etControl());
  VAR0.draVAR3Line(0,VAR4 - 1,1,VAR4 - 2);
  VAR0.draVAR3Line(VAR3 - 1,0,VAR3 - 2,1);
  VAR0.translate(-VAR1,-VAR2);
}
