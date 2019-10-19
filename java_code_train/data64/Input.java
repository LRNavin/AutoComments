private void checkUserExists(String VAR0) throws Exception {
  int count;
  UsersTable table=new UsersTable();
  DbConnection dbConn=new DbConnection();
  try {
    dbConn.open(DBSessionManager.getSession());
    if (_id == ISicresAdminDefsKeys.NULL_ID)     count=DbSelectFns.selectCount(dbConn,table.getBaseTableName(),table.getCountNameQual(_name));
 else     count=DbSelectFns.selectCount(dbConn,table.getBaseTableName(),table.getCountNameIdQual(_id,_name));
    if (count > 0)     ISicresAdminBasicException.throwException(ISicresAdminUserKeys.EC_USER_EXISTS_NAME);
  }
 catch (  Exception e) {
    _logger.error(e);
    throw e;
  }
 finally {
    dbConn.close();
  }
}
