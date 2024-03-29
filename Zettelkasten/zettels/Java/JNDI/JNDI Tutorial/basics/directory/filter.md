










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Search Filters</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="basicsearch.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="controls.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Search Filters
</h2>
<p>
<blockquote>

In addition to specifying a search using a set of attributes, you can
specify a search in the form of a 
<em><a href=../../getStarted/concepts/glossary.html#FILTER>search filter</a></em>.
A search filter is a search query expressed in the form
of a logical expression.
The syntax of search filters accepted by
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, java.lang.String, javax.naming.directory.SearchControls)"><tt>DirContext.search()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, java.lang.String, javax.naming.directory.SearchControls)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>      is described in
<a href=http://www.ietf.org/rfc/rfc2254.txt>RFC 2254</a>.
<p>
The following search filter specifies that the qualifying entries must have
an <tt>"sn"</tt> attribute with a value of <tt>"Geisel"</tt>
and a <tt>"mail"</tt> attribute with any value:
<blockquote>
<pre>
(&amp;(sn=Geisel)(mail=*))
</pre>
</blockquote>
<p>
The following code creates a filter and default 
<a href=controls.html>search controls</a>,
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html><tt>SearchControls</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>, and uses them to perform a search.
The search is equivalent to the one presented in the 
<a href=basicsearch.html>basic search</a> example.
<blockquote>
<pre>
// Create the default search controls
SearchControls ctls = new SearchControls();

// Specify the search filter to match
// Ask for objects that have the attribute "sn" == "Geisel"
// and the "mail" attribute
String filter = "(&amp;(sn=Geisel)(mail=*))";

// Search for objects using the filter
NamingEnumeration answer = ctx.search("ou=People", filter, ctls);
</pre>
</blockquote>
Running <a href=src/SearchWithFilterRetAll.java>this example</a>
produces the following result.

<blockquote>
<pre>
# java SearchWithFilterRetAll
&gt;&gt;&gt;cn=Ted Geisel
attribute: sn
value: Geisel
attribute: objectclass
value: top
value: person
value: organizationalPerson
value: inetOrgPerson
attribute: jpegphoto
value: [B@1dacd75e
attribute: mail
value: Ted.Geisel@JNDITutorial.com
attribute: facsimiletelephonenumber
value: +1 408 555 2329
attribute: cn
value: Ted Geisel
attribute: telephonenumber
value: +1 408 555 5252
</pre>
</blockquote>
<h4>Quick Overview of Search Filter Syntax</h4>

The search filter syntax is basically a logical expression
in prefix notation (that is, the logical operator appears before its
arguments).
The following table lists the symbols used for creating filters.
<p>
<table border="1" cellpadding=3 width="85%">
<tr>
<th width="30%">Symbol</th>
<th>Description</th>
</tr>

<tr>
<td>
&amp; 
</td>
<td>
conjunction (i.e., <em>and</em> -- all in list must be true)
</td>
</tr>

<tr>
<td>
| 
</td>
<td>
disjunction (i.e., <em>or</em> -- one or more alternatives must be true)
</td>
</tr>

<tr>
<td>
! 
</td>
<td>
negation (i.e., <em>not</em> -- the item being negated must not be true)
</td>
</tr>

<tr>
<td>
= 
</td>
<td>
equality (according to the matching rule of the attribute)
</td>
</tr>

<tr>
<td>
~= 
</td>
<td>
approximate equality (according to the matching rule of the attribute)
</td>
</tr>

<tr>
<td>
&gt;=
</td>
<td>
greater than (according to the matching rule of the attribute)
</td>
</tr>

<tr>
<td>
&lt;=
</td>
<td>
less than (according to the matching rule of the attribute)
</td>
</tr>

<tr>
<td>
=*
</td>
<td>
presence (i.e., the entry must have the attribute but its value is irrelevant)
</td>
</tr>

<tr>
<td>
*
</td>
<td>
wildcard (indicates zero or more characters can occur in that position); used when specifying attribute values to match
</td>
</tr>

<tr>
<td>
\
</td>
<td>
escape (for escaping '*', '(', or ')' when they occur inside an attribute value)
</td>
</tr>


</table>

<p>
Each item in the filter is composed
using an attribute identifier and either
an attribute value or symbols
denoting the attribute value.
For example, the item <tt>"sn=Geisel"</tt> means that the 
<tt>"sn"</tt> attribute
must have the attribute value <tt>"Geisel"</tt> 
and the item <tt>"mail=*"</tt>
indicates that the <tt>"mail"</tt> attribute must be present.
<p>
Each item must be enclosed within a set of parentheses, as in 
<tt>"(sn=Geisel)"</tt>.
These items are composed using logical operators 
such as "&amp;" (conjunction) to create logical expressions,
as in <tt>"(&amp; (sn=Geisel) (mail=*))"</tt>.
<p>
Each logical expression can be further composed of other
items that themselves are logical expressions,
as in <tt>"(| (&amp; (sn=Geisel) (mail=*)) (sn=L*))"</tt>.
This last example is requesting either entries that have both
a <tt>"sn"</tt> attribute of <tt>"Geisel"</tt> and the 
<tt>"mail"</tt> attribute or entries
whose <tt>"sn"</tt> attribute begins with the letter "L."

<p>
For a complete description of the syntax, see 
<a href=http://www.ietf.org/rfc/rfc2254.txt>RFC 2254</a>.



<h4><a name=SELECT>Returning Selected Attributes</a></h4>

The previous example returned all attributes associated with
the entries that satisfy the specified filter. You can select
the attributes to return by setting the search controls argument.
You create an array of attribute identifiers that you want to include in
the result and pass it to 


<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#setReturningAttributes(java.lang.String[])"><tt>SearchControls.setReturningAttributes()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#setReturningAttributes(java.lang.String[])"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
(Search controls are discussed further in the 
<a href=controls.html>next section</a>.)
Here's an example.
<blockquote>
<pre>
// Specify the ids of the attributes to return
String[] attrIDs = {"sn", "telephonenumber", "golfhandicap", "mail"};
SearchControls ctls = new SearchControls();
ctls.setReturningAttributes(attrIDs);
</pre>
</blockquote>

This example is equivalent to the 
<a href=basicsearch.html#SELECT>Returning Selected Attributes</a>
example in the Basic Search section.  Running 
<a href=src/SearchWithFilter.java>it</a> produces the following
results.  
(The entry does not have a <tt>"golfhandicap"</tt> attribute, so
it is not returned.)

<blockquote>
<pre>
# java SearchWithFilter
&gt;&gt;&gt;cn=Ted Geisel
attribute: sn
value: Geisel
attribute: mail
value: Ted.Geisel@JNDITutorial.com
attribute: telephonenumber
value: +1 408 555 5252
</pre>
</blockquote>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="basicsearch.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="controls.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
