










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Modifying Attributes</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="getattrs.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="search.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/basicsHeader.gif" width=26 height=26 align=bottom border=0 alt="The Basics | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Directory Operations</em></strong></a>
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
    Modifying Attributes
</h2>
<p>
<blockquote>

The 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html><tt>DirContext</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     interface contains methods for
modifying the attributes and attribute values of objects in
the directory. 

<h4><a name=LIST>Using a List of Modifications</h4>

One way to modify the attributes of an object
is to supply a list of modification requests
(
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/ModificationItem.html><tt>ModificationItem</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/ModificationItem.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>).
Each <tt>ModificationItem</tt> consists of a numeric constant indicating
the type of modification to make and an 

<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/Attribute.html><tt>Attribute</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/Attribute.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     describing the modification to make.
Following are the three types of modifications:
<tt>
<ul>
<li>
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#ADD_ATTRIBUTE>ADD_ATTRIBUTE</a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#ADD_ATTRIBUTE><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><li>
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#REPLACE_ATTRIBUTE>REPLACE_ATTRIBUTE</a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#REPLACE_ATTRIBUTE><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><li>
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#REMOVE_ATTRIBUTE>REMOVE_ATTRIBUTE</a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#REMOVE_ATTRIBUTE><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a></ul>
</tt>
<p>
Modifications are applied in the order in which
they appear in the list.
Either all of the modifications are executed, or none are.
<p>
The following code creates a list of modifications.
It replaces the <tt>"mail"</tt> attribute's value with a
value of <tt>"geisel@wizards.com"</tt>, adds an additional value to the
<tt>"telephonenumber"</tt> attribute, and removes the
<tt>"jpegphoto"</tt> attribute.
<blockquote>
<pre>
// Specify the changes to make
ModificationItem[] mods = new ModificationItem[3];

// Replace the "mail" attribute with a new value
mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
    new BasicAttribute("mail", "geisel@wizards.com"));

// Add an additional value to "telephonenumber"
mods[1] = new ModificationItem(DirContext.ADD_ATTRIBUTE,
    new BasicAttribute("telephonenumber", "+1 555 555 5555"));

// Remove the "jpegphoto" attribute
mods[2] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE,
    new BasicAttribute("jpegphoto"));
</pre>
</blockquote>

<blockquote>
<hr>
<strong>Windows Active Directory:</strong>
Active Directory defines "telephonenumber" to be a single-valued attribute, 
contrary to <A HREF="http://www.ietf.org/rfc/rfc2256.txt">RFC 2256</A>. 
To get this example to work against Active Directory, you must either
use an attribute other than "telephonenumber", or change the
<tt>DirContext.ADD_ATTRIBUTE</tt> to <tt>DirContext.REPLACE_ATTRIBUTE</tt>.
</strong>
<hr>
</blockquote>

<p>
After creating this list of modifications, you can supply it
to

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#modifyAttributes(javax.naming.Name, javax.naming.directory.ModificationItem[])"><tt>modifyAttributes()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#modifyAttributes(javax.naming.Name, javax.naming.directory.ModificationItem[])"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     as follows.
<blockquote>
<pre>
// Perform the requested modifications on the named object
ctx.modifyAttributes(name, mods);
</pre>
</blockquote>

<h4><a name=ATTRS>Using Attributes</a></h4>

Alternatively, you can perform modifications by specifying
the type of modification and the attributes to which to apply the
modification.
<p>
For example, the following line replaces the attributes
(identified in <tt>orig</tt>)
associated with <tt>name</tt> with those in <tt>orig</tt>:
<blockquote>
<pre>
ctx.modifyAttributes(name, DirContext.REPLACE_ATTRIBUTE, orig);
</pre>
</blockquote>
Any other attributes of <tt>name</tt> remain unchanged.
<p>
Both of these uses of <tt>modifyAttributes()</tt> are demonstrated
in <a href=src/Modattrs.java>the sample program</a>. This
program modifies the attributes by using a modification list and then
uses the second form of <tt>modifyAttributes()</tt>
to restore the original attributes.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="getattrs.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="search.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/basicsHeader.gif" width=26 height=26 align=top border=0 alt="The Basics | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Directory Operations</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
