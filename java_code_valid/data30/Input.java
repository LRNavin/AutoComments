public boolean check_move(){
  if (!all_items_movable)   return false;
  TimeLimit time_limit=new TimeLimit(3);
  Collection<BrdItem> ignore_items=new LinkedList<BrdItem>();
  for (  SortedItemDouble an_item : item_group_arr) {
    boolean move_ok;
    if (an_item.item instanceof BrdAbit) {
      BrdAbit curr_drill_item=(BrdAbit)an_item.item;
      if (translate_vector.distance() >= curr_drill_item.min_width()) {
        move_ok=false;
      }
 else {
        move_ok=r_board.move_drill_algo.check(curr_drill_item,translate_vector,max_recursion_depth,max_via_recursion_depth,ignore_items,time_limit);
      }
    }
 else {
      move_ok=r_board.check_item_move(an_item.item,translate_vector,ignore_items);
    }
    if (!move_ok)     return false;
  }
  return true;
}
