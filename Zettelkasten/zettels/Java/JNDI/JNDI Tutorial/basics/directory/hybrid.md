










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Hybrid Naming and Directory Operations</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="timelimit.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="../end.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/basicsHeader.gif" width=26 height=26 align=bottom border=0 alt="The Basics | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Directory Operations</em></strong></a>
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
    Hybrid Naming and Directory Operations
</h2>
<p>
<blockquote>

The 

<a target="_top" href="../naming/index.html">Naming Concepts</a> <a href="../naming/index.html"><img src="../../jndiimages/basicsIcon.gif" width=20 height=20 border=0 alt="(in the Basics trail)"></a>      lesson discussed how you can use
<a href=../naming/bind.html><tt>bind()</tt>, <tt>rebind()</tt></a>,
and 
<a href=../naming/create.html><tt>createSubcontext()</tt></a> 
   in the 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html><tt>Context</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     interface to create bindings and subcontexts.
The 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html><tt>DirContext</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     interface contains overloaded versions
of these methods that accept attributes.
You can use these <tt>DirContext</tt> methods to associate
attributes with the object at the time that the binding or subcontext
is added to the namespace.
For example, you might create a <tt>Person</tt> object and bind it to
the namespace and at the same time associate attributes about that
<tt>Person</tt> object.
<p>

<blockquote>
<hr>
<strong>Before you go on:</strong>
The examples in this lesson require that you make additions to the schema.
You must either turn off schema-checking in the LDAP
server or add <a href=../../config/LDAP/java.schema>
the schema</a> that accompanies this tutorial to the server.
Both of these tasks are typically performed by the directory
server's administrator. See the

<a target="_top" href="../prepare/content.html">Preparations</a> <a href="../prepare/content.html"><img src="../../jndiimages/basicsIcon.gif" width=20 height=20 border=0 alt="(in the Basics trail)"></a>    lesson.

<p>
<strong>OpenLDAP:</strong>
In versions of the LDAP provider prior to the Java 2 SDK, v1.4,
these examples will not work against the OpenLDAP directory server
because these versions of the LDAP provider do not include the
new entry's relative distinguished name (RDN) in the set of attributes
to add.
To workaround the problem, you must modify the examples to 
supply the RDN of the entry (i.e., the "ou" attribute)
as an attribute in the <tt>Attributes</tt> parameter.

<hr>
</blockquote>

<h4><a name=CREATE>Creating a Context That Has Attributes</a></h4>

To create a context that has attributes, you supply to
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#createSubcontext(javax.naming.Name, javax.naming.directory.Attributes)"><tt>DirContext.createSubcontext()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#createSubcontext(javax.naming.Name, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    the name of the context that you want
to create and its attributes.
<blockquote>
<pre>
// Create attributes to be associated with the new context
Attributes attrs = new BasicAttributes(true); // case-ignore
Attribute objclass = new BasicAttribute("objectclass");
objclass.add("top");
objclass.add("organizationalUnit");
attrs.put(objclass);

// Create the context
Context result = ctx.createSubcontext("ou=Fruits", attrs);
</pre>
</blockquote>

<a href=src/Create.java>This example</a> creates a new context called <tt>"ou=Fruits"</tt>
that has an attribute <tt>"objectclass"</tt> with two values, 
<tt>"top"</tt> and <tt>"organizationalUnit"</tt>,
in the context <tt>ctx</tt>.
If you list the context <tt>ctx</tt>, then you will see
that it now contains an
entry for <tt>"ou=Fruits"</tt>.

<blockquote>
<pre>
# java Create
ou=Groups: javax.naming.directory.DirContext
ou=People: javax.naming.directory.DirContext
ou=Fruits: javax.naming.directory.DirContext
</pre>
</blockquote>


<h4><a name=BIND>Adding a Binding That Has Attributes</a></h4>

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#bind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><tt>DirContext.bind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#bind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     is used to add a binding 
that has attributes to a context.
It accepts as arguments the name of the object, the object
to be bound, and a set of attributes.

