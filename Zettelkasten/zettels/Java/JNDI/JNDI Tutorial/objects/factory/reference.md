










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Reference Example</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="provider.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="dircontext.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Reference Example
</h2>
<p>
<blockquote>

The 
<a target="_top" href="../storing/reference.html#EXAMPLE">reference example</a> <a href="../storing/reference.html#EXAMPLE"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>     illustrates how an instance of a <tt>Referenceable</tt> class
<a href=../storing/src/Fruit.java><tt>Fruit</tt></a>
is stored in and subsequently 
looked up from the directory. 
When the reference is looked up from the directory,

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><tt>Context.lookup()</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     turned the data read from the directory into an
instance of <tt>Fruit</tt>.
<blockquote>
<pre>
Fruit f2 = (Fruit) ctx.lookup("cn=favorite");
</pre>
</blockquote>

This happens because of the following.
<ol>
<li>The service provider being used (Sun's LDAP service provider)
invoked
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirectoryManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable, javax.naming.directory.Attributes)"><tt>DirectoryManager.getObjectInstance()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirectoryManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     and supplied the method the data (a reference) that 
the provider read from the directory for the entry 
<tt>"cn=favorite"</tt>.
<li>
The reference identified 
<a href=../storing/src/FruitFactory.java><tt>FruitFactory</tt></a> as
the object factory's class name.
<li><tt>FruitFactory.getObjectInstance()</tt> returned an
instance of <tt>Fruit</tt>.
</ol>
<tt>FruitFactory.getObjectInstance()</tt> is simple.
It first verifies that it can do something with the data.
That is, it checks that the data is a <tt>Reference</tt> containing an 
address of type <tt>"fruit"</tt>
and that the reference is for objects of 
class <tt>Fruit</tt>.
If this verification fails, then the factory returns <tt>null</tt> so that other
factories, if any, can be attempted.
If it succeeds, then the content of the address 
(in this case <tt>"orange"</tt>)
is used to create a new instance of 
<a href=../storing/src/Fruit.java><tt>Fruit</tt></a>,
which is then returned.
<p>
The definition of <tt>FruitFactory.getObjectInstance()</tt>
is as follows.
<blockquote>
<pre>
public Object getObjectInstance(Object obj, Name name, Context ctx,
    Hashtable env) throws Exception {
    if (obj instanceof Reference) {
        Reference ref = (Reference)obj;
        if (ref.getClassName().equals(Fruit.class.getClassName())) {
	    RefAddr addr = ref.get("fruit");
	    if (addr != null) {
  	        return new Fruit((String)addr.getContent());
	    }
        }
    }
    return null;
}
</pre>
</blockquote>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="provider.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="dircontext.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
