










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Attributes</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="version.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="aliases.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/ldapHeader.gif" width=26 height=26 align=bottom border=0 alt="Tips for LDAP Users | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Miscellaneous</em></strong></a>
</td>
</tr>
</table>
<P ALIGN="CENTER">
<IMG SRC="../../jndiimages/shoeline2.GIF" ALIGN="BOTTOM" BORDER="0" WIDTH="202"
    HEIGHT="25" NATURALSIZEFLAG="3">
<IMG SRC="../../jndiimages/shoeline2.GIF" ALIGN="BOTTOM" BORDER="0" WIDTH="202"
    HEIGHT="25" NATURALSIZEFLAG="3">
</P>

<h2>
    Attributes
</h2>
<p>
<blockquote>

Because most of the operations on the LDAP directory center
around attributes, you need to understand how to use those
attributes through the JNDI.
<p>
An LDAP entry's attributes are represented by the 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/Attributes.html"><tt>Attributes</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/Attributes.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>  interface, whereas individual attributes are represented by the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/Attribute.html"><tt>Attribute</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/Attribute.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>  interface.
To create attributes for use in your program, you should use the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/BasicAttributes.html"><tt>BasicAttributes</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/BasicAttributes.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>  and
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/BasicAttribute.html"><tt>BasicAttribute</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/BasicAttribute.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>  classes. 
<p>
Here is <a href=src/CreateAttrs.java>an example</a>
that creates two attributes, <tt>"oc"</tt> and <tt>"photo"</tt>, and puts them
into an <tt>Attributes</tt> object.
<blockquote><pre>
// Create a multivalued attribute that has four String values
BasicAttribute oc = new BasicAttribute("objectClass", "top");
oc.add("person");
oc.add("organizationalPerson");
oc.add("inetOrgPerson");

// Create an attribute by using a byte array
BasicAttribute photo = new BasicAttribute("jpegPhoto", buf);

// Create the attribute set
BasicAttributes attrs = new BasicAttributes(true);
attrs.put(oc);
attrs.put(photo);
</pre></blockquote>

<h4>Attribute Names</h4>
You identify an attribute through the use of its <em>attribute name</em>,
which is sometimes called the <em>attribute identifier</em> or 
<em>attribute type name</em>. The
<a target="_top" href="../../basics/directory/attrnames.html">Directory Operations</a> <a href="../../basics/directory/attrnames.html"><img src="../../jndiimages/basicsIcon.gif" width=20 height=20 border=0 alt="(in the Basics trail)"></a>     lesson discusses attribute names,
specifically, it covers attribute subclassing, attribute name
synonyms, and the syntax for specifying language preferences.
These features might not be supported by all LDAP server implementations.
<p>
LDAP attribute names are case-insensitive. 
Thus two attribute names, such as <tt>"objectclass"</tt> and 
<tt>"objectClass"</tt>,
both would be interpreted to refer to the same attribute.
If you are using the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/BasicAttributes.html"><tt>BasicAttributes</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/BasicAttributes.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     class to represent LDAP attributes, 
then you should pass <tt>true</tt>
for the <tt>ignoreCase</tt> parameter to its constructors. Here are some examples.
<blockquote><pre>
Attributes attrs1 = new BasicAttributes(true);
Attributes attrs2 = new BasicAttributes("objectClass", "top", true); 
</pre></blockquote>

<h4>Options</h4>

The <A HREF="http://www.ietf.org/rfc/rfc2251.txt">LDAP v3</A> allows 
<em>options</em> to be appended to an attribute name.
Each option is preceded by a semicolon character (";").
Options are like attribute subclassing.
That is, an attribute named without the option is treated as the
superclass of an attribute named with an option.
The only option defined by the protocol is <em>binary</em> (
indicated by using the string <tt>";binary"</tt>),
which means that the attribute's value should be transmitted in binary format
(regardless of its actual syntax).
This option is reserved for transmitting ASN.1 encoded data (such as certificates:
<tt>"caCertificate;binary"</tt>).
Servers that support attribute subclassing may support identification
of the attribute without its binary option, but it is best always
to include the binary option in the attribute name.

<h4>Operational Attributes</h4>

The <A HREF="http://www.ietf.org/rfc/rfc2251.txt">LDAP v3</A>
supports the notion of <em>operational attributes</em>, which are
attributes associated with a directory object for administrative
purposes. 
The access control list for an object, for example, is an operational attribute.  
In 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name)"><tt>DirContext.getAttributes()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     and
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, java.lang.String, javax.naming.directory.SearchControls)"><tt>DirContext.search()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, java.lang.String, javax.naming.directory.SearchControls)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>, you can supply <tt>null</tt> as the list of attributes to return
and therefore can specify that all attributes
associated with the requested objects be returned. 
The attributes
returned, however, do not include operational attributes.  To retrieve
operational attributes, you must name them explicitly.

<a name=BYTES><h4>Attribute Values</h4></a>

An LDAP attribute can have a single value or multiple, unordered values.
Whether an attribute is allowed to have more than one value
is dictated by the attribute's definition in the directory's schema.
Both single and multivalued attributes are represented in the JNDI as an
<tt>Attribute</tt>.
In <a href=src/CreateAttrs.java>the previous example</a>,
a multivalued attribute and a single-valued attribute are created.
<p>
The JNDI is very flexible in how attribute values can be
represented because such values are declared as <tt>java.lang.Object</tt>.  When
you use the JNDI to access or update attributes stored in a particular
directory, the types of the attribute values
depend on the directory and to some extent, on the corresponding service
provider.  For the LDAP directory, Sun's LDAP provider represents
attribute values as either <tt>java.lang.String</tt> or
<tt>byte[]</tt>. 
<tt>byte</tt> arrays are used to represent attribute values with
nonstring attribute syntaxes. 
Strings are used to represent the values of all other syntaxes.
<p>
For an arbitrary attribute, no programmatic way is available
to determine
whether its syntax is nonstring. Manual ways are available,
of course, and involve
looking up the attribute and its syntax in documents such as
<A HREF="http://www.ietf.org/rfc/rfc2256.txt">RFC 2256</A>.


