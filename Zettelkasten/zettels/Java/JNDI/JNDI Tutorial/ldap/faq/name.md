










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Names</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="search.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="../end.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Names
</h2>
<p>
<blockquote>

<h4>Why do I get an empty string as a name in my
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchResult.html"><tt>SearchResult</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchResult.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>?</h4>

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#getName()"><tt>getName()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameClassPair.html#getName()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    always returns a name <em>relative</em> to the <em>target context</em>
of the search.
So, if the target context satisfies the search filter,
then the name returned will be "" (the empty name) because that is
the name relative to the target context.
See the
<a target="_top" href="../search/result.html">Searches</a> <a href="../search/result.html"><img src="../../jndiimages/ldapIcon.gif" width=20 height=20 border=0 alt="(in the Tips for LDAP Users trail)"></a>     lesson for details.

<h4>Why do I get a URL string as a name in my
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchResult.html"><tt>SearchResult</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchResult.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>?</h4>
The LDAP entry was retrieved by following either an alias or
a referral, so its name is a URL.
See the
<a target="_top" href="../search/result.html">Searches</a> <a href="../search/result.html"><img src="../../jndiimages/ldapIcon.gif" width=20 height=20 border=0 alt="(in the Tips for LDAP Users trail)"></a>     lesson for details.

<h4>Is the 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html"><tt>Name</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     argument to the 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><tt>Context</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    and
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html"><tt>DirContext</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    methods a 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompoundName.html"><tt>CompoundName</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompoundName.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>  or a
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompositeName.html"><tt>CompositeName</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompositeName.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>?</h4>

The string forms accept the string representation of a composite name.
That is, using a string name is equivalent to calling
<tt>new CompositeName(stringName)</tt> and passing the results
to the <tt>Context</tt>/<tt>DirContext</tt> method.
The <tt>Name</tt> argument can be any object that implements the
<tt>Name</tt> interface.
If it is an instance of <tt>CompositeName</tt>,
then the name is treated as a composite name; otherwise, it is treated
as a compound name.

<h4>Can I pass the name I got back from
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameParser.html"><tt>NameParser</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameParser.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    to
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><tt>Context</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     methods?</h4>

This is related to the previous question.
Yes, you can. 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameParser.html#parse(java.lang.String)"><tt>NameParser.parse()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NameParser.html#parse(java.lang.String)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    returns a compound name that implements the <tt>Name</tt> interface.
This name can be passed to the <tt>Context</tt> methods, which will
interpret it as a compound name.

<h4>What's the relationship between the name I use for the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#SECURITY_PRINCIPAL"><tt>Context.SECURITY_PRINCIPAL</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#SECURITY_PRINCIPAL"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     property and the directory?</h4>

You can think of the principal name
as coming from a different namespace than the directory.
See 
<a href="http://www.ietf.org/rfc/rfc2829.txt">RFC 2829</a>
and the
<a target="_top" href="../security/index.html">Security</a> <a href="../security/index.html"><img src="../../jndiimages/ldapIcon.gif" width=20 height=20 border=0 alt="(in the Tips for LDAP Users trail)"></a>     lesson for details on LDAP authentication mechanisms.
Sun's LDAP service provider accepts a string principal name, which
it passes directly to the LDAP server. 
Some LDAP servers accept DNs, whereas
others support the schemes proposed by 
<a href="http://www.ietf.org/rfc/rfc2829.txt">RFC 2829</a>.

<h4>Why are there strange quotation marks and escapes in the names
that I read from the directory?</h4>

Sun's LDAP name parser is conservative with respect to quoting 
rules,
but it nevertheless produces "correct" names.
Also, remember that the names of entries returned by
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingEnumeration.html"><tt>NamingEnumeration</tt>s</a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingEnumeration.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     are
<a href=../../getStarted/concepts/glossary.html#COMPOSITENAME><em>composite names</em></a>
that can be passed back to the <tt>Context</tt> and <tt>DirContext</tt>
methods. So, if the name contains a character that conflicts with
the composite name syntax (such as the forward slash character "/"),
then the LDAP provider will provide an encoding to ensure that the
slash character will be treated as part of the LDAP name rather than as a composite
name separator.

<h4>How do I get an LDAP entry's full DN?</h4>

You can use 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#getNameInNamespace()"><tt>Context.getNameInNamespace()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#getNameInNamespace()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="search.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="../end.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
