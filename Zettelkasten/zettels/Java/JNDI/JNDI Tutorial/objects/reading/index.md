










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Reading Objects from the Directory</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="../state/custom.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="lookup.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
     Reading Objects from the Directory
</h1>
<p>
<blockquote>

<p>
The
<a target="_top" href="../storing/index.html">Storing Objects in the Directory</a> <a href="../storing/index.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>     lesson discussed
different ways in which Java objects (or rather information
about Java objects) are stored in a directory.
Each of that lesson's examples demonstrated that
once the object is stored, you can simply use

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><tt>Context.lookup()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    to get a copy of the object back from the directory,
regardless of what type of information was actually stored.
<p>
This is made possible by object factories. 
A brief discussion of how object factories are used by
<tt>lookup()</tt> is included in the
<a href=lookup.html>Lookups section</a> of this lesson.
<p>
You can get the object back not only by using <tt>lookup()</tt>,
but also when you 
<a href=list.html>list</a> a context and
when you <a href=search.html>search</a> a context or its subtree.
In all of these cases, <em>object factories</em>
might be involved. 
This lesson describes also how these operations interact with object
factories.
Object factories are discussed in detail in the
<a target="_top" href="../factory/index.html">Object Factories</a> <a href="../factory/index.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>     lesson.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="../state/custom.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="lookup.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
