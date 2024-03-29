










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Context Search Methods</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="index.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="other.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/ldapHeader.gif" width=26 height=26 align=bottom border=0 alt="Tips for LDAP Users | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Searches</em></strong></a>
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
    Context Search Methods
</h2>
<p>
<blockquote>

The
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html"><tt>DirContext</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     interface provides the following search methods:
<ul>
<li>     
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, javax.naming.directory.Attributes)"><tt>search(Name name, Attributes matchingAttrs)</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>
<li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, javax.naming.directory.Attributes, java.lang.String[])"><tt>search(Name name, Attributes matchingAttrs, String[] retAttrs)</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, javax.naming.directory.Attributes, java.lang.String[])"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, java.lang.String, javax.naming.directory.SearchControls)"><tt>search(Name name, String filter, SearchControls ctls)</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, java.lang.String, javax.naming.directory.SearchControls)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, java.lang.String, java.lang.Object[], javax.naming.directory.SearchControls)"><tt>search(Name name, String filterExpr, Object[] filterArgs, SearchControls ctls)</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#search(javax.naming.Name, java.lang.String, java.lang.Object[], javax.naming.directory.SearchControls)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a></ul>

Each of these methods has a corresponding overloaded form that accepts
a <tt>java.lang.String</tt> name instead of 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html"><tt>Name</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     as the first argument.

<h4>Using Matching Attributes</h4>
The first form,
<tt>search(Name name, Attributes matchingAttrs)</tt>,
is equivalent to the second form,
<tt>search(Name name, Attributes matchingAttrs, String[] retAttrs)</tt>,
with <tt>null</tt> supplied as the <tt>retAttrs</tt> argument:
<blockquote><pre>
search(name, matchingAttrs, null);
</pre></blockquote>
The 
<a target="_top" href="../../basics/directory/basicsearch.html">Basic Search</a> <a href="../../basics/directory/basicsearch.html"><img src="../../jndiimages/basicsIcon.gif" width=20 height=20 border=0 alt="(in the Basics trail)"></a>     examples show how to use both of these methods.
<p>
In these methods, the <tt>matchingAttrs</tt> argument is converted into 
an <A HREF="http://www.ietf.org/rfc/rfc2254.txt">RFC 2254</A> string filter
that is a conjunctive expression of the attributes from <tt>matchingAttrs</tt>.
For example, a <tt>matchingAttrs</tt> containing the following attributes:
<blockquote><pre>
sn: Geisel
mail: <em>(No value)</em>
</pre></blockquote>
is translated into the string filter 
<tt>"(&amp;(sn=Geisel)(mail=*))"</tt>.
<p>
Each attribute value is treated as a literal--that is, the
attribute in the directory entry is expected to contain exactly that value.
Therefore, if the attribute value contains a star character 
("*") or other special characters defined in <A HREF="http://www.ietf.org/rfc/rfc2254.txt">RFC 2254</A>,
then the LDAP provider will apply the appropriate encoding rules.
For example, a <tt>matchingAttrs</tt> containing the following attributes:
<blockquote><pre>
sn: Geisel
mail: *
</pre></blockquote>
is translated into the string filter 
<tt>"(&amp;(sn=Geisel)(mail=\2a))"</tt>.
In this case, the directory entry must contain a <tt>"mail"</tt> attribute whose
value is the string <tt>"*"</tt>.
<p>
If the attribute value is a <tt>byte</tt> array, then it is encoded by using the
notation for encoding nonstring attributes, as described in
<A HREF="http://www.ietf.org/rfc/rfc2254.txt">RFC 2254</A>.
For example, a <tt>matchingAttrs</tt> containing the following attribute:
<blockquote><pre>
jpegphoto: 82 12 38 4e 23 e3 <em>(byte array)</em>
</pre></blockquote>
is translated into the string filter 
<tt>"(jpegphoto=\82\12\38\4e\23\e3)"</tt>.

