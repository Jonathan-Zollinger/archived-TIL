










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Dereferencing Aliases</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="attrs.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="rename.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Dereferencing Aliases
</h2>
<p>
<blockquote>

In the X.500, you can set a leaf entry to point to another object in
the namespace. 
Called an
<a href=../../getStarted/concepts/glossary.html#ALIAS><em>alias</em></a>
entry, it contains the DN of the object to which it is
pointing.  When you look up an object by using the alias, the alias is
<em>dereferenced</em> so that what is returned is the object
pointed to by the alias's DN.  

<p>
You can use aliases to organize the directory's namespace
so that as the namespace evolves,
old names may be used.
Suppose, for example, that in the <tt>"o=Wiz, c=us"</tt> company,
the departments <tt>"ou=hardware"</tt> and <tt>"ou=software"</tt>
are merged
into <tt>"ou=engineering"</tt>.
You can move the
contents of <tt>"ou=hardware"</tt> and <tt>"ou=software"</tt> to
<tt>"ou=engineering"</tt>, and change the entries 
<tt>"ou=hardware"</tt> and
<tt>"ou=software"</tt> into alias entries that point to 
<tt>"ou=engineering"</tt>.  

<p>
In the LDAP, aliases are supported in the same way as in the X.500.
<P>
When you use Sun's LDAP service provider, you can control how 
aliases are dereferenced in one of four ways, by using the
<tt>"java.naming.ldap.derefAliases"</tt> environment property,
as shown in the following table.
If this environment property is not set, 
then the default is <tt>"always"</tt>.
<p>
<TABLE BORDER CELLPADDING=3>
<tr>
<th>
Property Setting
</th>
<th>
Description
</th>
</tr>

<tr>
<td>
<tt>always</tt>
<td>
Always dereference aliases.
</td>
</tr>

<tr>
<td>
<tt>never</tt>
</td>
<td>Never dereferences aliases.
</td>
</tr>

<tr>
<td><tt>finding</tt></td>
<td>Dereferences aliases only <em>during</em> name resolution.</td>
</tr>

<tr>
<td>
<tt>searching</tt>
</td>
<td>
Dereferences aliases only <em>after</em> name resolution.
</td>
</tr>
</table>
<p>
In the LDAP, these four modes of alias dereferencing affect only
the "search" operations. No dereferencing is done for
the update operations "modify," "add," and "delete."
<p>
Similarly, in the JNDI, no dereferencing is done for
the update methods in the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><tt>Context</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    and
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html"><tt>DirContext</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    interfaces.
The <tt>"java.naming.ldap.derefAliases"</tt>
environment property affects all methods that read from the directory.
<p>
Note also that the "dereference links" flag in the 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html"><tt>SearchControls</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   class is not related to aliases.

<h4>Dereferencing Aliases Example</h4>

<a href=src/SearchWithAlias.java>The following example</a> demonstrates how the
<tt>"java.naming.ldap.derefAliases"</tt>
environment property affects the "search" operation.
It accepts as a command-line argument one of the four settings
for <tt>"java.naming.ldap.derefAliases"</tt>. If no argument has been specified,
then the environment property is not set (which is equivalent to
setting it to <tt>"always"</tt>).
<p>
<img src=../../jndiimages/alias.jpeg alt="Alias Picture" align=right>
For this example, the directory has been set up with two aliases,
as follows.
<ul>
<li><tt>"ou=Staff"</tt> is an alias that points to 
<tt>"ou=People"</tt>. If you list the context
of <tt>"ou=Staff"</tt>, then you will see the contents of the 
<tt>"ou=People"</tt> context.
<li><tt>"cn=Newbie, ou=People"</tt> is an alias that points to the
<tt>"cn=J. Duke, ou=NewHires"</tt> entry.
</ul>
<p>
After setting the environment property, the example performs a search
on the <tt>"ou=Staff"</tt> context for all entries whose 
<tt>"cn"</tt> attribute begins
with "J."
Here's the code fragment that sets the environment property
and performs the search.
<blockquote><pre>
if (args.length &gt; 0) {
    // Set the dereference flag as requested
    env.put("java.naming.ldap.derefAliases", args[0]);
}

// Create the initial context
DirContext ctx = new InitialDirContext(env);

// Perform the search
NamingEnumeration answer = ctx.search("ou=Staff", "(cn=J*)", null);
</pre></blockquote>
The following table summarizes
the results of running this program with different
arguments to the command line.
<p>
<TABLE BORDER CELLPADDING=3>
<tr>
<th>
Command Line Argument
</th>
<th>
Results
</th>
</tr>

<tr>
<td>
(<em>none</em>)
</td>
<td>
Three entries: <tt>"cn=Jon Ruiz"</tt>, 
<tt>"cn=John Fowler"</tt>, <tt>"cn=J.Duke"</tt>
</td>
</tr>
<tr>
<td>
<tt>always</tt>
</td>
<td>
Three entries: 
<tt>"cn=Jon Ruiz"</tt>, <tt>"cn=John Fowler"</tt>, 
<tt>"cn=J.Duke"</tt>
</td>
</tr>
<tr>
<td>
<tt>never</tt>
</td>
<td>
Zero (because the <tt>"ou=Staff"</tt> alias is never dereferenced)
</td>
</tr>
<tr>
<td>
<tt>finding</tt>
</td>
<td>
Two entries: <tt>"cn=Jon Ruiz"</tt> and <tt>"cn=John Fowler"</tt> (because the <tt>"cn=Newbie"</tt> alias is never dereferenced)
</td>
</tr>
<tr>
<td>
<tt>searching</tt>
</td>
<td>
Zero (because the <tt>"ou=Staff"</tt> alias is never dereferenced)
</td>
</tr>
</table>

<blockquote>
<hr>
<strong>Note:</strong>
The <a href="http://www.sun.com/">SunONE Directory Server v5.1</a>
does not support aliases. If you run this example using that server,
then the results will be as if the setting is <tt>"never"</tt>.
<hr>
</blockquote>

<p>
When you run these examples, the names of the entries (
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#getName()"><tt>NameClassPair.getName()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#getName()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>) that you get back are
LDAP URLs containing the fully qualified names of the entries.
If you invoke
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#isRelative()"><tt>NameClassPair.isRelative()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#isRelative()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     on them, then the method returns <tt>false</tt>.
This is because when the alias is followed, it reaches another part of the
namespace that is no longer named relative to the <tt>"ou=Staff"</tt> context.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="attrs.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="rename.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
