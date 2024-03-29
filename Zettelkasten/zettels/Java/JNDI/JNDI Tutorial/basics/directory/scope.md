










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Search Scope</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="controls.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="countlimit.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/basicsHeader.gif" width=26 height=26 align=bottom border=0 alt="The Basics | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Directory Operations</em></strong></a>
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
    Search Scope
</h2>
<p>
<blockquote>

The default 

<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html><tt>SearchControls</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     specifies that the search is to be performed in the named context

(
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#ONELEVEL_SCOPE><tt>SearchControls.ONELEVEL_SCOPE</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#ONELEVEL_SCOPE><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>).
This default is used in the examples in the 
<a href=filter.html>Search Filters section</a>.
<p>
In addition to this default, you can specify that
the search be performed in the <em>entire subtree</em> or
only in the named object.

<h4><a name=SCOPE>Search the Subtree</a></h4>

A search of the entire subtree searches the named object
and all of its descendants.
To make the search behave in this way, pass
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#SUBTREE_SCOPE><tt>SearchControls.SUBTREE_SCOPE</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#SUBTREE_SCOPE><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     to
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#setSearchScope(int)"><tt>SearchControls.setSearchScope()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#setSearchScope(int)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     as follows.
<p>
<blockquote>
<pre>
// Specify the ids of the attributes to return
String[] attrIDs = {"sn", "telephonenumber", "golfhandicap", "mail"};
SearchControls ctls = new SearchControls();
ctls.setReturningAttributes(attrIDs);
ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);

// Specify the search filter to match
// Ask for objects that have the attribute "sn" == "Geisel"
// and the "mail" attribute
String filter = "(&amp;(sn=Geisel)(mail=*))";

// Search the subtree for objects by using the filter
NamingEnumeration answer = ctx.search("", filter, ctls);
</pre>
</blockquote>
<a href=src/SearchSubtree.java>This example</a>
searches the context <tt>ctx</tt>'s subtree
for entries that satisfy the specified filter.
It finds the entry <tt>"cn= Ted Geisel, ou=People"</tt> in this subtree
that satisfies the filter.
<blockquote>
<pre>
# java SearchSubtree
&gt;&gt;&gt;cn=Ted Geisel, ou=People
attribute: sn
value: Geisel
attribute: mail
value: Ted.Geisel@JNDITutorial.com
attribute: telephonenumber
value: +1 408 555 5252
</pre>
</blockquote>

<h4>Search the Named Object</h4>
<p>
You can also search the named object.
This is useful, for example, to test whether the named
object satisfies a search filter.
To search the named object, pass 

<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#OBJECT_SCOPE><tt>SearchControls.OBJECT_SCOPE</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#OBJECT_SCOPE><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     to <tt>setSearchScope()</tt>.
<blockquote>
<pre>
// Specify the ids of the attributes to return
String[] attrIDs = {"sn", "telephonenumber", "golfhandicap", "mail"};
SearchControls ctls = new SearchControls();
ctls.setReturningAttributes(attrIDs);
ctls.setSearchScope(SearchControls.OBJECT_SCOPE);

// Specify the search filter to match
// Ask for objects that have the attribute "sn" == "Geisel"
// and the "mail" attribute
String filter = "(&amp;(sn=Geisel)(mail=*))";

// Search the subtree for objects by using the filter
NamingEnumeration answer = 
    ctx.search("cn=Ted Geisel, ou=People", filter, ctls);
</pre>
</blockquote>
<a href=src/SearchObject.java>This example</a> 
tests whether the object <tt>"cn=Ted Geisel, ou=People"</tt> satisfies
the given filter.
<blockquote>
<pre>
# java SearchObject
&gt;&gt;&gt;
attribute: sn
value: Geisel
attribute: mail
value: Ted.Geisel@JNDITutorial.com
attribute: telephonenumber
value: +1 408 555 5252
</pre>
</blockquote>
The example found one answer and printed it. Notice that the name of the
result is the empty string.
This is because the name of the object
is always named relative to the context of the search 
(in this case, <tt>"cn=Ted Geisel, ou=People"</tt>).

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="controls.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="countlimit.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/basicsHeader.gif" width=26 height=26 align=top border=0 alt="The Basics | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Directory Operations</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