<a name=FILTER><h4>Using String Filters</h4></a>
The 
<a target="_top" href="../../basics/directory/filter.html">Search Filters</a> <a href="../../basics/directory/filter.html"><img src="../../jndiimages/basicsIcon.gif" width=20 height=20 border=0 alt="(in the Basics trail)"></a>     section has a quick overview of search filter syntax and
contains examples of how to use the third form of the search method,
<tt>search(Name name, String filter, SearchControls ctls)</tt>.
The string filter follows the syntax specified in
<A HREF="http://www.ietf.org/rfc/rfc2254.txt">RFC 2254</A>,
except that Unicode characters are also allowed.
Using Unicode characters is preferable to using encoded UTF-8
octets. 
<p>
For example, in the Java programming language, you can specify
the Greek letter <em>alpha</em> as the Unicode character <tt>\u03b1</tt>. 
To search for an entry whose attribute value contains this
character, you can use the string <tt>"\u03b1"</tt> or 
<tt>"\ce\b1"</tt> (with
appropriate escapes for the backslash characters ("\")
if you're using that character
as a literal string in the Java programming language).
The Unicode form is the preferred form.
The LDAP service provider will translate
Unicode characters into their corresponding UTF-8 representation for
transmission to the server.

<p>
You need to be careful when constructing a string filter by using string
concatenation and variables. In particular, you need to ensure that
the resulting filter is well-formed and conveys your original intent.
For example, suppose you construct a filter by concatenating the
<tt>"userPassword"</tt> attribute name 
and a password (as recorded in the variable <tt>pw</tt>)
to verify a user's password.
<blockquote><pre>
"(userPassword=" + pw + ")"
</pre></blockquote>

If the value of <tt>pw</tt> is "*", the filter will be asking the
server to verify the presence of the <tt>userPassword</tt> attribute
instead of the exact match of the <tt>userPassword</tt> attribute.
Furthermore, occurrence of other special characters in <tt>pw</tt>
(for example, such as a closing parenthesis) might produce an invalid filter. 
Therefore, to ensure that <tt>pw</tt>
does not violate the integrity and intent of the filter, you need to
escape any of its characters that conflict with the (RFC 2254) filter syntax.
Instead of doing this
manually in your program, you should use the other forms of search
that accept a string filter with an <tt>Object</tt> array argument or
matching attributes. These forms of search automatically perform the
necessary escaping of special characters.


<h4>Using String Filters with Arguments</h4>

The fourth form of the search method,
<tt>search(Name name, String filterExpr, Object[] filterArgs, SearchControls ctls)</tt>,
allows you to construct
the string filter by using a filter expression <tt>filterExpr</tt>
and an array of arguments <tt>filterArgs</tt>.
<p>
The <tt>filterExpr</tt> argument can contain strings of the form "{<em>n</em>}",  
where the <em>n</em>th element of <tt>filterArgs</tt> replaces the occurrence
of the "{<em>n</em>}" string in <tt>filterExpr</tt> in the resulting string filter.
Each "{<em>n</em>}" string may appear as an attribute name,
an attribute value, or a component of the attribute value.
(Or more precisely, 
each "{<em>n</em>}" string may appear in place of 
<tt>"attr"</tt> or <tt>"value"</tt> in 
Section 4 from
<A HREF="http://www.ietf.org/rfc/rfc2254.txt">RFC 2254.</A>)
<p>
During the substitution,
the objects in <TT>filterArgs</TT> are encoded as follows.
<UL>
<LI>
Each byte in a <tt>byte</tt> array (<TT>byte[]</TT>) is encoded as a string,
according to <A HREF="http://www.ietf.org/rfc/rfc2254.txt">RFC 2254</A>.
For example, the array <tt>{0, 1, 10, 100}</tt> is encoded as the string 
<tt>"\00\01\0a\64"</tt>.</LI>

<LI>
Strings are treated as literals; "*" and other special
characters defined in  
<A HREF="http://www.ietf.org/rfc/rfc2254.txt">RFC 2254</A> 
that appear in the string are encoded according to the rules in 
<A HREF="http://www.ietf.org/rfc/rfc2254.txt">RFC 2254</A>. 
For example, a string of <tt>"*"</tt> is encoded as the string 
<tt>"\2a"</tt>.
Therefore, to use special characters in the filter, you must
put them in the string expression <tt>filterExpr</tt>.
</LI>

<LI>
Objects that are neither a <TT>String</TT> nor a <TT>byte[]</TT> are converted
to their string form via <tt>Object.toString()</tt> and then the rules for
<TT>String</TT> apply.</LI>
</UL>
<p>
Here's <a href=src/FilterArgs.java>an example</a>
that demonstrates the use of this method.
<blockquote><pre>
// Specify the filter arguments
byte[] key = {(byte)0x61, (byte)0x62, (byte)0x63, (byte)0x64, 
    (byte)0x65, (byte)0x66, (byte)0x67};
String name = "User";

// Perform the search
NamingEnumeration answer = ctx.search("ou=NewHires", 
    "(&amp;(mySpecialKey={0}) (cn=*{1}))",      // Filter expression
    new Object[]{key, name},                // Filter arguments
    null);				    // Default search controls
</pre></blockquote>
The filter expression specifies two substitutions:
the contents of the <tt>byte</tt> array <tt>key</tt> replaces <tt>"{0}"</tt>
and <tt>name</tt> replaces <tt>"{1}"</tt>.
Note the use of the wildcard for the <tt>"cn"</tt> portion of the filter
in the filter expression. Running this example produces the following output.
<blockquote><pre>
&gt;&gt;&gt;cn=S. User
{myspecialkey=myspecialkey: abcdefg, 
 sn=sn: User, 
 objectclass=objectclass: top, person, organizationalPerson, 
     inetOrgPerson, extensibleObject, 
 mail=mail: suser@JNDITutorial.com, 
 userpassword=userpassword: [B@1dacd79e, 
 cn=cn: S. User
}
</pre></blockquote>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="index.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="other.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/ldapHeader.gif" width=26 height=26 align=top border=0 alt="Tips for LDAP Users | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Searches</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
