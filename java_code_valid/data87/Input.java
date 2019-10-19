private PlaLineInt smoothen_non_integer_corner(PlaLineIntAlist VAR0,int VAR1){
  PlaLineInt prev_line=VAR0.get(VAR1);
  PlaLineInt next_line=VAR0.get(VAR1 + 1);
  if (prev_line.is_equal_or_opposite(next_line)) {
    return null;
  }
  if (!(prev_line.is_diagonal() && next_line.is_diagonal())) {
    return null;
  }
  PlaPointFloat curr_corner=prev_line.intersection_approx(next_line);
  PlaPointFloat prev_corner=prev_line.intersection_approx(VAR0.get(VAR1 - 1));
  PlaPointFloat next_corner=next_line.intersection_approx(VAR0.get(VAR1 + 2));
  PlaLineInt result=null;
  int new_x=0;
  int new_y=0;
  boolean new_line_is_vertical=false;
  boolean new_line_is_horizontal=false;
  if (prev_corner.v_x > curr_corner.v_x && next_corner.v_x > curr_corner.v_x) {
    new_x=(int)Math.ceil(curr_corner.v_x);
    new_y=(int)Math.ceil(curr_corner.v_y);
    new_line_is_vertical=true;
  }
 else   if (prev_corner.v_x < curr_corner.v_x && next_corner.v_x < curr_corner.v_x) {
    new_x=(int)Math.floor(curr_corner.v_x);
    new_y=(int)Math.floor(curr_corner.v_y);
    new_line_is_vertical=true;
  }
 else   if (prev_corner.v_y > curr_corner.v_y && next_corner.v_y > curr_corner.v_y) {
    new_x=(int)Math.ceil(curr_corner.v_x);
    new_y=(int)Math.ceil(curr_corner.v_y);
    new_line_is_horizontal=true;
  }
 else   if (prev_corner.v_y < curr_corner.v_y && next_corner.v_y < curr_corner.v_y) {
    new_x=(int)Math.floor(curr_corner.v_x);
    new_y=(int)Math.floor(curr_corner.v_y);
    new_line_is_horizontal=true;
  }
  PlaDirection new_line_dir=null;
  if (new_line_is_vertical) {
    if (prev_corner.v_y < next_corner.v_y) {
      new_line_dir=PlaDirection.UP;
    }
 else {
      new_line_dir=PlaDirection.DOWN;
    }
  }
 else   if (new_line_is_horizontal) {
    if (prev_corner.v_x < next_corner.v_x) {
      new_line_dir=PlaDirection.RIGHT;
    }
 else {
      new_line_dir=PlaDirection.LEFT;
    }
  }
 else {
    return null;
  }
  PlaPointInt line_a=new PlaPointInt(new_x,new_y);
  result=new PlaLineInt(line_a,new_line_dir);
  return result;
}
