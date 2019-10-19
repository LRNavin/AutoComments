public IntersectionMatrix(IntersectionMatrix VAR0){
  this();
  matrix[Location.INTERIOR][Location.INTERIOR]=VAR0.matrix[Location.INTERIOR][Location.INTERIOR];
  matrix[Location.INTERIOR][Location.BOUNDARY]=VAR0.matrix[Location.INTERIOR][Location.BOUNDARY];
  matrix[Location.INTERIOR][Location.EXTERIOR]=VAR0.matrix[Location.INTERIOR][Location.EXTERIOR];
  matrix[Location.BOUNDARY][Location.INTERIOR]=VAR0.matrix[Location.BOUNDARY][Location.INTERIOR];
  matrix[Location.BOUNDARY][Location.BOUNDARY]=VAR0.matrix[Location.BOUNDARY][Location.BOUNDARY];
  matrix[Location.BOUNDARY][Location.EXTERIOR]=VAR0.matrix[Location.BOUNDARY][Location.EXTERIOR];
  matrix[Location.EXTERIOR][Location.INTERIOR]=VAR0.matrix[Location.EXTERIOR][Location.INTERIOR];
  matrix[Location.EXTERIOR][Location.BOUNDARY]=VAR0.matrix[Location.EXTERIOR][Location.BOUNDARY];
  matrix[Location.EXTERIOR][Location.EXTERIOR]=VAR0.matrix[Location.EXTERIOR][Location.EXTERIOR];
}
