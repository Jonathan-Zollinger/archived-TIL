










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Search Results</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="compare.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="batch.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Search Results
</h2>
<p>
<blockquote>

When you use the search methods in the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html"><tt>DirContext</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     interface,
you get back a 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingEnumeration.html"><tt>NamingEnumeration</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingEnumeration.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
Each item in <tt>NamingEnumeration</tt> is a
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchResult.html"><tt>SearchResult</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchResult.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>, which contains the following information:
<ul>
<li><a href=#NAME>Name</a>
<li><a href=#OBJ>Object</a>
<li><a href=#CLASS>Class name</a>
<li><a href=#ATTRS>Attributes</a>
</ul>

<a name=NAME><h4>Name</h4></a>

Each <tt>SearchResult</tt> contains the name of the LDAP entry that satisfied
the search filter. You obtain the name of the entry by using
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#getName()"><tt>getName()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#getName()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
This method returns the 
<a href=../../getStarted/concepts/glossary.html#COMPOSITENAME><em>composite name</em></a>
of the LDAP entry <em>relative</em> to
the <em>target context</em>. The target context is the context 
to which the
<tt>name</tt> parameter resolves.
In LDAP parlance, the target context is the <em>base object</em> for the search.
Here's an example.
<blockquote><pre>
NamingEnumeration answer = ctx.search("ou=NewHires", 
    "(&amp;(mySpecialKey={0}) (cn=*{1}))",      // Filter expression
    new Object[]{key, name},                // Filter arguments
    null);				    // Default search controls
</pre></blockquote>
The target context in this example is that named by 
<tt>"ou=NewHires"</tt>.
The names in <tt>SearchResult</tt>s in <tt>answer</tt>
are relative to <tt>"ou=NewHires"</tt>.
For example, if <tt>getName()</tt> returns <tt>"cn=J. Duke"</tt>,
then its name relative to <tt>ctx</tt> will be 
<tt>"cn=J. Duke, ou=NewHires"</tt>.
<p>
If you performed the search by using
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#SUBTREE_SCOPE"><tt>SearchControls.SUBTREE_SCOPE</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#SUBTREE_SCOPE"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     or
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#OBJECT_SCOPE"><tt>SearchControls.OBJECT_SCOPE</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#OBJECT_SCOPE"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     and the target context itself satisfied the search filter,
then the name returned will be "" (the empty name) because that is
the name relative to the target context.
<p>
This isn't the whole story. If the search involves referrals
(see the
<a target="_top" href="../referral/index.html">Referrals</a> <a href="../referral/index.html"><img src="../../jndiimages/ldapIcon.gif" width=20 height=20 border=0 alt="(in the Tips for LDAP Users trail)"></a>     lesson)
or dereferencing aliases (see the
<a target="_top" href="../misc/aliases.html">Miscellaneous</a> <a href="../misc/aliases.html"><img src="../../jndiimages/ldapIcon.gif" width=20 height=20 border=0 alt="(in the Tips for LDAP Users trail)"></a>     lesson), then the corresponding <tt>SearchResult</tt>s will have names
that are not relative to the target context.
Instead, they will be URLs that refer directly to the entry.
To determine whether the name returned by <tt>getName()</tt> is relative
or absolute, use
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#isRelative()"><tt>isRelative()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#isRelative()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>. If this method returns <tt>true</tt>, then the name is relative
to the target context; if it returns <tt>false</tt>, the name is a URL.
<p>
If the name is a URL and you need to use that URL, then you can pass it to the
initial context, which understands URLs (see the
<a target="_top" href="../misc/url.html">Miscellaneous</a> <a href="../misc/url.html"><img src="../../jndiimages/ldapIcon.gif" width=20 height=20 border=0 alt="(in the Tips for LDAP Users trail)"></a>     lesson).
<p>
If you need to get the entry's full DN, 
then you can either do some bookkeeping
to keep track of the ancestors of the <tt>SearchResult</tt> or use
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#getNameInNamespace()"><tt>Context.getNameInNamespace()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#getNameInNamespace()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
<a name=OBJ><h4>Object</h4></a>

If the search was conducted requesting that the entry's object be returned
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#setReturningObjFlag(boolean)">(<tt>SearchControls.setReturningObjFlag()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#setReturningObjFlag(boolean)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     was invoked with <tt>true</tt>),
then <tt>SearchResult</tt> will contain an object that represents the entry.
To retrieve this object, you invoke
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Binding.html#getObject()"><tt>getObject()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Binding.html#getObject()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
If a <tt>java.io.Serializable</tt>,
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Referenceable.html"><tt>Referenceable</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Referenceable.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>, or
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Reference.html"><tt>Reference</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Reference.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     object was previously bound to that LDAP name, 
then the attributes from the entry are used to reconstruct that object
(see the example in the
<a target="_top" href="../../objects/reading/search.html">Reading Objects from the Directory</a> <a href="../../objects/reading/search.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>     lesson).
Otherwise, the attributes from the entry are used to create
a <tt>DirContext</tt> instance that represents the LDAP entry.
In either case,
the LDAP provider invokes
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirectoryManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable, javax.naming.directory.Attributes)"><tt>DirectoryManager.getObjectInstance()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirectoryManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>  on the object and returns the results.

<a name=CLASS><h4>Class Name</h4></a>

If the search was conducted requesting that the entry's object be returned,
then the class name is derived from the returned object.
If the search requested attributes that included the retrieval
of the <tt>"javaClassName"</tt> attribute of the LDAP entry, then the
class name is the value of that attribute.
Otherwise, the class name is <tt>"javax.naming.directory.DirContext"</tt>.
The class name is obtained from
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#getClassName()"><tt>getClassName()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#getClassName()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.

<a name=ATTRS><h4>Attributes</h4></a>

When you perform a search, you can select the return attributes
either by supplying a parameter to one of the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, javax.naming.directory.Attributes, java.lang.String[])"><tt>search()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, javax.naming.directory.Attributes, java.lang.String[])"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     methods or by setting the search controls using
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#setReturningAttributes(java.lang.String[])"><tt>SearchControls.setReturningAttributes()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#setReturningAttributes(java.lang.String[])"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
If no attributes have been specified explicitly, 
then all of the LDAP entry's attributes
are returned. To specify that no attributes be returned, you must
pass an empty array (<tt>new String[0]</tt>).
<p>
To retrieve the LDAP entry's attributes, you invoke
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchResult.html#getAttributes()"><tt>getAttributes()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchResult.html#getAttributes()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     on the <tt>SearchResult</tt>.

<h4>Response Controls</h4>

See the

<a target="_top" href="../ext/response.html">Controls and Extensions</a> <a href="../ext/response.html"><img src="../../jndiimages/ldapIcon.gif" width=20 height=20 border=0 alt="(in the Tips for LDAP Users trail)"></a>   lesson for details on how to retrieve a search result's response controls.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="compare.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="batch.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
