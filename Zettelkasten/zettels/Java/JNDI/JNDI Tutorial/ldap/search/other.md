










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Other Context Methods</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="search.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="compare.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/ldapHeader.gif" width=26 height=26 align=bottom border=0 alt="Tips for LDAP Users | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Searches</em></strong></a>
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
    Other Context Methods
</h2>
<p>
<blockquote>

Other methods in the interface,
in addition to <a href=search.html>search()</a>,
read from the directory:
<ul>
<li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name)"><tt>getAttributes()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><tt>lookup()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookupLink(javax.naming.Name)"><tt>lookupLink()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookupLink(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#list(javax.naming.Name)"><tt>list()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#list(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#listBindings(javax.naming.Name)"><tt>listBindings()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#listBindings(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a></ul>
<p>
Because the LDAP "search" operation is the primary way in which
data is to be read from the directory, all other methods
use the LDAP "search" operation in one way or another.
This section describes how each method uses this
operation. Examples of how to use each method are available in 

<a target="_top" href="../../basics/index.html">The Basics</a> <a href="../../basics/index.html"><img src="../../jndiimages/basicsIcon.gif" width=20 height=20 border=0 alt="(in the Basics trail)"></a>     trail.

<h4><tt>getAttributes()</tt></h4>

<tt>getAttributes()</tt> retrieves attributes associated with the named entry.
This method comes in two forms
(ignoring the overloads that accept <tt>java.lang.String</tt>
names instead of 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html"><tt>Name</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   names):
<ul>
<li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name)"><tt>getAttributes(Name name)</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>
<li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name, java.lang.String[])"><tt>getAttributes(Name name, String[] retAttrs)</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name, java.lang.String[])"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a></ul>

The first form is equivalent to the second form, with <tt>null</tt>
supplied as the <tt>retAttrs</tt> argument:
<blockquote><pre>
getAttributes(name, null);
</pre></blockquote>
The <tt>retAttrs</tt> argument contains the list of attributes to retrieve.
If <tt>retAttrs</tt> contains an attribute with the special name 
<tt>"*"</tt>, or if
<tt>retAttrs</tt> is <tt>null</tt>, 
then all attributes of the named entry are retrieved.

This method is equivalent to performing an LDAP "search" operation 
using the string filter <tt>"(objectclass=*)"</tt> and a search scope of 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#OBJECT_SCOPE><tt>SearchControls.OBJECT_SCOPE</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#OBJECT_SCOPE><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     and asking that the requested attributes be returned.

<h4><tt>lookup()</tt> and <tt>lookupLink()</tt></h4>

<tt>lookup()</tt> and <tt>lookupLink()</tt> return the object bound to the name.
If a <tt>java.io.Serializable</tt>,
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Reference.html><tt>Reference</tt> </a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Reference.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>, or 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Referenceable.html><tt>Referenceable</tt> </a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Referenceable.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    object was previously bound to the name, by using either
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#bind(javax.naming.Name, java.lang.Object)"><tt>bind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#bind(javax.naming.Name, java.lang.Object)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     or
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#rebind(javax.naming.Name, java.lang.Object)"><tt>rebind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#rebind(javax.naming.Name, java.lang.Object)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>, then the result of these methods will be an object constructed 
by using the attributes used for storing Java objects.
See the 
<a target="_top" href="../../objects/representation/ldap.html">Representation in the Directory</a> <a href="../../objects/representation/ldap.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>     lesson for details.
Otherwise, a <tt>DirContext</tt> object representing the named entry is returned.
<p>
These methods are implemented by using an LDAP "search" operation
with the string filter <tt>"(objectclass=*)"</tt> and a search scope of 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#OBJECT_SCOPE><tt>SearchControls.OBJECT_SCOPE</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#OBJECT_SCOPE><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>, and asking for all of the entry's attributes.
If the entry contains Java object-related attributes, 
then those attributes are used to
reconstruct the object, as described in the 
<a target="_top" href="../../objects/representation/ldap.html">Representation in the Directory</a> <a href="../../objects/representation/ldap.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>    lesson.
The result is then passed to the object factory mechanism,
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/NamingManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><tt>NamingManager.getObjectInstance()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/NamingManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>, before being returned to the caller. See the
<a target="_top" href="../../objects/reading/index.html">Reading Objects from the Directory</a> <a href="../../objects/reading/index.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>    lesson for details.


<h4><tt>list()</tt> and <tt>listBindings()</tt></h4>

<tt>list()</tt> and <tt>listBindings()</tt> list the named context and return an
enumeration of
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html><tt>NameClassPair</tt> </a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     or 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Binding.html><tt>Binding</tt> </a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Binding.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>, respectively.

These methods are implemented by using an LDAP "search" operation
with the string filter <tt>"(objectclass=*)"</tt> 
and a search scope of 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#ONELEVEL_SCOPE><tt>SearchControls.ONELEVEL_SCOPE</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#ONELEVEL_SCOPE><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.

<tt>list()</tt> asks for 
the <tt>"objectClass"</tt> and <tt>"javaClassName"</tt> attributes
so that the class name of each entry can be determined (
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#getClassName()"><tt>NameClassPair.getClassName()</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#getClassName()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>).
If the <tt>"javaClassName"</tt> attribute does not exist, the class name is
<tt>"javax.naming.directory.DirContext"</tt>.
The name of each entry (
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#getName()"><tt>NameClassPair.getName()</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#getName()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>) either is relative to the named context or is an LDAP URL.
The latter is used if a referral or alias has been followed.
<p>
<tt>listBindings()</tt> resembles <tt>list()</tt>, except that
it asks for all of the entry's attributes.
It will attempt to create for each item in the enumeration an object
(to be returned by
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Binding.html#getObject()"><tt>Binding.getObject()</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Binding.html#getObject()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>) similar to the way that <tt>lookup()</tt> creates an object from the data
read from the directory.


</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="search.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="compare.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/ldapHeader.gif" width=26 height=26 align=top border=0 alt="Tips for LDAP Users | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Searches</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
