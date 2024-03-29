










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Other Uses</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="interface.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="provider.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Other Uses
</h2>
<p>
<blockquote>

The object factory is actually a general mechanism used throughout the JNDI.
In this lesson, object factories are used to
transform information stored in the directory into Java objects
that applications can use. And typically, these objects are objects
that the application uses directly (for example, like a <tt>Person</tt> object
or a <tt>Drink</tt> or <tt>Fruit</tt> object).
<p>
The following discussion introduces you to other uses of
object factories. 
It is intended as background information for API users.
Developers of service providers can find
full discussions of these topics in the

<a target="_top" href="../../beyond/index.html">Beyond the Basics</a> <a target="_top" href="../../beyond/index.html"><img src="../../jndiimages/beyondIcon.gif" width=20 height=20 border=0 alt="(in the Beyond the Basics trail)"></a>     trail and the
<a target="_top" href="../../provider/index.html">Building a Service Provider</a> <a target="_top" href="../../provider/index.html"><img src="../../jndiimages/providerIcon.gif" width=20 height=20 border=0 alt="(in the Building a Service Provider trail)"></a>     trail.



<h4>Federation and Context Factories</h4>

<p>
You saw how an object can be bound into the directory.  What if
the object happens to be the root of another naming system?  
In the LDAP,
for example, you can bind an object that is the root of a file system.
You can then supply an object factory whose role it is to convert the
information stored in the LDAP directory about the file system into
the <em>root</em> context of the file system.  This type of object
factory is called a 
<a href=../../getStarted/concepts/glossary.html#CF><em>context factory</em></a>.
Given information about the context object to create, a
context factory will create and return an instance of

<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html><tt>Context</tt> </a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
<p>
The file system in this example is called the
<a href=../../getStarted/concepts/glossary.html#NNS>nns</a>
(see the
<a target="_top" href="../../beyond/fed/current.html">Federation</a> <a target="_top" href="../../beyond/fed/current.html"><img src="../../jndiimages/beyondIcon.gif" width=20 height=20 border=0 alt="(in the Beyond the Basics trail)"></a>    lesson).
Just as the nature of the information stored in a directory
about a Java object can vary (from a reference to attributes to 
a serialized object),
so can the nature of the information stored in a directory about the nns.
In the file system example, you might store a URL that identifies
the file system's server and protocol information as a JNDI reference.
<p>
By storing nns information in a
directory, you are 
<a href=../../getStarted/concepts/glossary.html#FEDERATE>federating</a>.
naming systems, 
thereby allowing them to resolve composite names.
See the
<a target="_top" href="../../beyond/fed/index.html">Federation</a> <a target="_top" href="../../beyond/fed/index.html"><img src="../../jndiimages/beyondIcon.gif" width=20 height=20 border=0 alt="(in the Beyond the Basics trail)"></a>    lesson for details.


<h4>URL Context Factories</h4>

A special kind of context factory is a <em>URL context factory</em>,
which creates contexts for resolving URLs or contexts whose 
locations are
specified by URLs.  
For example, an LDAP URL context factory can create a context 
for accepting arbitrary LDAP URLs.
The same LDAP URL context factory can create a context identified by 
an LDAP URL. That context will then be able to resolve
names relative to the location specified by the URL.
<p>
URL context factories are used for federation and are also used by the 
<a href=../../getStarted/concepts/glossary.html#IC><em>initial context</em></a>
to resolve and process requests for URLs.
In fact, in the 
<a target="_top" href="../storing/remote.html#REF">remote reference example</a> <a href="../storing/remote.html#REF"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>, the remote object is stored in the directory as a reference
that contains an RMI URL. When the object is looked up from the directory, the
JNDI uses an RMI URL context factory to look up and return
the object from the RMI registry named in the URL.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="interface.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="provider.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
