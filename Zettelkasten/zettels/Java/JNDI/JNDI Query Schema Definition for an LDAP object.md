#JNDI #LDAP #Schema #Enumeration

If an LDAP object is already in a directory server, you can query the schema using the `DirContext.getSchemaClassDefinition` method.

# Example
```java
// Get context containing class definitions for the "cn=Ted Geisel" entry
DirContext tedClasses = ctx.getSchemaClassDefinition("cn=Ted Geisel, ou=People");

// Enumerate the class definitions
NamingEnumeration namingEnum = tedClasses.search("", null);
while (namingEnum.hasMore()) {
    System.out.println(namingEnum.next());
}
```

See [full source of example](https://docs.oracle.com/javase/jndi/tutorial/ldap/schema/src/GetClassDefn.java), `NamingEnumuration<SearchResult>` [docs](https://docs.oracle.com/javase/8/docs/api/javax/naming/NamingEnumeration.html), and `SearchResult` [docs](https://docs.oracle.com/javase/8/docs/api/javax/naming/directory/SearchResult.html)  17.5 