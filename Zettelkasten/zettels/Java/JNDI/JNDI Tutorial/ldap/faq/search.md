










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Searches</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="attr.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="name.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/ldapHeader.gif" width=26 height=26 align=bottom border=0 alt="Tips for LDAP Users | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Frequently Asked Questions</em></strong></a>
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
    Searches
</h2>
<p>
<blockquote>

<h4>Why does putting an "*" as an attribute value not work as expected
in my search?</h4>

When you use the following
form of <tt>search()</tt>, the attribute values are treated as literals; that is, the
attribute in the directory entry is expected to contain exactly that value:

<blockquote>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, javax.naming.directory.Attributes)"><tt>search(Name name, Attributes matchingAttrs)</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a></blockquote>

To use wildcards, you should use the string filter forms of
<tt>search()</tt>, as follows.
<blockquote>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, java.lang.String, javax.naming.directory.SearchControls)"><tt>search(Name name, String filter, SearchControls ctls)</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, java.lang.String, javax.naming.directory.SearchControls)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><br>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, java.lang.String, java.lang.Object[], javax.naming.directory.SearchControls)"><tt>search(Name name, String filterExpr, Object[]filterArgs, SearchControls ctls)</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, java.lang.String, java.lang.Object[], javax.naming.directory.SearchControls)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a></blockquote>
For the last form, the wildcard characters must appear in the <tt>filterExpr</tt>
argument, and not in <tt>filterArgs</tt>.
The values in <tt>filterArgs</tt> are also treated as literals.

<h4>Why don't wildcards in search filters always work?</h4>

A wildcard that appears before or after the attribute value (such as
in <tt>"attr=*I*"</tt>) indicates that the server is to search for matching
attribute values by using the attribute's substring matching rule.  If
the attribute's definition does not have a substring matching rule,
then the server cannot find the attribute.  You'll have to search
by using an equality or "present" filter instead.

<h4>Why do I get back only <em>n</em> number of entries when I know
there are more in the directory?</h4>

Some servers are configured to limit the number
of entries that can be returned. Others also limit the number
of entries that can be examined during a search.
Check your server configuration.

<h4>How do I pass controls with my search?</h4>

See the
<a target="_top" href="../ext/context.html">Controls and Extensions</a> <a href="../ext/context.html"><img src="../../jndiimages/ldapIcon.gif" width=20 height=20 border=0 alt="(in the Tips for LDAP Users trail)"></a>   lesson for details.

<h4>How do I find out how many search results I got back?</h4>

You must keep count as you enumerate 
through the results. The LDAP does not provide this information.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="attr.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="name.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/ldapHeader.gif" width=26 height=26 align=top border=0 alt="Tips for LDAP Users | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Frequently Asked Questions</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
