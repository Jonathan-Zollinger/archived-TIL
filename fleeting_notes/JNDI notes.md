
passing a blank string to the `getschema` method retrieves the root object schema
`Dircontext.getSchema("")`

calling `getAttributes` on a `DirContext` object doesn't work, it will return an Attributes object with a "no attributes" value.

to retrieve an eDir object class' schema, call `getAttributes` with `ClassDefinition/` prepended to the name of the object class.
```java
context.getSchema("").getAttributes("ClassDefinition/inetOrgPerson");
```

I dont know why, but this does NOT work if you attempt to combine the methods into the following.

```java
context.getAttributes("", new String[]{"ClassDefinition/inetOrgPerson"});
// returns "No attributes" object
```

https://docs.oracle.com/javase/jndi/tutorial/

get all object class definitions for an entry. 

eDirectory does not support `getSchemaClassDefinition`!


```java
// Get context containing class definitions for the "cn=Ted Geisel" entry
DirContext tedClasses = ctx.getSchemaClassDefinition("cn=Ted Geisel, ou=People");

// Enumerate the class definitions
NamingEnumeration namingEnum = tedClasses.search("", null);
while (namingEnum.hasMore()) {
    System.out.println(namingEnum.next());
}
```

See [full source of example](https://docs.oracle.com/javase/jndi/tutorial/ldap/schema/src/GetClassDefn.java), `NamingEnumuration<SearchResult>` [docs](https://docs.oracle.com/javase/8/docs/api/javax/naming/NamingEnumeration.html), and `SearchResult` [docs](https://docs.oracle.com/javase/8/docs/api/javax/naming/directory/SearchResult.html)

[example](https://docs.oracle.com/javase/jndi/tutorial/ldap/schema/example.html) to query the object class definition

[LDAP v3 definitions](https://www.ietf.org/rfc/rfc2251.txt)

works: `context.getSchemaClassDefinition("cn=xzavier.friesen,o=users").listBindings("")`


Best Route thus far: 
```java
NamingEnumeration<SearchResult> searchResults = context
                .getSchemaClassDefinition(getRequiredDn(dn))
                .search("", null);
        while(searchResults.hasMore()) {
            SearchResult result = searchResults.nextElement();
            NamingEnumeration<? extends Attribute> allAttributes = result.getAttributes().getAll();
            while(allAttributes.hasMore()) {
                attributeList.add(allAttributes.nextElement());
            }
        }
```



