public void autoroute_selected_items(){
  if (board_is_read_only)   return;
  if (!(interactive_state instanceof StateSelectedItem))   return;
  r_board.generate_snapshot();
  interactive_action_thread=new IteraAutorouteThread(this);
  interactive_action_thread.start();
}
