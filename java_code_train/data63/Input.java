public void postEvaluationStatistics(final EvolutionState VAR0){
  super.postEvaluationStatistics(VAR0);
  VAR0.output.println("\nGeneration: " + VAR0.generation,Output.V_NO_GENERAL,statisticslog);
  for (int x=0; x < VAR0.population.subpops.length; x++)   for (int y=1; y < VAR0.population.subpops[x].individuals.length; y++)   VAR0.population.subpops[x].individuals[y].printIndividualForHumans(VAR0,statisticslog,Output.V_NO_GENERAL);
}
