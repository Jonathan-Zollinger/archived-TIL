










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Callbacks for SASL Mechanisms</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="crammd5.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="gssapi.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Callbacks for SASL Mechanisms
</h2>
<p>
<blockquote>

A SASL mechanism is always given the authorization id (that
specified by the <tt>"java.naming.security.sasl.authorizationId"</tt>)
environment property.
All other input is supplied on-demand, that is, on request of the mechanism.
<p>
By default, the LDAP provider supplies the authentication id
and credentials by using, respectively, the
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#SECURITY_PRINCIPAL><tt>Context.SECURITY_PRINCIPAL</TT></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#SECURITY_PRINCIPAL><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   and
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#SECURITY_CREDENTIALS><tt>Context.SECURITY_CREDENTIALS</TT></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#SECURITY_CREDENTIALS><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>  environment properties.
If a SASL mechanism requires input other than these, or if you
prefer to supply the input through a different means, then you
can define a <em>callback handler</em> object for the mechanism
to use. To do this, you set
the <tt>"java.naming.security.sasl.callback"</tt> environment property
to the callback handler object, as explained next.

<h4>Callback Handler</h4>
<p>
The LDAP provider uses the
<a target="_top" href=http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/package-summary.html><tt>javax.security.auth.callback</tt></a><a target="_top" href=http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/package-summary.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    package from the
<a href=http://java.sun.com/security/jaas>Java Authentication and Authorization Service</a>.

The object contained in the <tt>"java.naming.security.sasl.callback"</tt>
environment property must be of type
<a target="_top" href=http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/CallbackHandler.html><tt>javax.security.auth.callback.CallbackHandler</tt></a><a target="_top" href=http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/CallbackHandler.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a> .
When a SASL mechanism requires input, it invokes
<a target="_top" href="http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/CallbackHandler.html#handle(javax.security.auth.callback.Callback[])"><tt>javax.security.auth.callback.CallbackHandler.handle()</tt></a><a target="_top" href="http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/CallbackHandler.html#handle(javax.security.auth.callback.Callback[])"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>, and supplies the list of callbacks that it needs
in order to get that input.

A mechanism must use the 
<a target="_top" href=http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/NameCallback.html><tt>javax.security.auth.callback.NameCallback</tt></a><a target="_top" href=http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/NameCallback.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    when asking for the authentication id and use the
<a target="_top" href=http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/PasswordCallback.html><tt>javax.security.auth.callback.PasswordCallback</tt></a><a target="_top" href=http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/PasswordCallback.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    when asking for the authentication credentials.
To obtain other input, the mechanism will use one of the callbacks
defined in the <tt>javax.security.auth.callback</tt> package or any other
callback that implements the 
<a target="_top" href=http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/Callback.html><tt>javax.security.auth.callback.Callback</tt></a><a target="_top" href=http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/Callback.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a> interface.
<p>
The callback handler must be able to handle the type of callback requested
by a mechanism, so the application that creates/uses the callback handler
must have some knowledge about what the mechanism requires.
For example, in addition to the <tt>NameCallback</tt> and 
<tt>PasswordCallback</tt>, the Digest-MD5 mechanism requires
also callbacks to get the realm.
The realm is obtained by using either a
<a target="_top" href=http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/TextInputCallback.html><tt>javax.security.auth.callback.TextInputCallback</tt></a><a target="_top" href=http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/TextInputCallback.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   or
<a target="_top" href=http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/ChoiceCallback.html><tt>javax.security.auth.callback.ChoiceCallback</tt></a><a target="_top" href=http://java.sun.com/security/jaas/apidoc/javax/security/auth/callback/ChoiceCallback.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.

<p>
Here is an example of a <a href=src/SampleCallbackHandler.java>callback handler</a>
that handles <tt>NameCallback</tt> and <tt>PasswordCallback</tt> by
reading the data from Standard Input.
<blockquote><pre>
public class SampleCallbackHandler implements CallbackHandler {
    public void handle(Callback[] callbacks) 
	throws java.io.IOException, UnsupportedCallbackException {
	    for (int i = 0; i &lt; callbacks.length; i++) {
		if (callbacks[i] instanceof NameCallback) {
		    NameCallback cb = (NameCallback)callbacks[i];
		    cb.setName(getInput(cb.getPrompt()));

		} else if (callbacks[i] instanceof PasswordCallback) {
		    PasswordCallback cb = (PasswordCallback)callbacks[i];

		    String pw = getInput(cb.getPrompt());
		    char[] passwd = new char[pw.length()];
		    pw.getChars(0, passwd.length, passwd, 0);

		    cb.setPassword(passwd);
		} else {
		    throw new UnsupportedCallbackException(callbacks[i]);
		}
	    }
    }

    /**
     * A reader from Standard Input. In real world apps, this would
     * typically be a TextComponent or similar widget.
     */
    private String getInput(String prompt) throws IOException {
	System.out.print(prompt);
	BufferedReader in = new BufferedReader(
	    new InputStreamReader(System.in));
	return in.readLine();
    }
}	
</pre></blockquote>

<h4>CRAM-MD5 by Using a Callback Handler</h4>

Here's a <a href=src/UseCallback.java>modified version</a> 
of the <a href=crammd5.html>CRAM-MD5 example</a>
that gets its password by using a callback handler instead the
<tt>Context.SECURITY_PRINCIPAL</tt> and
<tt>Context.SECURITY_CREDENTIALS</tt> 
environment properties.
The CRAM-MD5 mechanism needs
the authentication id and the password as input. These are supplied by 
<a href=src/SampleCallbackHandler.java><tt>SampleCallbackHandler</tt></a>.
<blockquote><pre>
// Set up the environment for creating the initial context
Hashtable env = new Hashtable(11);
env.put(Context.INITIAL_CONTEXT_FACTORY, 
    "com.sun.jndi.ldap.LdapCtxFactory");
env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

env.put(Context.SECURITY_AUTHENTICATION, "CRAM-MD5");

// Specify the callback to use for fetching the authentication id/password
env.put("java.naming.security.sasl.callback", new SampleCallbackHandler());

// Create the initial context
DirContext ctx = new InitialDirContext(env);

// ... do something useful with ctx
</pre></blockquote>


</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="crammd5.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="gssapi.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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

