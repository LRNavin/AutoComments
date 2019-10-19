private boolean isInSameEvolutionChain(Pokemon VAR0,Pokemon VAR1){
  ArrayList<Pokemon> evolutionLine=getEvolutionLine(VAR0);
  for (  Pokemon poke : evolutionLine) {
    if (poke.number == VAR1.number) {
      return true;
    }
  }
  return false;
}
