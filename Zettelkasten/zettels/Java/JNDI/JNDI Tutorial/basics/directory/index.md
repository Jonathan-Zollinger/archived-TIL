










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Directory Operations</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="../naming/create.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="attrnames.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
     Directory Operations
</h1>
<p>
<blockquote>

You can use the JNDI to perform directory operations,
including the following:
<ul>
<li><a href=getattrs.html>Reading an object's attributes</a> 
<li><a href=modattrs.html>Modifying an object's attributes</a> 
<li><a href=search.html>Searching the directory</a>
<li><a href=hybrid.html>Performing hybrid naming and directory operations</a>
</ul>

This lesson describes each of these operations.
Before using any of them, you should read 
<a href=attrnames.html>the section</a>
on the use of attribute names that apply to all
of these operations.

<p>

<h4>Configuration</h4>
<a name=config></a>
The examples in this lesson use the LDAP service
provider. They assume that you have set up a sample
namespace using the content described in the
<a target="_top" href="../prepare/content.html">Preparations</a> <a href="../prepare/content.html"><img src="../../jndiimages/basicsIcon.gif" width=20 height=20 border=0 alt="(in the Basics trail)"></a>     lesson.
If you use another service provider or choose to
use another part of the LDAP namespace, then the behavior
will differ from what is shown here.

<p>
The initial context used in these examples is initialized
using the following environment properties.
<blockquote>
<pre>
// Set up the environment for creating the initial context
Hashtable env = new Hashtable();
env.put(Context.INITIAL_CONTEXT_FACTORY, 
    "com.sun.jndi.ldap.LdapCtxFactory");
env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");
DirContext ctx = new InitialDirContext(env);
</pre>
</blockquote>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="../naming/create.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="attrnames.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
