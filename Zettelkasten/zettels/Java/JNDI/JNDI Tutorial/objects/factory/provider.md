










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Interaction Between Object Factories and Service Providers</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="uses.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="examples.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/objectsHeader.gif" width=26 height=26 align=bottom border=0 alt="Java Objects and the Directory | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Object Factories</em></strong></a>
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
    Interaction Between Object Factories and Service Providers
</h2>
<p>
<blockquote>

A service providers acts as the go-between for the application
and the directory when the application stores or retrieves Java objects
from the directory. 
When you write a service provider, you need to
perform this go-between role by following the rules
outlined for reading objects from the directory.
<p>
The following detailed description is
intended for developers writing service providers.
The insight it offers into
the go-between role of service providers might also
interest API users.

<h4>Relevant Methods</h4>

When returning objects to the JNDI client application,
the service provider should use the guidelines described in this section.
An object can be returned by using one of the following methods:
<ul>
<li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><tt>Context.lookup()</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>
<li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookupLink(javax.naming.Name)"><tt>Context.lookupLink()</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookupLink(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>
<li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Binding.html#getObject()"><tt>Binding.getObject()</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Binding.html#getObject()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>
<li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchResult.html"><tt>SearchResult.getObject()</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchResult.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a></ul>

<h4>Framework Support</h4>
A service provider should use object factories
configured with the provider and application.
This allows the provider to be customized to support arbitrary
types of objects (for which a corresponding object factory is available).
<p>
The JNDI framework provides utility methods that service providers
can use to access object factories.
A provider that implements only the 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html><tt>Context</tt> </a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     interface should use
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/NamingManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><tt>NamingManager.getObjectInstance()</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/NamingManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
A service provider that implements the 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html><tt>DirContext</tt> </a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     interface should use
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirectoryManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable, javax.naming.directory.Attributes)"><tt>DirectoryManager.getObjectInstance()</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirectoryManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
These methods interact with the object factories to produce a Java object
representing the information in the directory.
Which object factories are used depends on the object read from the directory. 
If the object is a reference, then these methods use
the object factory class named in the reference.
If the reference contains a URL, then these methods use
the corresponding URL context factory.
Otherwise, they traverse the list of object factories specified in the 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#OBJECT_FACTORIES"><tt>Context.OBJECT_FACTORIES</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#OBJECT_FACTORIES"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   environment property and the
<a href=../../getStarted/concepts/glossary.html#PROVRES>provider resource file</a>
and try to find a factory that yields a non-<tt>null</tt> answer.
(See the
<a target="_top" href="../../beyond/index.html">Beyond the Basics</a> <a target="_top" href="../../beyond/index.html"><img src="../../jndiimages/beyondIcon.gif" width=20 height=20 border=0 alt="(in the Beyond the Basics trail)"></a>     trail for details about environment properties and the provider resource file.)

<h4>Federation</h4>

As explained in the <a href=uses.html>Other Uses</a> section of this lesson,
object factories also play a role in federation.
How a service provider uses object factories to support federation
is described in the
<a target="_top" href="../../provider/index.html">Building a Service Provider</a> <a target="_top" href="../../provider/index.html"><img src="../../jndiimages/providerIcon.gif" width=20 height=20 border=0 alt="(in the Building a Service Provider trail)"></a>     trail.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="uses.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="examples.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/objectsHeader.gif" width=26 height=26 align=top border=0 alt="Java Objects and the Directory | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Object Factories</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
