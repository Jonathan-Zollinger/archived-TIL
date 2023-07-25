#JNDI #LDAP #Schema 

To retrieve an eDir object class's attributes, call `getAttributes` with `ClassDefinition/` prepended to the name of the object class.

# Examples
```java
context.getSchema("").lookup("ClassDefinition/inetOrgPerson").getAttributes("");
```

### References
1. [[Query Attribute Definition from eDirectory]]