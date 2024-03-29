










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Anonymous Authentication</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="auth.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="simple.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/ldapHeader.gif" width=26 height=26 align=bottom border=0 alt="Tips for LDAP Users | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Security</em></strong></a>
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
    Anonymous Authentication
</h2>
<p>
<blockquote>

As just stated,
the default authentication mechanism is <tt>"none"</tt>
if no authentication environment properties have been set.
If the client sets the
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#SECURITY_AUTHENTICATION><tt>Context.SECURITY_AUTHENTICATION</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#SECURITY_AUTHENTICATION><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    environment property to 
<tt>"none"</tt>, then the authentication mechanism is
<tt>"none"</tt> and
all other authentication environment properties are ignored.
You would want to do this explicitly only to ensure that
any other authentication properties that might have been set are
ignored.
In either case,
the client will be treated as an <em>anonymous</em> client.
This means that the server does not know or care who the client is and will
allow the client to access (read and update) any data that has been
configured to be accessible by any unauthenticated client.
<p>
Because none of the directory examples in
<a target="_top" href="../../basics/directory/index.html">The Basics</a> <a href="../../basics/directory/index.html"><img src="../../jndiimages/basicsIcon.gif" width=20 height=20 border=0 alt="(in the Basics trail)"></a>     trail set any of the authentication environment
properties, all of them use anonymous authentication.
<p>
Here is <a href=src/None.java>an example</a> that explicitly sets the
<tt>Context.SECURITY_AUTHENTICATION</tt> property to <tt>"none"</tt>
(even though doing this
is not strictly necessary because that is the default). 
<blockquote><pre>
// Set up the environment for creating the initial context
Hashtable env = new Hashtable();
env.put(Context.INITIAL_CONTEXT_FACTORY, 
    "com.sun.jndi.ldap.LdapCtxFactory");
env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

// Use anonymous authentication
env.put(Context.SECURITY_AUTHENTICATION, "none");

// Create the initial context
DirContext ctx = new InitialDirContext(env);

// ... do something useful with ctx
</blockquote></pre>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="auth.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="simple.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/ldapHeader.gif" width=26 height=26 align=top border=0 alt="Tips for LDAP Users | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Security</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
