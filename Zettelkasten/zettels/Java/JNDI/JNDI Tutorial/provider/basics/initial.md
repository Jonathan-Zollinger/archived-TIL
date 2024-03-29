










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Implementing an Initial Context Factory</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="extend.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="../dir/index.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/providerHeader.gif" width=26 height=26 align=bottom border=0 alt="Building a Service Provider | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>The Essential Components</em></strong></a>
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
    Implementing an Initial Context Factory
</h2>
<p>
<blockquote>

The 

<a target="_top" href="../../basics/prepare/initial.html">Preparations</a> <a href="../../basics/prepare/initial.html"><img src="../../jndiimages/basicsIcon.gif" width=20 height=20 border=0 alt="(in the Basics trail)"></a>
   lesson describes how to set up an
<em><a href=../../getStarted/concepts/glossary.html#IC>initial context</a></em>
to access naming/directory services via the JNDI.
For example, to use Sun's LDAP provider, use
code that looks as follows.
<blockquote>
<pre>
Hashtable env = new Hashtable();
env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=jnditutorial");
Context ctx = new InitialContext(env);

// ... do something useful with ctx
</pre>
</blockquote>

The
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html><tt>InitialContext</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>
class is just a wrapper class that accesses the real context 
implementation--the <tt>Context</tt> instance created by the 
<em>initial context factory</em> class named by the

<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#INITIAL_CONTEXT_FACTORY><tt>Context.INITIAL_CONTEXT_FACTORY</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#INITIAL_CONTEXT_FACTORY><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>
    (<tt>"java.naming.factory.initial"</tt>) environment property.
This factory class must implement the 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/InitialContextFactory.html><tt>InitialContextFactory</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/InitialContextFactory.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    interface.
In the previous example, the initial context factory class is
<tt>com.sun.jndi.ldap.LdapCtxFactory</tt>.
<p>
For a context implementation to be accessible from the initial
context, a service provider must provide a class that implements
the <tt>InitialContextFactory</tt> interface.
Here is <a href=src/tut/InitCtxFactory.java>an example</a> 
of an initial context factory for 
<a href=src/tut/HierCtx.java>the hierarchical namespace example</a>.
<blockquote><pre>
public class InitCtxFactory implements InitialContextFactory {

    public Context getInitialContext(Hashtable env) {
        return new HierCtx(env);
    }
}
</blockquote></pre>
This example is very simple. It calls the <tt>HierCtx</tt> constructor
and returns an empty context.
In an actual implementation, the initial context factory must create
a <tt>Context</tt> instance for reaching all other parts of the namespace
of the underlying naming/directory service. Also,
an actual implementation would typically use the
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#PROVIDER_URL><tt>Context.PROVIDER_URL</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#PROVIDER_URL><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    (<tt>"java.naming.provider.url"</tt>) environment property
to initialize the initial context.
For example, in Sun's LDAP provider, the <tt>Context.PROVIDER_URL</tt> property
indicates directory server's machine address and port, as well as
the DN (distinguished name) of root naming context to use.
In the previous example, the machine address and port are
<tt>localhost</tt> and <tt>389</tt> and the DN
is <tt>"o=jnditutorial"</tt>.

<P ALIGN="CENTER">
<IMG SRC="../../jndiimages/shoeline2.GIF" ALIGN="BOTTOM" BORDER="0" WIDTH="202"
    HEIGHT="25" NATURALSIZEFLAG="3">
<IMG SRC="../../jndiimages/shoeline2.GIF" ALIGN="BOTTOM" BORDER="0" WIDTH="202"
    HEIGHT="25" NATURALSIZEFLAG="3">
</P>
<strong>The Essential Components: End of Lesson</strong>
<p>
What's next? 
Now you can:
<ul>
<li> <a href=../dir/index.html>Continue</a> on in this trail to learn
how to add directory support.

<li> Go to the 
<a target="_top" href="../url/index.html">Adding URL Support</a> <a target="_top" href="../url/index.html"><img src="../../jndiimages/providerIcon.gif" width=20 height=20 border=0 alt="(in the Building a Service Provider trail)"></a>    lesson to learn how to add pieces to the service provider for supporting
URLs.

<li> Go to the 
<a target="_top" href="../fed/index.html">Adding Federation Support</a> <a target="_top" href="../fed/index.html"><img src="../../jndiimages/providerIcon.gif" width=20 height=20 border=0 alt="(in the Building a Service Provider trail)"></a>     lesson to learn how to add federation support to a service provider.

<li> Go to the 
<a target="_top" href="../misc/index.html">Miscellaneous</a> <a target="_top" href="../misc/index.html"><img src="../../jndiimages/providerIcon.gif" width=20 height=20 border=0 alt="(in the Building a Service Provider trail)"></a>     lesson to learn how to add various enhancements to a service provider,
such as adding support for referrals and bundling factories.

</ul>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="extend.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="../dir/index.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/providerHeader.gif" width=26 height=26 align=top border=0 alt="Building a Service Provider | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>The Essential Components</em></strong></a>
</td>
</tr>
</table>
</body>
</html>

