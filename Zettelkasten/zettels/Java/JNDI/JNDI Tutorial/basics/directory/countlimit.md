










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Count Limit</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="scope.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="timelimit.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Count Limit
</h2>
<p>
<blockquote>

Sometimes, a query might produce too many answers
and you want to limit the number
of answers returned. You can do this by using the
count limit search control. 
By default, a search does not have a count limit--it will return all answers that it finds.
To set the count limit of a search, pass the number
to

<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#setCountLimit(long)"><tt>SearchControls.setCountLimit()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/SearchControls.html#setCountLimit(long)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
<p><a href=src/SearchCountLimit.java>The following example</a>
sets the count limit to 1.
<blockquote>
<pre>
// Set the search controls to limit the count to 1
SearchControls ctls = new SearchControls();
ctls.setCountLimit(1);
</pre>
</blockquote>
If the program attempts to get
more than the count limit number of results, then a
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/SizeLimitExceededException.html><tt>SizeLimitExceededException</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/SizeLimitExceededException.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     will be thrown.
So if a program has set a count limit, then it should either differentiate
this exception from other 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingException.html><tt>NamingException</tt>s</a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/NamingException.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     or keep track of the count limit and not request more
than that number of results.
<p>
Specifying a count limit for a search is one way of controlling the
resources (such as memory and network bandwidth) that your application
consumes. Other ways to control the resources consumed are
to narrow your 
<a href=filter.html>search filter</a>
(be more specific about what you seek),
start your search in the appropriate context,
and use the appropriate <a href=scope.html>scope</a>.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="scope.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="timelimit.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
