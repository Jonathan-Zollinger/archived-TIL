










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Storing Objects in the Directory</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="../index.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="serial.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/objectsHeader.gif" width=26 height=26 align=bottom border=0 alt="Java Objects and the Directory | "></a>
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
     Storing Objects in the Directory
</h1>
<p>
<blockquote>

<p>
Applications and services can use
the directory in different ways to store and locate objects.
For example, an application might store (a copy of) 
the object itself, 
a reference to an object, or attributes that describe the object.
In general terms, 
a Java<sup><font size=-1>TM</font></sup>
object's serialized form contains the object's state
and an object's reference is a compact representation of
addressing information that can be used to contact the object.
Some examples are given in the 
<a target="_top" href="../../getStarted/concepts/naming.html#REF">Naming Concepts</a> <a target="_top" href="../../getStarted/concepts/naming.html#REF"><img src="../../jndiimages/getStartedIcon.gif" width=20 height=20 border=0 alt="(in the Getting Started trail)"></a>     lesson.
An object's attributes are properties that are used to describe the
object; attributes
might include addressing and/or state information.
<p>
Which of these three ways to use depends on the application/system
that is being built and how it needs to interoperate with other
applications and systems that will share the objects stored in
the directory. 
Another factor is the support provided by the 
<a href=../../getStarted/concepts/glossary.html#PROVIDER>service provider</a>
and the underlying directory service.
<p>
Programmatically, all applications use one of the following methods
when storing objects in the directory:
<ul>
<li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#bind(javax.naming.Name, java.lang.Object)"><tt>Context.bind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#bind(javax.naming.Name, java.lang.Object)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#bind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><tt>DirContext.bind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#bind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#rebind(javax.naming.Name, java.lang.Object)"><tt>Context.rebind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#rebind(javax.naming.Name, java.lang.Object)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#rebind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><tt>DirContext.rebind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#rebind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a></ul>
The application passes the object that it wants to store to one
of these methods.
Then, depending on the types of objects that the
service provider supports, the object will be transformed into a representation
acceptable to the underlying directory service.
<p>
This lesson shows how to create different types of objects
and store them in the directory.
<ul>
<li><a href=serial.html>Java serializable objects</a>
<li><a href=reference.html><tt>Referenceable</tt> objects and JNDI 
<tt>Reference</tt>s</a>
<li><a href=dircontext.html>Objects with attributes (<tt>DirContext</tt>)</a>
<li><a href=remote.html>RMI (Java Remote Method Invocation) objects
(including those that use IIOP)</a>
<li><a href=corba.html>CORBA objects</a>
</ul>

<p>

<a name=REQ></a>
<blockquote>
<hr>
<strong>Before you go on:</strong>
The examples in this lesson use the LDAP directory.
The initial context used in these examples is initialized
using the following environment properties.
<blockquote>
<pre>
// Set up environment for creating the initial context
Hashtable env = new Hashtable();
env.put(Context.INITIAL_CONTEXT_FACTORY, 
    "com.sun.jndi.ldap.LdapCtxFactory");
env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");
</pre>
</blockquote>
<p>
<strong>Schema:</strong>
To run these examples successfully, 
you must either turn off schema-checking in the
server or add <a href=../../config/LDAP/java.schema>
the Java schema</a>
and <a href=../../config/LDAP/corba.schema>
the CORBA schema</a>
that accompany this tutorial to the server.
Both of these tasks are typically performed by the directory
server's administrator. See the
<a target="_top" href="../../basics/prepare/content.html#SCHEMA">Preparations</a> <a href="../../basics/prepare/content.html#SCHEMA"><img src="../../jndiimages/basicsIcon.gif" width=20 height=20 border=0 alt="(in the Basics trail)"></a>     lesson for more information.

<p>
<strong>Software Requirements:</strong>
In addition to the software requirements listed in the 
<a target="_top" href="../../basics/prepare/software.html">Preparations</a> <a href="../../basics/prepare/software.html"><img src="../../jndiimages/basicsIcon.gif" width=20 height=20 border=0 alt="(in the Basics trail)"></a>     lesson, 
you also need the following archive files when using the examples 
related to RMI and CORBA:
<tt>ldapbp.jar</tt>, and <tt>rmiregistry.jar</tt>.
The <tt>ldapbp.jar</tt> can be downloaded as part of the LDAP service provider from
the <a href=http://java.sun.com/products/jndi/#download>JNDI Web site</a>.
<tt>rmiregistry.jar</tt> is available
as part of the <a href=http://java.sun.com/j2se/1.3>Java 2 SDK, v1.3</a>,
so, if you are using that SDK, then you won't need to add <tt>rmiregistry.jar</tt>
separately. Otherwise, you can download it from
the <a href=http://java.sun.com/products/jndi/#download>JNDI Web site</a>.
<p>
To try the CORBA and RMI/IIOP examples, you need the CORBA classes.
If you are using the
<a href=http://java.sun.com/products/jdk/1.2/>Java 2 SDK, v1.2</a>
or higher releases, then you already have those classes.
Otherwise, you need to install the Java IDL,
a version of which comes with the
<a href="http://java.sun.com/products/rmi-iiop/">RMI-IIOP Standard Extension</a>.
<p>
If you are not using the
<a href=http://java.sun.com/j2se/1.3>Java 2 SDK, v1.3</a>
and you want to try the RMI example that uses IIOP,
then you need to install the 
<a href="http://java.sun.com/products/rmi-iiop/">RMI-IIOP Standard Extension</a>.

<p>
<strong>OpenLDAP:</strong>
In versions of the LDAP provider prior to the Java 2 SDK, v1.4,
these examples will not work against the OpenLDAP directory server
because these versions of the LDAP provider do not include the
new entry's relative distinguished name (RDN) in the set of attributes
to add.
To workaround the problem, you must modify the examples to use
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#bind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><tt>DirContext.bind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#bind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>  or
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#rebind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><tt>DirContext.rebind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#rebind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>  and supply the RDN of the entry
as an attribute in the <tt>Attributes</tt> parameter.
<p>
<strong>Windows Active Directory:</strong>

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#rebind(javax.naming.Name, java.lang.Object)"><tt>Context.rebind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#rebind(javax.naming.Name, java.lang.Object)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>  and
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#rebind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><tt>DirContext.rebind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#rebind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>  do not work against Active Directory because these methods work by
reading the attributes of the entry to be updated, removing the entry,
and then adding a new entry that contains the modified attributes.
Active Directory returns some attributes that cannot be set by the user,
causing the final addition step to fail.
The workaround for this problem is to use
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name)"><tt>DirContext.getAttributes()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    to obtain and save the attributes that you want to keep.
Then, remove the entry and add it back with the saved attributes (and 
any others that you want to add) using 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#bind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><tt>DirContext.bind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#bind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.

</blockquote>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="../index.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="serial.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/objectsHeader.gif" width=26 height=26 align=top border=0 alt="Java Objects and the Directory | "></a>
</td>
<td align=right>
<a href="../TOC.html"><strong><em>Contents</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
