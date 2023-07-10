#JNDI #LDAP #edirectory 

To retrieve an eDirectory DLAP attribute's attributes (aka `attribute-ception`), use the `lookup` command on the root schema, feeding  `AttributeDefinition/` prepended to the name of the object class.  Call `getAttributes("")` (with a blank string, iow no filters) on the returned `lookup` command to get the attributes as an `Attributes` object, otherwise `lookup` returns a schema object.
# Examples
```java
context.getSchema("").lookup("ClassDefinition/inetOrgPerson").getAttributes("");
```
