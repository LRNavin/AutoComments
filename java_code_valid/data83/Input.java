private int run(final String VAR0,final StringArgument VAR1,final StringArgument VAR2,final IntegerArgument VAR3,final StringArgument VAR4,final IntegerArgument VAR5){
  LDIFEntryWriter writer=null;
  try (EntryGenerator generator=createGenerator(VAR0,VAR1,VAR3,VAR4)){
    if (generator == null) {
      return EXIT_CODE_FAILURE;
    }
    if (generator.hasWarnings()) {
      for (      LocalizableMessage warn : generator.getWarnings()) {
        errPrintln(warn);
      }
    }
    try {
      writer=createLdifWriter(VAR2,VAR5);
    }
 catch (    final IOException e) {
      errPrintln(ERR_MAKELDIF_UNABLE_TO_CREATE_LDIF.get(VAR2.getValue(),e.getMessage()));
      return EXIT_CODE_FAILURE;
    }
catch (    final ArgumentException e) {
      errPrintln(ERR_ERROR_PARSING_ARGS.get(e.getMessageObject()));
      return EXIT_CODE_FAILURE;
    }
    if (!generateEntries(generator,writer,VAR2)) {
      return EXIT_CODE_FAILURE;
    }
    errPrintln(INFO_MAKELDIF_PROCESSING_COMPLETE.get(numberOfEntriesWritten));
    return EXIT_CODE_SUCCESS;
  }
  finally {
    closeSilently(writer);
  }
}
