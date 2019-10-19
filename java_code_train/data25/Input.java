public void testFileDeletion() throws Exception {
  File testDir=createTestDir("testFileDeletion");
  String prefix1="testFileDeletion1";
  File[] files1=createFiles(testDir,prefix1,5);
  String prefix2="testFileDeletion2";
  File[] files2=createFiles(testDir,prefix2,5);
  FileCommands.deleteFiles(files1,true);
  assertNotExists(files1);
  FileCommands.deleteFiles(files2,false);
  Thread.sleep(1000);
  assertNotExists(files2);
}
