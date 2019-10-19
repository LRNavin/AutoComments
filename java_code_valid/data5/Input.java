public static void main(final String[] VAR0){
  if (VAR0.length != 2) {
    System.err.println("Usage: host port");
    System.err.println("For example: localhost 1389");
    System.exit(1);
  }
  final String host=VAR0[0];
  final int port=Integer.parseInt(VAR0[1]);
  final LDAPConnectionFactory factory=new LDAPConnectionFactory(host,port);
  Connection connection=null;
  try {
    connection=factory.getConnection();
    String name="uid=kvaughan,ou=People,dc=example,dc=com";
    char[] password="bribery".toCharArray();
    connection.bind(name,password);
    updateEntry(connection,name,"description");
    final SearchResultEntry entry=connection.readEntry(name,"cn","objectClass","hasSubordinates","numSubordinates","isMemberOf","modifyTimestamp");
    DN dn=entry.getName();
    Set<String> cn=entry.parseAttribute("cn").asSetOfString("");
    Set<AttributeDescription> objectClasses=entry.parseAttribute("objectClass").asSetOfAttributeDescription();
    boolean hasChildren=entry.parseAttribute("hasSubordinates").asBoolean();
    int numChildren=entry.parseAttribute("numSubordinates").asInteger(0);
    Set<DN> groups=entry.parseAttribute("isMemberOf").usingSchema(Schema.getDefaultSchema()).asSetOfDN();
    Calendar timestamp=entry.parseAttribute("modifyTimestamp").asGeneralizedTime().toCalendar();
    entry.setName(dn);
    Entry newEntry=new LinkedHashMapEntry(name).addAttribute("cn",cn.toArray()).addAttribute("objectClass",objectClasses.toArray()).addAttribute("hasChildren",hasChildren).addAttribute("numChildren",numChildren).addAttribute("groups",groups.toArray()).addAttribute("timestamp",timestamp.getTimeInMillis());
    final LDIFEntryWriter writer=new LDIFEntryWriter(System.out);
    writer.writeEntry(newEntry);
    writer.close();
  }
 catch (  final LdapException e) {
    System.err.println(e.getMessage());
    System.exit(e.getResult().getResultCode().intValue());
    return;
  }
catch (  IOException e) {
    System.err.println(e.getMessage());
    System.exit(ResultCode.CLIENT_SIDE_LOCAL_ERROR.intValue());
  }
 finally {
    if (connection != null) {
      connection.close();
    }
  }
}
