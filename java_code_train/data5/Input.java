public void trimToSize(){
  ++modCount;
  if (size < elementData.length) {
    elementData=Arrays.copyOf(elementData,size);
  }
}
