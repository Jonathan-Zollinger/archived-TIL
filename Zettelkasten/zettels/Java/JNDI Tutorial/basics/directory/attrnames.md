Attribute Names

[![Previous | ](Zettelkasten/zettels/Java/JNDI%20Tutorial/index.html)extArrow.gif)](getattrs.html)[![Trail Map | ](trailmap.html) | ](Zettelkasten/zettels/Java/JNDI%20Tutorial/basics/index.html)perations_**](Zettelkasten/zettels/Java/JNDI%20Tutorial/index.html)

![](shoeline2.GIF) ![](shoeline2.GIF)

Attribute Names
---------------

> An [attribute](glossary.html#ATTRIBUTE) consists of an _attribute identifier_ and a set of _attribute values_. The _attribute identifier_, also called _attribute name_, is a string that identifies an attribute. An _attribute value_ is the content of the attribute and its type is not restricted to that of string. You use an attribute name when you want to specify a particular attribute for either retrieval, searches, or modification. Names are also returned by operations that return attributes (such as when you perform reads or searches in the directory).
> 
> When using attribute names, you need to be aware of certain directory server features so that you won't be surprised by the result. These features are described in the next subsections.
> 
> #### Attribute Type
> 
> In directories such as the LDAP, the attribute's name identifies the attribute's type and is often called the _attribute type name_. For example, the attribute name "cn" is also called the attribute type name. An attribute's type definition specifies the syntax that the attribute's value is to have, whether it can have multiple values, and equality and ordering rules to use when performing comparison and ordering operations on the attribute's values.
> 
> #### Attribute Subclassing
> 
> Some directory implementations support _attribute subclassing_, in which the server allows attribute types to be defined in terms of other attribute types. For example, a "name" attribute might be the superclass of all name-related attributes: "commonName" might be a subclass of "name". For directory implementations that support this, asking for the "name" attribute might return the "commonName" attribute.
> 
> When accessing directories that support attribute subclassing, you have to be aware that the server might return attributes that have names different from those that you requested. To minimize the chance of this, use the most derived subclass.
> 
> #### Attribute Name Synonyms
> 
> Some directory implementations support synonyms for attribute names. For example, "cn" might be a synonym for "commonName". Thus a request for the "cn" attribute might return the "commonName" attribute.
> 
> When accessing directories that support synonyms for attribute names, you must be aware that the server might return attributes that have names different from those you requested. To help prevent this from happening, use the canonical attribute name instead of one of its synonyms. The _canonical attribute name_ is the name used in the attribute's definition; a synonym is the name that refers to the canonical attribute name in its definition.
> 
> #### Language Preferences
> 
> An extension to the LDAP v3 ([RFC 2596](http://www.ietf.org/rfc/rfc2596.txt)) allows you to specify a language code along with an attribute name. This resembles attribute subclassing in that one attribute name can represent several different attributes. An example is a "description" attribute that has two language variations:
> 
> > description: software
> > description;lang-en: software products
> > description;lang-de: Softwareprodukte
> 
> A request for the "description" attribute would return all three attributes.
> 
> When accessing directories that support this feature, you must be aware that the server might return attributes that have names different from those that you requested.

* * *

[![Previous | ](Zettelkasten/zettels/Java/JNDI%20Tutorial/index.html)extArrow.gif)](getattrs.html)[![Trail Map | ](trailmap.html) | ](Zettelkasten/zettels/Java/JNDI%20Tutorial/basics/index.html)perations_**](Zettelkasten/zettels/Java/JNDI%20Tutorial/index.html)