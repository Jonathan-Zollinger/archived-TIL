










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Creating and Destroying a Context</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="rename.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="../directory/index.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Creating and Destroying a Context
</h2>
<p>
<blockquote>

The <tt>Context</tt> interface contains methods for 
<a href=#CREATE>creating</a> and <a href=#DESTROY>destroying</a>
a <em><a href=../../getStarted/concepts/glossary.html#SUBCONTEXT>subcontext</a></em>,
a context that is bound in another context of the
same type.
In a file system, this corresponds to
creating and removing a subdirectory.

<p>

<h4><a name=CREATE>Creating a Context</a></h4>

To create a context, you supply to
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#createSubcontext(javax.naming.Name)"><tt>createSubcontext()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#createSubcontext(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    the name of the context that you want to create.
<blockquote>
<pre>
// Create the context
Context result = ctx.createSubcontext("new");
</pre>
</blockquote>

<a href=src/Create.java>This example</a> creates a new context, called <tt>"new"</tt>,
that is a child of <tt>ctx</tt>.
If you list the context <tt>ctx</tt>, you will see that there is now an
entry for <tt>"new"</tt>.


<h4><a name=DESTROY>Destroying a Context</a></h4>

To destroy a context, you supply to
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#destroySubcontext(javax.naming.Name)"><tt>destroySubcontext()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#destroySubcontext(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    the name of the context to destroy.

<blockquote>
<pre>
// Destroy the context
ctx.destroySubcontext("new");
</pre>
</blockquote>

<a href=src/Destroy.java>This example</a> destroys the context 
<tt>"new"</tt>
in the context <tt>ctx</tt>.

<P ALIGN="CENTER">
<IMG SRC="../../jndiimages/shoeline2.GIF" ALIGN="BOTTOM" BORDER="0" WIDTH="202"
    HEIGHT="25" NATURALSIZEFLAG="3">
<IMG SRC="../../jndiimages/shoeline2.GIF" ALIGN="BOTTOM" BORDER="0" WIDTH="202"
    HEIGHT="25" NATURALSIZEFLAG="3">
</P>
<strong>Naming Operations: End of Lesson</strong>
<p>
What's next? 
Now you can:
<ul>
<li> <a href=../directory/index.html>Continue</a> on in this trail
to learn how to perform directory operations using the JNDI.
<li> Go to the 
<a target="_top" href="../../objects/index.html">Java Objects and the Directory</a> <a href="../../objects/index.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>     trail to learn how to store and retrieve objects in the directory.
</ul>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="rename.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="../directory/index.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
