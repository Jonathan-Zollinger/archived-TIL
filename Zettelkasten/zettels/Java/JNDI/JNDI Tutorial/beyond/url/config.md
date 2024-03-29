










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>URLs as Data for Configuration</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="fed.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="../fed/index.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/beyondHeader.gif" width=26 height=26 align=bottom border=0 alt="Beyond the Basics | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>URLs</em></strong></a>
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
    URLs as Data for Configuration
</h2>
<p>
<blockquote>

A URL string is used in
configuration in either of two ways. One way is as a
<a href=../../getStarted/concepts/glossary.html#REFERRAL>referral</a>.
A referral is basically configuration data on an LDAP server.
See the
<a target="_top" href="../../ldap/referral/index.html"><tt>Referrals</tt></a> <a href="../../ldap/referral/index.html"><img src="../../jndiimages/ldapIcon.gif" width=20 height=20 border=0 alt="(in the Tips for LDAP Users trail)"></a>    lesson for details.
The other way is to configure the initial context implementation. This use
is described in this section.
<p>
The JNDI defines an environment property
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#PROVIDER_URL"><tt>Context.PROVIDER_URL</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#PROVIDER_URL"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a> for configuring the initial context implementation.
Here's an example that configures the initial context implemented by
a file system service provider, <tt>com.sun.jndi.fscontext.FSContextFactory</tt>.
<blockquote><pre>
// Initialize environment with various properties
Hashtable env = new Hashtable();
env.put(Context.INITIAL_CONTEXT_FACTORY, 
    "com.sun.jndi.fscontext.FSContextFactory");
env.put(Context.PROVIDER_URL, "file:/");

// Call constructor
Context ctx = new InitialContext(env);
</pre></blockquote>
The URL string in this case is a <tt>file</tt> URL that
specifies the file directory root for the implementation.
<p>
Here is an example that configures the initial context
of Sun's LDAP service provider.
<blockquote><pre>
// Initialize environment with various properties
Hashtable env = new Hashtable();
env.put(Context.INITIAL_CONTEXT_FACTORY, 
    "com.sun.jndi.ldap.LdapCtxFactory");
env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=jnditutorial");

// Call the constructor
Context ctx = new InitialContext(env);
</pre></blockquote>
In this example, the URL string supplied is an <tt>ldap</tt> URL.
It specifies the LDAP server's machine and port number and 
the distinguished name of the root naming context (<tt>"o=jnditutorial"</tt>).
<p>

From these two examples, you can see that the format of the provider
URL string is service provider-specific.  The provider determines the
URL schemes that it supports.
Also, most providers
specify a default value for the <tt>Context.PROVIDER_URL</tt> property.
For example, Sun's file system service provider specifies that 
if the
<tt>Context.PROVIDER_URL</tt> property has not been specified,
then the default provider URL names the root of the file system.

<P ALIGN="CENTER">
<IMG SRC="../../jndiimages/shoeline2.GIF" ALIGN="BOTTOM" BORDER="0" WIDTH="202"
    HEIGHT="25" NATURALSIZEFLAG="3">
<IMG SRC="../../jndiimages/shoeline2.GIF" ALIGN="BOTTOM" BORDER="0" WIDTH="202"
    HEIGHT="25" NATURALSIZEFLAG="3">
</P>
<strong>URLs: End of Lesson</strong>
<p>
What's next? 
Now you can:
<ul>
<li> <a href=../fed/index.html>Continue</a> on in this trail
to learn about federation.

<li> Go to the 
<a target="_top" href="../misc/index.html">Miscellaneous</a> <a target="_top" href="../misc/index.html"><img src="../../jndiimages/beyondIcon.gif" width=20 height=20 border=0 alt="(in the Beyond the Basics trail)"></a>     lesson to read up on miscellaneous topics such as class loading and
link references.

</ul>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="fed.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="../fed/index.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/beyondHeader.gif" width=26 height=26 align=top border=0 alt="Beyond the Basics | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>URLs</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
