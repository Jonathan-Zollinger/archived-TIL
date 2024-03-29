










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>URL Context Factory</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="index.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="context.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    URL Context Factory
</h2>
<p>
<blockquote>

A <em>URL context factory</em> is a special object factory that
creates contexts for resolving URL strings.
Like all object factories,
it is a class that implements the 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/ObjectFactory.html"><tt>ObjectFactory</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/ObjectFactory.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    interface. 
A URL context factory must not only satisfy
all of the requirements specified for
object factories as stated in the
<a target="_top" href="../../objects/factory/index.html">Object Factories</a> <a href="../../objects/factory/index.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>    lesson. It also must adhere to the following rules.
<ul>
<li>
A <tt>null</tt> object argument to
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/ObjectFactory.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><tt>getObjectInstance()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/ObjectFactory.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    means that the factory should
create a context for resolving arbitrary URL strings of the scheme associated
with the factory. For example, such an invocation on a factory
for the <tt>ldap</tt> scheme would return a context that accepts arbitrary LDAP URL
strings,
such as
<tt>"ldap://ldap.wiz.com/o=wiz,c=us"</tt> and
<tt>"ldap://ldap.umich.edu/o=umich,c=us"</tt>.
<li>
If the object argument to <tt>getObjectInstance()</tt> is a 
URL string (<tt>java.lang.String</tt>) of a scheme acceptable to that factory, 
then the factory should return
an object (which might not necessarily be a context) identified by the URL string.
For example, if <tt>getObjectInstance()</tt> is given the string
<tt>"ldap://ldap.wiz.com/o=wiz,c=us"</tt>, 
then it would return the object
named by the DN <tt>"o=wiz, c=us"</tt> at the LDAP server 
<tt>ldap.wiz.com</tt>.
<li>
If the object argument to <tt>getObjectInstance()</tt> is an array of
URL strings (<tt>java.lang.String[]</tt>), 
then the factory should return the object named by any one
of the URL strings.
All of the URL strings in the array are assumed to be equivalent in
terms of the object to which they refer. Verification of whether the
strings are, or need to be, equivalent is up to the factory. The
order of the URL strings in the array is insignificant. 
</ul>

If the factory receives any other type of object argument to
<tt>getObjectInstance()</tt>, then its behavior is implementation-dependent.
<p>
The first rule applies to supporting the resolution of URL strings from the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html"><tt>InitialContext</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>--this is described <a href=initctx.html>later</a> in this lesson.

The second and third rules apply to supporting the resolution of URL
strings embedded in a <tt>Reference</tt>--this is also described <a
href=reference.html>later</a> in this lesson.  As indicated by the
second and third rules, a URL <em>context</em> factory is not 
only a
producer of <em>context</em> objects. It can produce any type of
object named by a URL string.

<h4>Class Name's Naming Convention</h4>

The URL context factory's class name must use the following
naming convention so that it can be located by the JNDI framework:
<blockquote>
<em>package_prefix</em><strong>.</strong><em>scheme_id</em><strong>.</strong><em>scheme_id</em><tt>URLContextFactory</tt>
</blockquote>
where
<ul>
<li><em>package_prefix</em> is a valid prefix for a package in the 
Java programming language and
<li><em>scheme_id</em> is the naming/directory service's URL scheme id
(for example, <tt>ldap</tt> is the scheme id for services that support the
LDAP).
</ul>
For example, the class name <tt>tut.foo.fooURLContextFactory</tt>
is for the <tt>foo</tt> URL scheme; it has the package prefix 
<tt>"tut"</tt>.
In another example, the class name <tt>com.sun.jndi.url.ldap.ldapURLContextFactory</tt>
is for the <tt>ldap</tt> URL scheme; it has the package prefix 
<tt>"com.sun.jndi.url"</tt>. 
Notice that <em>package_prefix</em> must not be empty.

<h4>Sample Implementation</h4>

This section offers
<a href=src/tut/foo/fooURLContextFactory.java>an example</a> of how to 
implement a URL context factory. This example is
for illustrative purposes and is not meant
to be prescriptive.
<p>
The example is for the <tt>foo</tt> URL scheme, which has the syntax
<blockquote>
<tt>foo:</tt><em>name in the </em><tt>HierCtx</tt><em> namespace</em>
</blockquote>
<a href=src/tut/HierCtx.java><tt>HierCtx</tt></a> is an in-memory
hierarchical namespace implementation. To make it work with the
URL example, you need to create a static namespace that can be accessed
by using a static method on the <tt>HierCtx</tt> class.
Using a <tt>foo</tt> URL string, you can name the objects in this
static namespace.
<p>
Like all object factories, a URL context factory must be public and
have a public constructor that accepts no arguments.
<blockquote><pre>
public class fooURLContextFactory implements ObjectFactory {
    public fooURLContextFactory() {
    }
    ...
}
</blockquote></pre>
<p>
This factory's implementation of <tt>getObjectInstance()</tt>
fairly well follows the three rules listed previously.
The implementations of these rules use the following utility
to create a context from the context implementation
<a href=src/tut/foo/fooURLContext.java><tt>fooURLContext</tt></a>.
<blockquote><pre>
protected Context getURLContext(Hashtable env) {
    return new fooURLContext(env);
}
</pre></blockquote>
An actual implementation may or may not choose this strategy
of using one context implementation to satisfy all three
requirements. It is perfectly acceptable to have a factory
that uses different context implementations.
<p>
In the following examples, <tt>urlInfo</tt> is the object argument
to <tt>getObjectInstance()</tt>.
<p>
For the first rule, you simply return the root <tt>fooURLContext</tt>.
<blockquote><pre>
if (urlInfo == null) {
    return createURLContext(env);
}
</blockquote></pre>
<p>
For the second rule, you use the root <tt>fooURLContext</tt>
to look up and return the object named by
the URL string.
<blockquote><pre>
if (urlInfo instanceof String) {
    Context urlCtx = createURLContext(env);
    try {
        return urlCtx.lookup((String)urlInfo);
    } finally {
        urlCtx.close();
    }
} 
</blockquote></pre>
Notice that before the method returns, it closes the root <tt>fooURLContext</tt>.
In this particular example, this step is not really necessary
because <tt>fooURLContext</tt> doesn't maintain any connections
or resources.
However, doing this is good practice so as to 
ensure that implementations
that do maintain connections or resources are cleaned up properly.
<p>
For the third rule, you iterate over the array of URL strings
until you find one that succeeds. You save one of the exceptions
encountered along the way in case all of the URL strings fail
and you need to indicate why.
<blockquote><pre>
if (urlInfo instanceof String[]) {

    // Try each URL until lookup() succeeds for one of them.
    // If all URLs fail, throw one of the exceptions arbitrarily.
    String[] urls = (String[])urlInfo;
    if (urls.length == 0) {
        throw (new ConfigurationException("fooURLContextFactory: empty URL array"));
    }
    Context urlCtx = createURLContext(env);
    try {
	NamingException ne = null;
	for (int i = 0; i &lt; urls.length; i++) {
	    try {
	        return urlCtx.lookup(urls[i]);
	    } catch (NamingException e) {
	        ne = e;
	    }
        }
        throw ne;
    } finally {
        urlCtx.close();
    }
}
</blockquote></pre>


</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="index.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="context.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
