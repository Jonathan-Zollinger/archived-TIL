#JNDI #edirectory #Schema 

To query the root schema using the JNDI, call `getSchema` with an empty string. 

````ad-code
title: Example

```java
/**
 * @param context a valid DirContext object for an LDAP server
 * 
 * Returns the root schema of a given LDAP server 
 */
public DirContext getRootSchema(DirContext context){
	return context.getSchema("") // will require a try/catch for NamingException errors
}
```


````

