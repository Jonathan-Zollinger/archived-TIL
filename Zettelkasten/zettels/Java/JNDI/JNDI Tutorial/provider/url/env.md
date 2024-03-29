










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Making the Implementation Available</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="dircontext.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="initctx.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/providerHeader.gif" width=26 height=26 align=bottom border=0 alt="Building a Service Provider | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Adding URL Support</em></strong></a>
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
    Making the Implementation Available
</h2>
<p>
<blockquote>

The JNDI looks for URL context factories by examining the

<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#URL_PKG_PREFIXES><tt>Context.URL_PKG_PREFIXES</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#URL_PKG_PREFIXES><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a> (<tt>"java.naming.factory.url.pkgs"</tt>) environment property.
This property contains a colon-separated list of package prefixes
of the class names for the URL context factories.
The prefix <tt>"com.sun.jndi.url"</tt> is always appended to
the possibly empty list of package prefixes.
<p>
In <a href=src/tut/foo/fooURLContextFactory.java>the <tt>foo</tt> URL example</a>,
the factory's fully qualified class name is
<tt>tut.foo.fooURLContextFactory</tt>.
Therefore, to include this factory in the list of URL context
factories that the JNDI knows about, you set the
<tt>Context.URL_PKG_PREFIXES</tt> property 
<a href=src/jndi.properties>as follows</a>:
<blockquote><pre>
java.naming.factory.url.pkgs=tut
</pre></blockquote>
<p>
The JNDI looks for a URL context factory based on its URL scheme id.
Suppose that the JNDI is looking for a factory for the <tt>ldap</tt> URL scheme.
It would look for the following classes:
<blockquote><pre>
tut.ldap.ldapURLContextFactory
com.sun.jndi.url.ldap.ldapURLContextFactory
</pre></blockquote>
Similarly, with the same property setting, the JNDI would look for
the following classes for the <tt>foo</tt> URL scheme:
<blockquote><pre>
tut.foo.fooURLContextFactory
com.sun.jndi.url.foo.fooURLContextFactory
</pre></blockquote>
From this ordered list of class names, the JNDI will instantiate each class
in turn and invoke
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/ObjectFactory.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><tt>getObjectInstance()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/ObjectFactory.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   on it until one class returns a non-<tt>null</tt> answer.
The non-<tt>null</tt> answer becomes the URL context implementation
that will be used for that URL scheme.
<p>
As a service provider developer, you typically package the components
of your service provider 
(the context implementation for the naming/directory,
URL context factory, and URL context implementation)
into an
archive (JAR) file.
To make the URL context factory automatically available to any
program that uses this JAR file, you should include in it
a <tt>jndi.properties</tt> file that contains a setting
for the <tt>Context.URL_PKG_PREFIXES</tt> property, as shown in
the earlier example.
See the
<a target="_top" href="../../beyond/env/source.html">Environment Properties</a> <a target="_top" href="../../beyond/env/source.html"><img src="../../jndiimages/beyondIcon.gif" width=20 height=20 border=0 alt="(in the Beyond the Basics trail)"></a>    lesson for more information on how the JNDI reads and merges
environment properties from different sources.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="dircontext.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="initctx.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/providerHeader.gif" width=26 height=26 align=top border=0 alt="Building a Service Provider | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Adding URL Support</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
