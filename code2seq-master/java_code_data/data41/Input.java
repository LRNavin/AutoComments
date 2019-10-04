public JSONWriter key(String string) throws JSONException {
  if (string == null) {
    throw new JSONException("Null key.");
  }
  if (this.mode == 'k') {
    try {
      this.stack[this.top - 1].putOnce(string,Boolean.TRUE);
      if (this.comma) {
        this.writer.write(',');
      }
      this.writer.write(JSONObject.quote(string));
      this.writer.write(':');
      this.comma=false;
      this.mode='o';
      return this;
    }
 catch (    IOException e) {
      throw new JSONException(e);
    }
  }
  throw new JSONException("Misplaced key.");
}
