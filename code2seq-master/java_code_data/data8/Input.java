private boolean isInSameEvolutionChain(Pokemon p1,Pokemon p2){
  ArrayList<Pokemon> evolutionLine=getEvolutionLine(p1);
  for (  Pokemon poke : evolutionLine) {
    if (poke.number == p2.number) {
      return true;
    }
  }
  return false;
}
