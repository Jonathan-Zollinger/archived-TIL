










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>String Names versus Structured Names</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="index.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="composite.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/beyondHeader.gif" width=26 height=26 align=bottom border=0 alt="Beyond the Basics | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>What's in a Name?</em></strong></a>
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
    String Names versus Structured Names
</h2>
<p>
<blockquote>

Each naming method in the 

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><tt>Context</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    and
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html"><tt>DirContext</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    interfaces has two overloaded forms: one that
accepts a string name (<tt>java.lang.String</tt>) and one that accepts
a structured name (
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html"><tt>Name</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>).
For example, <tt>lookup()</tt> has two forms:
<blockquote><pre>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(java.lang.String)"><tt>lookup(java.lang.String)</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(java.lang.String)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><tt>lookup(javax.naming.Name)</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#lookup(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a></pre></blockquote>

<h4>String Names</h4>
The overloads that accept a <tt>java.lang.String</tt> name are convenience forms 
that allow the methods to be invoked without the caller's having to construct a
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompositeName.html"><tt>CompositeName</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompositeName.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>
instance. 
The <tt>java.lang.String</tt> name argument passed to these overloads represents a
<a href=../../getStarted/concepts/glossary.html#COMPOSITENAME>
<em>composite name</em></a> and follows the syntactic rules specified in the
<tt>CompositeName</tt> class. 
<p>
For example, the following two invocations of <tt>lookup()</tt> are equivalent.

<blockquote><pre>
Object obj1 = ctx.lookup("cn=Ted Geisel, ou=People, o=JNDITutorial");

CompositeName cname = new CompositeName(
    "cn=Ted Geisel, ou=People, o=JNDITutorial");
Object obj2 = ctx.lookup(cname);
</pre></blockquote>

<h4>Structured Names</h4>

The overloads that accept a <tt>Name</tt> accept an instance of
<tt>CompositeName</tt>,
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompoundName.html"><tt>CompoundName</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompoundName.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>, or any other class that implements the <tt>Name</tt> interface.
<p>
If the object is an instance of <tt>CompositeName</tt>, then it is treated as
a composite name.
A composite name is a name that can span multiple naming systems, not just the
naming system on which the method is invoked.
See the
<a href=composite.html>Composite Names</a> section of this lesson
for examples of how to use composite names.
In the degenerate case, the name spans only the naming system
on which the method is invoked. In the

<a target="_top" href="../../ldap/index.html">Tips for LDAP Users</a> <a href="../../ldap/index.html"><img src="../../jndiimages/ldapIcon.gif" width=20 height=20 border=0 alt="(in the Tips for LDAP Users trail)"></a>   trail, for instance, all of the examples use string names
from the LDAP <a href=../../getStarted/concepts/glossary.html#NAMESPACE>namespace</a>.
Note that even in this degenerate case, the name is still a composite name; that is,
it is a composite name having a single component.
<p>
If the object is not an instance of <tt>CompositeName</tt>, 
then it is treated
as a compound name--a name that spans only one namespace.
See the
<a href=compound.html>Compound Names</a> section of this lesson
for examples of how to use compound names.


<h4>When to Use Which</h4>
Typically, your program would use a string name if it was supplied a
string name by the user. It would use a <tt>Name</tt> instance if it
was composing the name by using input from the user. For example, in a
namespace browser application, as the user traverses different parts
of the namespace, the application might need to compose names that
direct the browser toward those parts of the namespace.  It could do
so by creating string representations of the names for those parts of
the namespace and by being cognizant of and using the appropriate naming
syntax(es). Or, it could use <tt>Name</tt> instances created with the
help of utilities provided by the JNDI.
<p>
See <a href=syntax.html>Handling Special Characters section</a> of this lesson about
how best to accommodate special characters in a name that
conflicts with the JNDI composite name syntax.



</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="index.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="composite.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/beyondHeader.gif" width=26 height=26 align=top border=0 alt="Beyond the Basics | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>What's in a Name?</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
