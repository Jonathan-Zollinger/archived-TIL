
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


----

I believe you can change the returned type of DirContext.SearchResult(). 
https://docs.oracle.com/javase/8/docs/api/javax/naming/directory/SearchControls.html#setReturningAttributes-java.lang.String:A-
```java
SearchControls ctls = new SearchControls();
ctls.setReturningObjFlag(true);

// Specify the search filter to match any object
String filter = "(objectclass=*)";

// Search for objects by using the filter
NamingEnumeration answer = ctx.search("", filter, ctls);
```

#### [Quick Overview of Search Filter Syntax](https://docs.oracle.com/javase/jndi/tutorial/basics/directory/filter.html)

The search filter syntax is basically a logical expression in prefix notation (that is, the logical operator appears before its arguments). The following table lists the symbols used for creating filters.

| Symbol | Description                                                                                                             |
| ------ | ----------------------------------------------------------------------------------------------------------------------- |
| &      | conjunction (i.e., _and_ -- all in list must be true)                                                                   |
| \|     | disjunction (i.e., _or_ -- one or more alternatives must be true)                                                       |
| !      | negation (i.e., _not_ -- the item being negated must not be true)                                                       |
| =      | equality (according to the matching rule of the attribute)                                                              |
| ~=     | approximate equality (according to the matching rule of the attribute)                                                  |
| >=     | greater than (according to the matching rule of the attribute)                                                          |
| <=     | less than (according to the matching rule of the attribute)                                                             |
| =*     | presence (i.e., the entry must have the attribute but its value is irrelevant)                                          |
| *      | wildcard (indicates zero or more characters can occur in that position); used when specifying attribute values to match |
| \      | escape (for escaping '*', '(', or ')' when they occur inside an attribute value)                                        |

---
```java
// Get the schema tree root
DirContext schema = ctx.getSchema("");

// Get the schema object for "cn"
DirContext cnSchema = (DirContext)schema.lookup("AttributeDefinition/cn");
```