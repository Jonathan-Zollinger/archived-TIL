










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Handling Special Characters</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="parse.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="compose.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Handling Special Characters
</h2>
<p>
<blockquote>

A naming convention, such as that for the LDAP or the file system,
typically has meta characters.
For example, in the LDAP,
if one of the following characters appears in the name, 
then it must
be preceded by the escape character, the backslash character
("\"):
<ul>
<li>A space or "#" character occurring at the beginning of the string
<li>A space character occurring at the end of the string
<li>One of the characters ",", "+", """, "\", "<", ">" or ";"
</ul>

When you are specifying a name to one of the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><tt>Context</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    methods, you not only must pay attention to the special characters
and naming convention of the underlying naming system.  You also
need to be concerned about the JNDI composite name syntax, which
also defines special characters.
The combination of the two syntaxes might lead to many levels of
escaping. 
<p>
For example, 
suppose that you have a <tt>"cn"</tt> attribute
whose value contains a backslash character. 
<blockquote><pre>
backslash\a
</pre></blockquote>
The LDAP requires that the backslash character in a name be escaped.
Therefore when you use this attribute as an LDAP name,
you must precede the backslash character in its value with another 
backslash character, as follows:
<blockquote><pre>
cn=backslash\\a
</pre></blockquote>
The backslash character is also a special character in
the JNDI, so if you supply this string name as a composite name, then you
must escape the backslashes, again by preceding each with a backslash character:
<blockquote><pre>
cn=backslash\\\\a
</pre></blockquote>
If you specify this as a literal in the Java programming language,
then you need to follow the Java language requirements and escape a backslash within a string literal with yet another backslash:
<blockquote><pre>
String cname = "cn=backslash\\\\\\\\a";
</pre></blockquote>
<p>
<h4>String Names As Composite Names</h4>

You need to keep in mind that the string names
that you pass to the <tt>Context</tt> methods are composite names.
To avoid any surprises if a
name contains special characters that might conflict
with the JNDI composite name syntax, you should use the 
<tt>Context</tt> methods that accept a 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html"><tt>Name</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
Two ways are available for doing this.
The first way is to use a 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompositeName.html"><tt>CompositeName</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompositeName.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>. You create a <tt>CompositeName</tt>
object and then append the naming system-specific name (such as an LDAP name) to it.
Here is <a href=src/CompositeWrap.java>an example</a>.
<blockquote><pre>
String dn = ...; // An LDAP distinguished name
Name composite = new CompositeName().add(dn);
Object obj = ctx.lookup(composite);
</pre></blockquote>
Applying this technique to the previous LDAP sample name, you
would no longer need to add escapes for the JNDI syntax manually
because that would be handled automatically by the <tt>CompositeName</tt> class.
<blockquote><pre>
Name composite = new CompositeName().add("cn=backslash\\\\a");
Object obj = ctx.lookup(composite);
</pre></blockquote>
<p>
The second way is to use a compound name.
You create a compound name by parsing the naming system-specific name
(such as an LDAP name).
Here is <a href=src/CompoundWrap.java>an example</a>.
<blockquote><pre>
String dn = ...; // An LDAP distinguished name
NameParser ldapParser = ctx.getNameParser("");
Name compound = ldapParser.parse(dn);
Object obj = ctx.lookup(compound);
</pre></blockquote>
Applying this technique to the previous LDAP sample name, you
would no longer need to add escapes for the JNDI syntax 
because you are not using JNDI composite names.
<blockquote><pre>
Name compound = ldapParser.parse("cn=backslash\\\\a");
Object obj = ctx.lookup(compound);
</pre></blockquote>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="parse.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="compose.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