<blockquote>
<pre>
// Create the object to be bound
Fruit fruit = new Fruit("orange");

// Create attributes to be associated with the object
Attributes attrs = new BasicAttributes(true); // case-ignore
Attribute objclass = new BasicAttribute("objectclass");
objclass.add("top");
objclass.add("organizationalUnit");
attrs.put(objclass);

// Perform bind
ctx.bind("ou=favorite, ou=Fruits", fruit, attrs);
</pre>
</blockquote>

<a href=src/Bind.java>This example</a> creates an object of class 
<a href=src/Fruit.java><tt>Fruit</tt></a>
and binds it to the name <tt>"ou=favorite"</tt> into the context named <tt>"ou=Fruits"</tt>,
relative to <tt>ctx</tt>.
This binding has the <tt>"objectclass"</tt> attribute.
If you subsequently looked up the name 
<tt>"ou=favorite, ou=Fruits"</tt> in
<tt>ctx</tt>, then you would get the <tt>fruit</tt> object.
If you then got the attributes of <tt>"ou=favorite, ou=Fruits"</tt>,
you would get those attributes with which the object was created.
Following is this example's output.
<blockquote>
<pre>
# java Bind
orange
attribute: objectclass
value: top
value: organizationalUnit
value: javaObject
value: javaNamingReference
attribute: javaclassname
value: Fruit
attribute: javafactory
value: FruitFactory
attribute: javareferenceaddress
value: #0#fruit#orange
attribute: ou
value: favorite
</pre>
</blockquote>

<p>
The extra attributes and attribute values shown are
used to store information about the object (<tt>fruit</tt>).
These extra attributes are discussed in more detail in the
<a target="_top" href="../../objects/index.html">Java Objects and the Directory</a> <a href="../../objects/index.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>     trail.
<p>

If you were to run this example twice, then the second attempt would fail with a 

<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameAlreadyBoundException.html><tt>NameAlreadyBoundException</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameAlreadyBoundException.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>. This is because the name <tt>"ou=favorite"</tt> is already bound in the <tt>"ou=Fruits"</tt> context.
For the second attempt to succeed, you would have to use
<tt>rebind()</tt>.

<h4><a name=REBIND>Replacing a Binding That Has Attributes</a></h4>

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#rebind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><tt>DirContext.rebind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#rebind(javax.naming.Name, java.lang.Object, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     is used to add or replace a binding
and its attributes.
It accepts the same arguments as <tt>bind()</tt>.
However, <tt>rebind()</tt>'s semantics require that
if the name is already bound, then
it will be unbound and the newly given object and attributes 
will be bound.

<blockquote>
<pre>
// Create the object to be bound
Fruit fruit = new Fruit("lemon");

// Create attributes to be associated with the object
Attributes attrs = new BasicAttributes(true); // case-ignore
Attribute objclass = new BasicAttribute("objectclass");
objclass.add("top");
objclass.add("organizationalUnit");
attrs.put(objclass);

// Perform bind
ctx.rebind("ou=favorite, ou=Fruits", fruit, attrs);
</pre>
</blockquote>

When you run <a href=src/Rebind.java>this example</a>, it
replaces the binding that the <tt><a href=src/Bind.java>bind()</a></tt>
example created.

<blockquote>
<pre>
# java Rebind
lemon
attribute: objectclass
value: top
value: organizationalUnit
value: javaObject
value: javaNamingReference
attribute: javaclassname
value: Fruit
attribute: javafactory
value: FruitFactory
attribute: javareferenceaddress
value: #0#fruit#lemon
attribute: ou
value: favorite
</pre>
</blockquote>


</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="timelimit.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="../end.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/basicsHeader.gif" width=26 height=26 align=top border=0 alt="The Basics | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Directory Operations</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
