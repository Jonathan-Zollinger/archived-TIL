










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Reading Attributes</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="attrnames.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="modattrs.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Reading Attributes
</h2>
<p>
<blockquote>

To read the attributes of an object from the directory, use
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name)"><tt>DirContext.getAttributes()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     and pass it the name of 
the object for which you want the attributes.
Suppose that an object in the naming service has
the name <tt>"cn=Ted Geisel, ou=People"</tt>.
To retrieve this object's attributes, you'll need
<a href=src/GetattrsAll.java>code</a> that looks like this:
<blockquote>
<pre>
Attributes answer = ctx.getAttributes("cn=Ted Geisel, ou=People");
</pre>
</blockquote>
<p>
You can then print the contents of this answer as follows.
<blockquote>
<pre>
for (NamingEnumeration ae = answer.getAll(); ae.hasMore();) {
    Attribute attr = (Attribute)ae.next();
    System.out.println("attribute: " + attr.getID());
    /* Print each value */
    for (NamingEnumeration e = attr.getAll(); e.hasMore();
	 System.out.println("value: " + e.next()))
	;
}
</pre>
</blockquote>

This produces the following output.

<blockquote>
<pre>
# java GetattrsAll
attribute: sn
value: Geisel
attribute: objectclass
value: top
value: person
value: organizationalPerson
value: inetOrgPerson
attribute: jpegphoto
value: [B@1dacd78b
attribute: mail
value: Ted.Geisel@JNDITutorial.com
attribute: facsimiletelephonenumber
value: +1 408 555 2329
attribute: telephonenumber
value: +1 408 555 5252
attribute: cn
value: Ted Geisel
</pre>
</blockquote>

<h4>Returning Selected Attributes</h4>

To read a selective subset of attributes, you supply an array
of strings that are attribute identifiers of the attributes 
that you
want to retrieve.
<blockquote>
<pre>
// Specify the ids of the attributes to return
String[] attrIDs = {"sn", "telephonenumber", "golfhandicap", "mail"};

// Get the attributes requested
Attributes answer = ctx.getAttributes("cn=Ted Geisel, ou=People", attrIDs);
</pre>
</blockquote>
<a href=src/Getattrs.java>This example</a>
asks for the <tt>"sn"</tt>, <tt>"telephonenumber"</tt>,
<tt>"golfhandicap"</tt> and <tt>"mail"</tt> attributes of the object
<tt>"cn=Ted Geisel, ou=People"</tt>.
This object has all but the <tt>"golfhandicap"</tt> attribute,
and so three attributes are returned in the answer.
Following is the output of the example.
<blockquote>
<pre>
# java Getattrs
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
<a href="attrnames.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="modattrs.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
