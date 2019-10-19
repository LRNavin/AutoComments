public void testHitEndAfterFind(){
  hitEndTest(true,"#01.0","r((ege)|(geg))x","regexx",false);
  hitEndTest(true,"#01.1","r((ege)|(geg))x","regex",false);
  hitEndTest(true,"#01.2","r((ege)|(geg))x","rege",true);
  hitEndTest(true,"#01.2","r((ege)|(geg))x","xregexx",false);
  hitEndTest(true,"#02.0","regex","rexreger",true);
  hitEndTest(true,"#02.1","regex","raxregexr",false);
  String floatRegex=getHexFloatRegex();
  hitEndTest(true,"#03.0",floatRegex,Double.toHexString(-1.234d),true);
  hitEndTest(true,"#03.1",floatRegex,"1 ABC" + Double.toHexString(Double.NaN) + "buhuhu",false);
  hitEndTest(true,"#03.2",floatRegex,Double.toHexString(-0.0) + "--",false);
  hitEndTest(true,"#03.3",floatRegex,"--" + Double.toHexString(Double.MIN_VALUE) + "--",false);
  hitEndTest(true,"#04.0","(\\d+) fish (\\d+) fish (\\w+) fish (\\d+)","1 fish 2 fish red fish 5",true);
  hitEndTest(true,"#04.1","(\\d+) fish (\\d+) fish (\\w+) fish (\\d+)","----1 fish 2 fish red fish 5----",false);
}
