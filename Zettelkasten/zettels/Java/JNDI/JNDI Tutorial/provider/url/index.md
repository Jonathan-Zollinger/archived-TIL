










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Adding URL Support</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="../dir/extend.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="factory.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/providerHeader.gif" width=26 height=26 align=bottom border=0 alt="Building a Service Provider | "></a>
</td>
<td align=right>
<a href="../TOC.html"><strong><em>Contents</em></strong></a>
</td>
</tr>
</table>
<P ALIGN="CENTER">
<IMG SRC="../../jndiimages/shoeline2.GIF" ALIGN="BOTTOM" BORDER="0" WIDTH="202"
    HEIGHT="25" NATURALSIZEFLAG="3">
<IMG SRC="../../jndiimages/shoeline2.GIF" ALIGN="BOTTOM" BORDER="0" WIDTH="202"
    HEIGHT="25" NATURALSIZEFLAG="3">
</P>
<h1>
     Adding URL Support
</h1>
<p>
<blockquote>

The
<a target="_top" href="../../beyond/url/initctx.html">URLs</a> <a target="_top" href="../../beyond/url/initctx.html"><img src="../../jndiimages/beyondIcon.gif" width=20 height=20 border=0 alt="(in the Beyond the Basics trail)"></a>    lesson describes how the API user can pass a URL string to the initial
context and have that URL be processed by a <em>URL context implementation</em>.
This lesson shows you how to build a URL context implementation
and make it available to the API user.
This involves three steps:
<ul>
<li><a href=factory.html>Build an object factory</a> that dispatches
the request to the URL context implementation.
<li><a href=context.html>Build a context implementation</a> to process the URL.
<li><a href=env.html>Set up the environment</a> to make
the object factory available to the user program.
</ul>
<p>
The JNDI uses the implementation as follows:
<ul>
<li>To <a href=initctx.html>process URL strings</a> passed
as the name argument to methods in the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html"><tt>InitialContext</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   class and its subclasses
<li>To <a href=reference.html>process URL strings</a> in a
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Reference.html"><tt>Reference</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Reference.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   passed to
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/NamingManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><tt>NamingManager.getObjectInstance()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/NamingManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    and
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirectoryManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable, javax.naming.directory.Attributes)"><tt>DirectoryManager.getObjectInstance()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirectoryManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.

</ul>
This lesson describes these two ways in detail.

<blockquote>
<hr>
<strong>Prerequsite: </strong>
Before embarking on this lesson, you should already know how to
build a context implementation, the details of which are described in the
<a target="_top" href="../basics/index.html">The Essential Components</a> <a target="_top" href="../basics/index.html"><img src="../../jndiimages/providerIcon.gif" width=20 height=20 border=0 alt="(in the Building a Service Provider trail)"></a>    lesson.
If you are adding URL support to a directory context implementation,
then you should also read the
<a target="_top" href="../basics/index.html">Adding Directory Support</a> <a target="_top" href="../basics/index.html"><img src="../../jndiimages/providerIcon.gif" width=20 height=20 border=0 alt="(in the Building a Service Provider trail)"></a>    lesson.
</blockquote>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="../dir/extend.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="factory.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/providerHeader.gif" width=26 height=26 align=top border=0 alt="Building a Service Provider | "></a>
</td>
<td align=right>
<a href="../TOC.html"><strong><em>Contents</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
