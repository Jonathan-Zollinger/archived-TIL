










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Naming Operations</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="../prepare/names.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="lookup.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/basicsHeader.gif" width=26 height=26 align=bottom border=0 alt="The Basics | "></a>
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
     Naming Operations
</h1>
<p>
<blockquote>

You can use the JNDI to perform naming operations, including
read operations and operations
for updating the namespace.
The following operations are described in this lesson:
<ul>
<li><a href=lookup.html>Looking up an object</a>
<li><a href=list.html>Listing the contents of a context</a> 
<li><a href=bind.html>Adding, overwriting, and removing a binding</a>
<li><a href=rename.html>Renaming an object</a>
<li><a href=create.html>Creating and destroying subcontexts</a>
</ul>

<p>

<h4>Configuration</h4>
The examples in this lesson use the file system service
provider. They assume that you have set up a sample
file namespace using the 
<a href=../../config/fs/Setup.java>configuration program (<tt>Setup</tt>)</a> that
accompanies this trail.
See the

<a target="_top" href="../prepare/content.html">Preparations</a> <a href="../prepare/content.html"><img src="../../jndiimages/basicsIcon.gif" width=20 height=20 border=0 alt="(in the Basics trail)"></a>     lesson for instructions on running this program.
If you use another service provider or choose to
use another part of the file namespace, then the behavior
will differ from what is shown here.

<p>
The initial context used in these examples is initialized
using the following environment properties.
<blockquote>
<pre>
// Set up environment for creating the initial context
Hashtable env = new Hashtable();
env.put(Context.INITIAL_CONTEXT_FACTORY, 
    "com.sun.jndi.fscontext.RefFSContextFactory");
env.put(Context.PROVIDER_URL, "file:/tmp/tutorial");
Context ctx = new InitialContext(env);
</pre>
</blockquote>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="../prepare/names.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="lookup.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/basicsHeader.gif" width=26 height=26 align=top border=0 alt="The Basics | "></a>
</td>
<td align=right>
<a href="../TOC.html"><strong><em>Contents</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
