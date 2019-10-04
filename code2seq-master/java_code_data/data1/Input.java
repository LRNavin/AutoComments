public void checkNextPoissonConsistency(double mean){
  final int sampleSize=1000;
  final int minExpectedCount=7;
  long maxObservedValue=0;
  final double alpha=0.001;
  UnitTestUtils.Frequency<Long> frequency=new UnitTestUtils.Frequency<Long>();
  for (int i=0; i < sampleSize; i++) {
    long value=randomData.nextPoisson(mean);
    if (value > maxObservedValue) {
      maxObservedValue=value;
    }
    frequency.addValue(value);
  }
  PoissonDistribution poissonDistribution=new PoissonDistribution(mean);
  int lower=1;
  while (poissonDistribution.cumulativeProbability(lower - 1) * sampleSize < minExpectedCount) {
    lower++;
  }
  int upper=(int)(5 * mean);
  while ((1 - poissonDistribution.cumulativeProbability(upper - 1)) * sampleSize < minExpectedCount) {
    upper--;
  }
  int binWidth=0;
  boolean widthSufficient=false;
  double lowerBinMass=0;
  double upperBinMass=0;
  while (!widthSufficient) {
    binWidth++;
    lowerBinMass=poissonDistribution.probability(lower - 1,lower + binWidth - 1);
    upperBinMass=poissonDistribution.probability(upper - binWidth - 1,upper - 1);
    widthSufficient=FastMath.min(lowerBinMass,upperBinMass) * sampleSize >= minExpectedCount;
  }
  List<Integer> binBounds=new ArrayList<Integer>();
  binBounds.add(lower);
  int bound=lower + binWidth;
  while (bound < upper - binWidth) {
    binBounds.add(bound);
    bound+=binWidth;
  }
  binBounds.add(upper);
  final int binCount=binBounds.size() + 1;
  long[] observed=new long[binCount];
  double[] expected=new double[binCount];
  observed[0]=0;
  for (int i=0; i < lower; i++) {
    observed[0]+=frequency.getCount((long)i);
  }
  expected[0]=poissonDistribution.cumulativeProbability(lower - 1) * sampleSize;
  observed[binCount - 1]=0;
  for (int i=upper; i <= maxObservedValue; i++) {
    observed[binCount - 1]+=frequency.getCount((long)i);
  }
  expected[binCount - 1]=(1 - poissonDistribution.cumulativeProbability(upper - 1)) * sampleSize;
  for (int i=1; i < binCount - 1; i++) {
    observed[i]=0;
    for (int j=binBounds.get(i - 1); j < binBounds.get(i); j++) {
      observed[i]+=frequency.getCount((long)j);
    }
    expected[i]=(poissonDistribution.cumulativeProbability(binBounds.get(i) - 1) - poissonDistribution.cumulativeProbability(binBounds.get(i - 1) - 1)) * sampleSize;
  }
  if (UnitTestUtils.chiSquareTest(expected,observed) < alpha) {
    StringBuilder msgBuffer=new StringBuilder();
    DecimalFormat df=new DecimalFormat("#.##");
    msgBuffer.append("Chisquare test failed for mean = ");
    msgBuffer.append(mean);
    msgBuffer.append(" p-value = ");
    msgBuffer.append(UnitTestUtils.chiSquareTest(expected,observed));
    msgBuffer.append(" chisquare statistic = ");
    msgBuffer.append(UnitTestUtils.chiSquare(expected,observed));
    msgBuffer.append(". \n");
    msgBuffer.append("bin\t\texpected\tobserved\n");
    for (int i=0; i < expected.length; i++) {
      msgBuffer.append("[");
      msgBuffer.append(i == 0 ? 1 : binBounds.get(i - 1));
      msgBuffer.append(",");
      msgBuffer.append(i == binBounds.size() ? "inf" : binBounds.get(i));
      msgBuffer.append(")");
      msgBuffer.append("\t\t");
      msgBuffer.append(df.format(expected[i]));
      msgBuffer.append("\t\t");
      msgBuffer.append(observed[i]);
      msgBuffer.append("\n");
    }
    msgBuffer.append("This test can fail randomly due to sampling error with probability ");
    msgBuffer.append(alpha);
    msgBuffer.append(".");
    Assert.fail(msgBuffer.toString());
  }
}
