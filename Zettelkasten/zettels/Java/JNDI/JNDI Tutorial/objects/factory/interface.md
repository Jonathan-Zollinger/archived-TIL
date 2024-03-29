










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Writing an Object Factory</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="index.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="uses.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Writing an Object Factory
</h2>
<p>
<blockquote>

An object factory implements either the 

<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/ObjectFactory.html><tt>ObjectFactory</tt> </a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/ObjectFactory.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     or
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirObjectFactory.html><tt>DirObjectFactory</tt> </a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirObjectFactory.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     interface.

<tt>ObjectFactory</tt> has one method: 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/ObjectFactory.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><tt>getObjectInstance()</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/ObjectFactory.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
<blockquote>
<pre>
public Object getObjectInstance(
	Object info, 
	Name name, 
	Context nameCtx,
	Hashtable environment) 
	throws Exception;
</pre>
</blockquote>

<tt>DirObjectFactory</tt> is a subinterface of <tt>ObjectFactory</tt>
and declares an additional method: 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirObjectFactory.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable, javax.naming.directory.Attributes)"><tt>getObjectInstance()</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirObjectFactory.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
<blockquote>
<pre>
public Object getObjectInstance(
	Object info, 
	Name name, 
	Context nameCtx,
	Hashtable environment,
	Attributes attrs) 
	throws Exception;
</pre>
</blockquote>

This method accepts as arguments information about the object (<tt>info</tt>) and
the name of the object (<tt>name</tt>) relative to the context 
(<tt>nameCtx</tt>) in which it is bound.
The <tt>env</tt> argument is the environment properties
of the context that is using the object factory.
See the

<a target="_top" href="../../beyond/index.html">Beyond the Basics</a> <a target="_top" href="../../beyond/index.html"><img src="../../jndiimages/beyondIcon.gif" width=20 height=20 border=0 alt="(in the Beyond the Basics trail)"></a>     trail for details about environment properties.
The <tt>DirObjectFactory</tt> version of the method accepts an additional <tt>attrs</tt> (
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/Attributes.html><tt>Attributes</tt> </a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/Attributes.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>) argument, which contains (some or all of) 
the attributes associated with <tt>obj</tt>.

<h4>ObjectFactory versus DirObjectFactory</h4>
You should use an <tt>ObjectFactory</tt> with a context that implements only the 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html><tt>Context</tt> </a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    interface.
Use a <tt>DirObjectFactory</tt>
with a context that implements the 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html><tt>DirContext</tt> </a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    interface.
<p>
For example, a COS naming service provider implements only the
<tt>Context</tt> interface. Because <tt>Attributes</tt> is not
relevant in that scenario, only <tt>getObjectInstance()</tt>
as defined in the <tt>ObjectFactory</tt> interface is relevant for
that service provider.
By contrast,
an LDAP service provider
typically implements the <tt>DirContext</tt> interface and
will use  <tt>getObjectInstance()</tt> as defined in
the <tt>DirObjectFactory</tt> interface.
The <tt>Attributes</tt> parameter is used by the service provider
to pass along any attributes associated with <tt>info</tt> to
the factory so that the factory does not have to fetch
the attributes itself. For example, when a service provider
does a
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><tt>Context.lookup()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>, it can pass  to <tt>getObjectInstance()</tt>
any attributes that it read from the server about the
object's being looked up.


<h4>Accessibility</h4>
The object factory class must not only
implement the <tt>ObjectFactory</tt>/<tt>DirObjectFactory</tt>
interface and provide an implementation for <tt>getObjectInstance()</tt>. 
It also must be public and must have a public
constructor that accepts no arguments.

<h4>Job Description</h4>
<p>
Typically, an object factory is quite simple and small.
Its main role is to collect the information necessary
to create an instance of the intended object's class and
then to invoke that class's constructor.
However, the complexity of 
the objects that it creates can vary significantly.
For example, the object factory examples given in this lesson are pretty trivial;
the objects that they create are also trivial.
By contrast,
an LDAP object factory creates an LDAP context,
which creates and manages connections to an LDAP server.
In this case, a relatively simple object factory is creating
a very complex object.
<p>

In general, the information that an object factory uses to create objects
comes from the directory. Consequently, a close relationship exists
between the representation of the objects as stored in the directory
and the object factory that creates the objects by using that 
information.
For example, if the object is represented as a set of attributes in
the directory, then the corresponding object factory must
know to extract information from those attributes 
so as to create the object.

<h4>If All Else Fails</h4>

An object factory is usually very specific regarding
the types of transformations that it will handle.
In fact, in many cases, as explained in the 
<a href=provider.html>Interaction Between Object Factories and
Service Providers section</a>,
the JNDI will ask an object factory to
try to create an instance of an object that was intended
for another object factory.
A single service provider commonly uses
multiple object factories.
Therefore if an object factory finds that it cannot
create an object based on the arguments supplied, then it should
return <tt>null</tt>.
Only if the object factory knows for sure that it
is supposed to create the object, but it can't, should
it throw an exception. Throwing an exception
precludes other object factories from being tried.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="index.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="uses.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
