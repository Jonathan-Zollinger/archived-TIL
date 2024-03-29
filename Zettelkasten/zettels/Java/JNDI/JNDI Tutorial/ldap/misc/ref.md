










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Storing Objects</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="rename.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="url.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/ldapHeader.gif" width=26 height=26 align=bottom border=0 alt="Tips for LDAP Users | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Miscellaneous</em></strong></a>
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
    Storing Objects
</h2>
<p>
<blockquote>

The
<a target="_top" href="../../objects/index.html">Java Objects and the Directory</a> <a href="../../objects/index.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>     trail showed you how to store and read Java objects from the directory.
Specifically, the
<a target="_top" href="../../objects/representation/ldap.html">LDAP Directories</a> <a href="../../objects/representation/ldap.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>    section discussed how Java objects are represented as attributes
in an LDAP directory.
If you have not yet gone through that trail, then
before going further you might want
to at least read through that trail to understand some of the terminology used here.
<p>
The
<a target="_top" href="../../objects/representation/ldap.html">LDAP Directories</a> <a href="../../objects/representation/ldap.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>     section and <A HREF="http://www.ietf.org/rfc/rfc2713.txt">RFC 2713</A> describe the representation of a
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Reference.html><tt>Reference</tt> </a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Reference.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    as multiple LDAP attributes. By default, the hash character ("#") is used
to encode the 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/RefAddr.html><tt>RefAddr</tt> </a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/RefAddr.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     in the <tt>Reference</tt>. If this character already appears in
the contents of the <tt>RefAddr</tt>, then you need to use another
character. You do this by setting the
<tt>"java.naming.ldap.ref.separator"</tt> environment property
to a string containing the separator character.
<p>
Here's an example.
If you run the 
<a target="_top" href="../../objects/storing/reference.html">reference example</a> <a href="../../objects/storing/reference.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>     and then examine the <tt>"cn=favorite"</tt> entry in the directory,
you will see the following attributes.
<blockquote><pre>
objectclass: top, javaContainer, javaObject, javaNamingReference
javaclassname: Fruit 
javafactory: FruitFactory
javareferenceaddress: #0#fruit#orange
cn: favorite
</pre></blockquote>
<p>
You can modify this example to use the colon character (":") as the
separator, as follows.
<blockquote><pre>
// Ask to use ":" as the encoding character
env.put("java.naming.ldap.ref.separator", ":");

// Create the initial context
DirContext ctx = new InitialDirContext(env);

// Create the object to be bound
Fruit fruit = new Fruit("orange");

// Perform the bind
ctx.rebind("cn=favorite", fruit);
</pre></blockquote>
The <a href=src/RefObj.java>modified program</a>
produces the following attributes.
<blockquote><pre>
objectclass: top, javaContainer, javaObject, javaNamingReference
javaclassname: Fruit
javafactory: FruitFactory
javareferenceaddress: :0:fruit:orange
cn: favorite
</pre></blockquote>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="rename.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="url.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/ldapHeader.gif" width=26 height=26 align=top border=0 alt="Tips for LDAP Users | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Miscellaneous</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
