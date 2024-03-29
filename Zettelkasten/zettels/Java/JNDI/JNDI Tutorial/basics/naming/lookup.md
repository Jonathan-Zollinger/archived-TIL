










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Looking up an Object</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="index.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="list.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Looking up an Object
</h2>
<p>
<blockquote>

To look up an object from the naming service, use

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><tt>Context.lookup()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   and pass it the name of 
the object that you want to retrieve.
Suppose that there is an object in the naming service with
the name <tt>"report.txt"</tt>.
To retrieve the object, you would write
<blockquote>
<pre>
Object obj = ctx.lookup("report.txt");
</pre>
</blockquote>
<p>
The type of object that is returned by <tt>lookup()</tt>
depends both on the underlying naming system and on
the data associated with the object itself.
A naming system can contain many different types of objects,
and a lookup of an object in different parts of the system might
yield objects of different types.
In this example, <tt>"report.txt"</tt> happens to be 
bound to a file (<tt>java.io.File</tt>).
You can cast the result of <tt>lookup()</tt> to its target class.
<p>
For example, the following code looks up the object 
<tt>"report.txt"</tt>
and casts it to <tt>File</tt>.
<blockquote>
<pre>
import java.io.File;
...
File f = (File)ctx.lookup("report.txt");
</pre>
</blockquote>

<p>
The complete example is in the file 
<tt><a href=src/Lookup.java>Lookup.java</a>.


</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="index.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="list.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
