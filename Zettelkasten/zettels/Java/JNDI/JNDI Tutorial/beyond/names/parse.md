










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Name Parsers</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="compound.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="syntax.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Name Parsers
</h2>
<p>
<blockquote>

To parse a name means to use its string representation
(<tt>java.lang.String</tt>)
to obtain its structural representation (
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html><tt>Name</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>).
The JNDI provides a name parser for composite names
and a generic interface for compound name parsers.
Service providers provide the actual implementations of name parsers for
compound names exported by their namespaces.

<h4>Parsing Composite Names</h4>

To parse a composite name, you pass its string representation
to the 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompositeName.html#CompositeName(java.lang.String)"><tt>CompositeName</tt> constructor</a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompositeName.html#CompositeName(java.lang.String)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
For example, the <a href=src/LookupCompositeName.java>following code</a>
parses a string name into a structured name, <tt>CompositeName</tt>.
<blockquote><pre>
// Parse the string name into a CompositeName
Name cname = new CompositeName(
    "cn=homedir,cn=Jon Ruiz,ou=people/tutorial/report.txt");
</blockquote></pre>

See the <a href=composite.html#ACCESS>Composite Names section</a>
for examples of how to access and change the components of a
<tt>CompositeName</tt>.

<h4>Parsing Compound Names</h4>

To parse a compound name, you use the
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameParser.html><tt>NameParser</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameParser.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   interface. This interface contains a single method:
<blockquote>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameParser.html#parse(java.lang.String)"><tt>Name parse(String name) throws InvalidNameException;</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameParser.html#parse(java.lang.String)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a></blockquote>
<p>
First, however, you must obtain a <tt>NameParser</tt>
from the service provider that supports the namespace.
Here is <a href=src/GetNameParser.java>an example</a> that
obtains name parsers for the LDAP namespace and file namespace.
<blockquote><pre>
// Create the initial context
Context ctx = new InitialContext();

// Get the parser for LDAP
NameParser ldapParser = 
    ctx.getNameParser("ldap://localhost:389/o=jnditutorial");

// Get the parser for filenames
NameParser fsParser = ctx.getNameParser("file:/");
</pre></blockquote>
See the <a href=compound.html#ACCESS>Compound Names section</a> for more
examples of how to get a <tt>NameParser</tt> instance.
<p>
Once you have an instance of a <tt>NameParser</tt>, you can use
its <tt>parse()</tt> method to parse compound names. 
As a continuation of
the example, you can use <tt>ldapParser</tt> to parse
an LDAP string name into its structural form, as follows.
<blockquote><pre>
// Parse the name using the LDAP parser
Name compoundName = ldapParser.parse("cn=John Smith, ou=People, o=JNDITutorial");
</blockquote></pre>
Similarly, you can use <tt>fsParser</tt> to parse a filename,
as follows.
<blockquote><pre>
// Parse the name using the LDAP parser
Name compoundName = fsParser.parse("tmp/tutorial/beyond/names/parse.html");
</blockquote></pre>
<p>
Note that each parser determines the syntax of names that it will accept.
If you supply a valid filename that is not a legal LDAP name to an
LDAP parser, then you will get an
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InvalidNameException.html"><tt>InvalidNameException</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InvalidNameException.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
<p>
See the <a href=compound.html#ACCESS>Compound Names section</a>
for examples of how to access and change the components of a
compound name.
<p>
Although <tt>parse()</tt> returns a <tt>Name</tt>,
<tt>NameParser</tt> is intended to be used only for compound names and not composite names.
The object returned by <tt>parse()</tt> might or might not be an instance of
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompoundName.html"><tt>CompoundName</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompoundName.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.  The only requirement is that it implements the <tt>Name</tt>
interface. The exact type of the object returned depends on
the service provider implementation.
 
</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="compound.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="syntax.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
