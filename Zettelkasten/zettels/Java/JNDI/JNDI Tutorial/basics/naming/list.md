










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Listing a Context</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="lookup.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="bind.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/basicsHeader.gif" width=26 height=26 align=bottom border=0 alt="The Basics | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Naming Operations</em></strong></a>
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
    Listing a Context
</h2>
<p>
<blockquote>

Instead of getting a single object at a time, as with 

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><tt>Context.lookup()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>, you can list an entire context by using
a single operation.
There are two methods for listing a context:
one that returns the bindings and one that returns
only the name-to-object class name pairs.

<h4>The Context.List() Method</h4>

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#list(javax.naming.Name)"><tt>Context.list()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#list(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    returns an enumeration of 

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html"><tt>NameClassPair</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
Each <tt>NameClassPair</tt> consists of the object's name
and its class name.
The following code fragment lists the contents of the <tt>"awt"</tt> directory
(i.e., the files and directories found in <tt>"awt"</tt> directory).
<p>
<blockquote>
<pre>
NamingEnumeration list = ctx.list("awt");

while (list.hasMore()) {
    NameClassPair nc = (NameClassPair)list.next();
    System.out.println(nc);
}
</pre>
</blockquote>
</p>
Running <a href=src/List.java>this example</a>
yields the following output.

<blockquote>
<pre>
# java List
accessibility: javax.naming.Context
color: javax.naming.Context
datatransfer: javax.naming.Context
dnd: javax.naming.Context
event: javax.naming.Context
font: javax.naming.Context
geom: javax.naming.Context
im: javax.naming.Context
image: javax.naming.Context
peer: javax.naming.Context
print: javax.naming.Context
swing: javax.naming.Context
</pre>
</blockquote>

<h4>The Context.listBindings() Method</h4>

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#listBindings(javax.naming.Name)"><tt>Context.listBindings()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#listBindings(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     returns
an enumeration of 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Binding.html"><tt>Binding</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Binding.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
<tt>Binding</tt> is a subclass of <tt>NameClassPair</tt>.
A binding contains not only the object's name and class name, 
but also the object.
The following code enumerates the <tt>"awt"</tt> context,
printing out each binding's name and object.

<blockquote>
<pre>
NamingEnumeration bindings = ctx.listBindings("awt");

while (bindings.hasMore()) {
    Binding bd = (Binding)bindings.next();
    System.out.println(bd.getName() + ": " + bd.getObject());
}
</pre>
</blockquote>
<p>
Running <a href=src/ListBindings.java>this example</a> yields 
the following output.

<blockquote>
<pre>
# java ListBindings
accessibility: com.sun.jndi.fscontext.RefFSContext@1dacd52e
color: com.sun.jndi.fscontext.RefFSContext@1dacd551
datatransfer: com.sun.jndi.fscontext.RefFSContext@1dacd584
dnd: com.sun.jndi.fscontext.RefFSContext@1dacd5b6
event: com.sun.jndi.fscontext.RefFSContext@1dacd5e8
font: com.sun.jndi.fscontext.RefFSContext@1dacd61b
geom: com.sun.jndi.fscontext.RefFSContext@1dacd64d
im: com.sun.jndi.fscontext.RefFSContext@1dacd62a
image: com.sun.jndi.fscontext.RefFSContext@1dacd65c
peer: com.sun.jndi.fscontext.RefFSContext@1dacd68f
print: com.sun.jndi.fscontext.RefFSContext@1dacd6c1
swing: com.sun.jndi.fscontext.RefFSContext@1dacd6f3
</pre>
</blockquote>

<a name=CLOSE>
<h4>Terminating a NamingEnumeration</h4>
</a>

A 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingEnumeration.html"><tt>NamingEnumeration</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingEnumeration.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    can be terminated in one of three ways: naturally, explicitly, or
unexpectedly.
<ul>
<li>
When 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingEnumeration.html#hasMore()"><tt>NamingEnumeration.hasMore()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingEnumeration.html#hasMore()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   returns <tt>false</tt>, the enumeration is complete and effectively terminated.
<li>
You can terminate an enumeration explicitly before it has completed by invoking
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingEnumeration.html#close()"><tt>NamingEnumeration.close()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingEnumeration.html#close()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>. Doing this provides a hint to the underlying implementation to free up
any resources associated with the enumeration.
<li>
If either <tt>hasMore()</tt> or 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingEnumeration.html#next()"><tt>next()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingEnumeration.html#next()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    throws a
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingException.html"><tt>NamingException</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingException.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>, then the enumeration is effectively terminated.
</ul>
<p>
Regardless of how an enumeration has been terminated, once
terminated it can no longer be used.
Invoking a method on a terminated enumeration yields an undefined result.


<h4>Why Two Different List Methods?</h4>

<tt>list()</tt> is intended for browser-style applications that just
want to display the names of objects in a context. For example, a
browser might list the names in a context and wait for the user to
select one or a few of the names displayed to perform further
operations.  Such applications typically do not need access
to all of the objects in a context.

<p> 

<tt>listBindings()</tt> is intended for applications that need to
perform operations on the objects in a context en masse.  For
example, a backup application might need to perform "file stats"
operations on all of the objects in a file directory.  
Or a printer
administration program might want to restart all of the printers in a
building.  To perform such operations, these applications need to
obtain all of the objects bound in a context. Thus it is more
expedient to have the objects returned as part of the enumeration.

<p>
The application can use either <tt>list()</tt> or the potentially more expensive <tt>listBindings()</tt>,
depending on the type of information it needs.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="lookup.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="bind.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/basicsHeader.gif" width=26 height=26 align=top border=0 alt="The Basics | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Naming Operations</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
