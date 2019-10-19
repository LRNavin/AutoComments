public PdfName generate(PdfResources VAR0){
  PdfName newName=new PdfName(prefix + counter++);
  PdfDictionary r=VAR0.getPdfObject();
  if (r.containsKey(resourceType)) {
    while (r.getAsDictionary(resourceType).containsKey(newName)) {
      newName=new PdfName(prefix + counter++);
    }
  }
  return newName;
}
