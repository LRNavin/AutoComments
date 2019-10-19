public void new_line() throws IOException {
  write("\n");
  for (int i=0; i < current_indent_level; ++i)   write(INDENT_STRING);
}
