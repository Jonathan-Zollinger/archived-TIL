










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Lists</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="lookup.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="search.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/objectsHeader.gif" width=26 height=26 align=bottom border=0 alt="Java Objects and the Directory | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Reading Objects from the Directory</em></strong></a>
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
    Lists
</h2>
<p>
<blockquote>

The
<a target="_top" href="../../basics/naming/list.html">Naming Operations</a> <a href="../../basics/naming/list.html"><img src="../../jndiimages/basicsIcon.gif" width=20 height=20 border=0 alt="(in the Basics trail)"></a>     lesson showed you how to list a context using the

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#list(javax.naming.Name)"><tt>Context.list()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#list(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     and

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#listBindings(javax.naming.Name)"><tt>Context.listBindings()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#listBindings(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     methods.
This section describes how these methods are affected
by object factories.

<h4>List</h4>

When you use <tt>Context.list()</tt>, you get back an enumeration of
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html"><tt>NameClassPair</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>. 

You can invoke

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#getClassName()"><tt>getClassName()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#getClassName()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    on each <tt>NameClassPair</tt> to obtain the class name of
the object in that binding.
<p>
For example, if you <a href=src/List.java>list the context</a>
that you used to bind the various objects in the
<a target="_top" href="../storing/index.html">Storing Objects in the Directory</a> <a href="../storing/index.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>     lesson, then you get the following output.
<blockquote>
<pre>
# java List
ou=Groups: javax.naming.directory.DirContext
ou=People: javax.naming.directory.DirContext
cn=Button: java.awt.Button
cn=Flower: Flower
cn=favorite: Fruit
cn=favDrink: javax.naming.directory.DirContext
cn=RefHello: Hello
cn=CorbaHello: javax.naming.directory.DirContext
cn=RmiiiopHello: javax.naming.directory.DirContext
cn=RemoteHello: HelloImpl
</pre>
</blockquote>
For each binding, the Java class name was determined based on
information stored in the directory, without
an instance of the object in the binding
necessarily having to be created.
No object factory was involved.

<a name=LB><h4>List Bindings</h4></a>

When you use <tt>Context.listBindings()</tt>, you get back an enumeration of
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Binding.html><tt>Binding</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Binding.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>. You can invoke

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Binding.html#getObject()"><tt>getObject()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Binding.html#getObject()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>
on each <tt>Binding</tt> to obtain the object in that binding.
The result of <tt>getObject()</tt> is the same as that obtained
by looking up the object by using 

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><tt>Context.lookup()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
<p>
For example, if you <a href=src/ListBindings.java>list the bindings</a> 
in the context that you used to bind the various objects in the
<a target="_top" href="../storing/index.html">Storing Objects in the Directory</a> <a href="../storing/index.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>     lesson, then you get the following output.
<blockquote>
<pre>
# java -Djava.security.manager -Djava.security.policy=.policy ListBindings
ou=Groups: com.sun.jndi.ldap.LdapCtx: com.sun.jndi.ldap.LdapCtx@1dacd730
ou=People: com.sun.jndi.ldap.LdapCtx: com.sun.jndi.ldap.LdapCtx@1dacd8ae
cn=Button: java.awt.Button: java.awt.Button[button0,0,0,0x0,invalid,label=Push me]
cn=Flower: Flower: pink rose
cn=favorite: Fruit: orange
cn=favDrink: Drink: water
cn=RemoteHello: HelloImpl_Stub: HelloImpl_Stub[RemoteStub [ref: [endpoint:[129.111.111.111:44999](remote),objID:[-68dff7b3:d975735a08:-8000, 0]]]]
cn=RefHello: HelloImpl_Stub: HelloImpl_Stub[RemoteStub [ref: [endpoint:[129.111.111.111:45006](remote),objID:[2bf4308e:d975745b44:-8000, 0]]]]
cn=CorbaHello: com.sun.CORBA.idl.CORBAObjectImpl: com.sun.CORBA.idl.CORBAObjectImpl:com.sun.CORBA.idl.GenericCORBAClientSC@84675dd2
cn=RmiiiopHello: com.sun.CORBA.idl.CORBAObjectImpl: com.sun.CORBA.idl.CORBAObjectImpl:com.sun.CORBA.idl.GenericCORBAClientSC@ac6b5dd2
</pre>
</blockquote>
Notice that the <tt>"cn=favDrink"</tt> entry and a few others
now have a more precise class name
(<tt>"Drink"</tt>, <tt>"HelloImpl_Stub"</tt>). 
This is because instantiating the object (by the corresponding 
object factory) provided more class information.
Notice also that the remote object <tt>HelloImpl</tt> was returned as
a stub to the real object.

<a name=NOTES><blockquote></a>
<hr>
<strong>Note 1:</strong>
You must run this example by using the
<a href=http://java.sun.com/products/jdk/1.2/>Java 2 Platform, v1.2</a>,
or higher release because some of the object factories require that platform.
<p>
<strong>Note 2:</strong>
The <tt>-Djava.security.manager</tt> option specifies that the
default security manager be used, and the <tt>-Djava.security.policy=.policy</tt>
option specifies that the <a href=src/.policy><tt>.policy</tt> file</a> be
used for the security policy. These two options are needed when 
you are listing/looking up the <tt>java.rmi.Remote</tt> objects.
In the policy file, you need to
grant permission to connect to and accept connections from the Web
server and the machine on which the remote objects are running.
</blockquote>


</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="lookup.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="search.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/objectsHeader.gif" width=26 height=26 align=top border=0 alt="Java Objects and the Directory | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Reading Objects from the Directory</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
