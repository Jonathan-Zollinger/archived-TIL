










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Adding, Replacing, and Removing a Binding</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="list.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="rename.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Adding, Replacing, and Removing a Binding
</h2>
<p>
<blockquote>

The <tt>Context</tt> interface contains methods for 
<a href=#BIND>adding</a>,
<a href=#REBIND>replacing</a>, and 
<a href=#UNBIND>removing</a> a binding in a context.

<h4><a name=BIND>Adding a Binding</a></h4>

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#bind(javax.naming.Name, java.lang.Object)"><tt>Context.bind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#bind(javax.naming.Name, java.lang.Object)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     is used to add a binding to a context.
It accepts as arguments the name of the object and the object
to be bound.

<blockquote>
<pre>
// Create the object to be bound
Fruit fruit = new Fruit("orange");

// Perform the bind
ctx.bind("favorite", fruit);
</pre>
</blockquote>

<a href=src/Bind.java>This example</a> creates an object of class 
<a href=src/Fruit.java><tt>Fruit</tt></a>
and binds it to the name <tt>"favorite"</tt> in the context <tt>ctx</tt>.
If you subsequently looked up the name <tt>"favorite"</tt> in
<tt>ctx</tt>, then you would get the <tt>fruit</tt> object.
Note that to compile the <tt>Fruit</tt> class, you need the
<a href=src/FruitFactory.java><tt>FruitFactory</tt></a> class.
<p>

If you were to run this example twice, then the second attempt would fail with
a 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameAlreadyBoundException.html><tt>NameAlreadyBoundException</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameAlreadyBoundException.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>. This is because the name <tt>"favorite"</tt> is already bound.
For the second attempt to succeed, you would have to use
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#rebind(javax.naming.Name, java.lang.Object)"><tt>rebind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#rebind(javax.naming.Name, java.lang.Object)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.

<h4><a name=REBIND>Adding or Replacing a Binding</a></h4>

<tt>rebind()</tt> is used to add or replace a binding.
It accepts the same arguments as <tt>bind()</tt>, but the semantics
are such that if the name is already bound, 
then it will be unbound and the newly given object will be bound.

<blockquote>
<pre>
// Create the object to be bound
Fruit fruit = new Fruit("lemon");

// Perform the bind
ctx.rebind("favorite", fruit);
</pre>
</blockquote>

When you run <a href=src/Rebind.java>this example</a>, it will
replace the binding created by the <tt><a href=src/Bind.java>bind()</a></tt>
example.


<h4><a name=UNBIND>Removing a Binding</a></h4>

To remove a binding, you use
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#unbind(javax.naming.Name)"><tt>unbind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#unbind(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.

<blockquote>
<pre>
// Remove the binding
ctx.unbind("favorite");
</pre>
</blockquote>

<a href=src/Unbind.java>This example</a>, when run, removes
the binding that was created by the 
<tt><a href=src/Bind.java>bind()</a></tt> or
<tt><a href=src/Rebind.java>rebind()</a></tt>
example.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="list.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="rename.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
