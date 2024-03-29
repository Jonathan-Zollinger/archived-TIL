Basic Search

[![Previous | ](../../images/PreviousArrow.gif)](search.html)[![Next | ](../../images/NextArrow.gif)](filter.html)[![Trail Map | ](../../images/WayUpArrow.gif)](../../trailmap.html)[![The Basics | ](../../jndiimages/basicsHeader.gif)](../index.html)

[**_Directory Operations_**](index.html)

![](../../jndiimages/shoeline2.GIF) ![](../../jndiimages/shoeline2.GIF)

Basic Search
------------

> The simplest form of search requires that you specify the set of attributes that an entry must have and the name of the target context in which to perform the search.
> 
> The following code creates an attribute set matchAttrs, which has two attributes "telephonenumber" and "mail". It specifies that the qualifying entries must have a surname ("sn") attribute with a value of "Geisel" and a "mail" attribute with any value. It then invokes [DirContext.search()](http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, javax.naming.directory.Attributes))[![(in the API reference documentation)](../../images/apiIcon.gif)](http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, javax.naming.directory.Attributes)) to search the context "ou=People" for entries that have the attributes specified by matchAttrs.
> 
> > // Specify the attributes to match
> > // Ask for objects that has a surname ("sn") attribute with 
> > // the value "Geisel" and the "mail" attribute
> > Attributes matchAttrs = new BasicAttributes(true); // ignore attribute name case
> > matchAttrs.put(new BasicAttribute("sn", "Geisel"));
> > matchAttrs.put(new BasicAttribute("mail"));
> > 
> > // Search for objects that have those matching attributes
> > NamingEnumeration answer = ctx.search("ou=People", matchAttrs);
> 
> You can then print the results as follows.
> 
> > while (answer.hasMore()) {
> >     SearchResult sr = (SearchResult)answer.next();
> >     System.out.println(">>>" + sr.getName());
> >     printAttrs(sr.getAttributes());
> > }
> 
> printAttrs()is similar to the code in [the getAttributes() example](getattrs.html) that prints an attribute set.
> 
> Running [this example](src/SearchRetAll.java) produces the following result.
> 
> > \# java SearchRetAll
> > >>>cn=Ted Geisel
> > attribute: sn
> > value: Geisel
> > attribute: objectclass
> > value: top
> > value: person
> > value: organizationalPerson
> > value: inetOrgPerson
> > attribute: jpegphoto
> > value: \[B@1dacd78b
> > attribute: mail
> > value: Ted.Geisel@JNDITutorial.com
> > attribute: facsimiletelephonenumber
> > value: +1 408 555 2329
> > attribute: cn
> > value: Ted Geisel
> > attribute: telephonenumber
> > value: +1 408 555 5252
> 
> #### Returning Selected Attributes
> 
> The previous example returned all attributes associated with the entries that satisfy the specified query. You can select the attributes to return by passing search() an array of attribute identifiers that you want to include in the result. After creating the matchAttrs as shown previously, you also need to create the array of attribute identifiers, as shown next.
> 
> > // Specify the ids of the attributes to return
> > String\[\] attrIDs = {"sn", "telephonenumber", "golfhandicap", "mail"};
> > 
> > // Search for objects that have those matching attributes
> > NamingEnumeration answer = ctx.search("ou=People", matchAttrs, attrIDs);
> 
> [This example](src/Search.java) returns the attributes "sn", "telephonenumber", "golfhandicap", and "mail" of entries that have an attribute "mail" and have a "sn" attribute with the value "Geisel". This example produces the following result. (The entry does not have a "golfhandicap" attribute, so it is not returned.)
> 
> > \# java Search 
> > >>>cn=Ted Geisel
> > attribute: sn
> > value: Geisel
> > attribute: mail
> > value: Ted.Geisel@JNDITutorial.com
> > attribute: telephonenumber
> > value: +1 408 555 5252

* * *

[![Previous | ](../../images/PreviousArrow.gif)](search.html)[![Next | ](../../images/NextArrow.gif)](filter.html)[![Trail Map | ](../../images/WayUpArrow.gif)](../../trailmap.html)[![The Basics | ](../../jndiimages/basicsHeader.gif)](../index.html)

[**_Directory Operations_**](index.html)