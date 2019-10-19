public void increment(View VAR0){
  if (quantity == 100) {
    return;
  }
  quantity=quantity + 1;
  displayQuantity(quantity);
}