The LDAP service provider has a built-in list of
attribute names that it knows contain nonstring values and allows clients to
add to that list. 
The following table gives that built-in list.

<p>
<TABLE BORDER CELLPADDING=3>
<TR>
<TH>Attribute Name</TH>

<TH>Attribute OID</TH>
</TR>

<TR>
<TD>All attribute names containing the <TT>";binary"</TT> option.</TD>

<TD>&nbsp;</TD>
</TR>
<tt>
<TR>
<TD>photo</TD>

<TD>0.9.2342.19200300.100.1.7</TD>
</TR>

<TR>
<TD>personalSignature</TD>

<TD>0.9.2342.19200300.100.1.53</TD>
</TR>

<TR>
<TD>audio</TD>

<TD>0.9.2342.19200300.100.1.55</TD>
</TR>

<TR>
<TD>jpegPhoto</TD>

<TD>0.9.2342.19200300.100.1.60</TD>
</TR>

<TR>
<TD>javaSerializedData</TD>

<TD>1.3.6.1.4.1.42.2.27.4.1.8</td>
</TR>

<TR>
<TD>thumbnailPhoto</TD>

<TD>1.3.6.1.4.1.1466.101.120.35</TD>
</TR>

<TR>
<TD>thumbnailLogo</TD>

<TD>1.3.6.1.4.1.1466.101.120.36</TD>
</TR>

<TR>
<TD>userPassword</TD>

<TD>2.5.4.35</TD>
</TR>

<TR>
<TD>userCertificate</TD>

<TD>2.5.4.36</TD>
</TR>

<TR>
<TD>cACertificate</TD>

<TD>2.5.4.37</TD>
</TR>

<TR>
<TD>authorityRevocationList</TD>

<TD>2.5.4.38</TD>
</TR>

<TR>
<TD>certificateRevocationList</TD>

<TD>2.5.4.39</TD>
</TR>

<TR>
<TD>crossCertificatePair</TD>

<TD>2.5.4.40</TD>
</TR>

<TR>
<TD>x500UniqueIdentifier</TD>

<TD>2.5.4.45</TD>
</TR>
</tt>
</TABLE>
<p>
When you read one of these attributes from the LDAP directory, its
value will be of type <tt>byte[]</tt>.

<h4>Specifying Additional Nonstring Attributes</h4>

<p>
If your program uses an attribute whose value should be returned 
as a <tt>byte</tt> array but the attribute's name is not on this list,
then you need to add the
name to the list of nonstring attributes.
You do this by using the <tt>"java.naming.ldap.attributes.binary"</tt>
environment property.
Its value is a string of space-separated attribute names. 
<p>
For example, the <a href=src/ReadNonstring.java>following
environment property setting</a>
informs the LDAP provider that the
values of the attributes named <tt>"mpegVideo"</tt> and 
<tt>"mySpecialKey"</tt> are to
be returned as <tt>byte</tt> arrays:
<blockquote><pre>
env.put("java.naming.ldap.attributes.binary", "mpegVideo mySpecialKey");
</pre></blockquote>

<a name=TYPESONLY><h4>Suppressing the Return of Attribute Values</h4></a>
The
<A HREF="http://www.ietf.org/rfc/rfc2251.txt">LDAP v3</A>
 allows you to specify that only attribute type names (and not attribute values)
be returned.
To do this by using the JNDI, you set the <tt>"java.naming.ldap.typesOnly"</tt>
environment property. This property affects
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name)"><tt>DirContext.getAttributes()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     and
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, java.lang.String, javax.naming.directory.SearchControls)"><tt>DirContext.search()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, java.lang.String, javax.naming.directory.SearchControls)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.     
When you specify that objects are to be returned
(by passing <tt>true</tt> to
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#setReturningObjFlag(boolean)"><tt>SearchControls.setReturningObjFlag()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#setReturningObjFlag(boolean)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>) and then you invoke <tt>search()</tt>,
this property is ignored because attribute values are required
to generate the object. 
<p>
Here's <a href=src/GetTypesOnly.java>an example</a> that gets a list of
an entry's attribute names.
<blockquote><pre>
// Indicate that you want only the type names
env.put("java.naming.ldap.typesOnly", "true");

// Create initial context
DirContext ctx = new InitialDirContext(env);

// Get the attributes
Attributes attrs = ctx.getAttributes("cn=Ted Geisel, ou=People");
</pre></blockquote>
<p>
This example produces the following output.
<blockquote><pre>
{sn=sn: No values, 
 objectclass=objectclass: No values, 
 jpegphoto=jpegphoto: No values, 
 mail=mail: No values, 
 facsimiletelephonenumber=facsimiletelephonenumber: No values, 
 telephonenumber=telephonenumber: No values, cn=cn: No values}
</pre></blockquote>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="version.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="aliases.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/ldapHeader.gif" width=26 height=26 align=top border=0 alt="Tips for LDAP Users | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Miscellaneous</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
