










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Relationship to the Initial Context</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="env.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="reference.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/providerHeader.gif" width=26 height=26 align=bottom border=0 alt="Building a Service Provider | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Adding URL Support</em></strong></a>
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
    Relationship to the Initial Context
</h2>
<p>
<blockquote>

When the API user supplies a URL string to one of the methods in the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html"><tt>InitialContext</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   or
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/InitialDirContext.html"><tt>InitialDirContext</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/InitialDirContext.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    class, the JNDI extracts the URL scheme from the string and uses
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/NamingManager.html#getURLContext(java.lang.String, java.util.Hashtable)"><tt>NamingManager.getURLContext()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/NamingManager.html#getURLContext(java.lang.String, java.util.Hashtable)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    to find a URL context implementation that can process the URL string.
This method uses the algorithm described
<a href=env.html>earlier in this lesson</a>.
<p>
If the JNDI successfully locates a URL context implementation, 
then it invokes
the original context method by using the original arguments.
This means that the complete URL string is passed on to the URL context
implementation, where it is processed as described in
the <a href=context.html>URL Context Implementation</a> section of this lesson. 
<p>
If the JNDI cannot locate a URL context implementation to 
use to process
the URL string, then it assumes that the input name is not a URL string.
It then passes the name to the underlying initial context implementation
(that named by the
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#INITIAL_CONTEXT_FACTORY><tt>Context.INITIAL_CONTEXT_FACTORY</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#INITIAL_CONTEXT_FACTORY><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a> (<tt>"java.naming.factory.initial"</tt>) environment property).

<a name=SUB></a>
<h4>Supporting Subinterfaces</h4>

To provide URL support from the initial context
to a
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><tt>Context</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    subinterface, you need to define a new class that extends from
<tt>InitialContext</tt> or one of its subclasses.
See <a href=dircontext.html#SUB>the discussion</a>
earlier in this lesson regarding factors to consider when
deciding whether to add URL support for a subinterface.
<p>
For example, suppose that
<a href=src/tut/BarContext.java><tt>BarContext</tt></a> extends
<tt>Context</tt> by adding two new methods: <tt>barMethod()</tt>,
which accepts a name argument, and <tt>bazMethod()</tt>,
which does not.
This service has a URL scheme id of <tt>bar</tt>.
(See its 
<a href=src/tut/bar/barURLContext.java>URL context implementation</a>
presented <a href=dircontext.html#SUB>earlier</a> in this lesson.)
To define an initial context for this interface, you first specify
its inheritance.
<blockquote><pre>
public class InitialBarContext 
    extends InitialContext implements BarContext
</blockquote></pre>
<a href=src/tut/InitialBarContext.java>This class</a>
extends from the <tt>InitialContext</tt> and implements
the new interface, <tt>BarContext</tt>.
<p>
Then you define some constructors that are suitable for the class.
Typically, you should plan on at least two constructors, one that
accepts no arguments and one that accepts the environment parameter.
<blockquote><pre>
public InitialBarContext() throws NamingException {
    super();
}

public InitialBarContext(Hashtable env) throws NamingException {
    super(env);
}
</blockquote></pre>
Next, you provide utility methods for both methods that process names and
those that don't.
For methods that process names, define a utility method that
returns either a URL context or the default underlying initial context
by inspecting the name argument.
Most of the work for this is done by 
the protected method
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html#getURLOrDefaultInitCtx(java.lang.String)"><tt>InitialContext.getURLOrDefaultInitCtx()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html#getURLOrDefaultInitCtx(java.lang.String)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>. The utility method needs only to check the type of the resulting
context to make sure that it is compatible with that of the subinterface.
You need two such methods, one for the string name and one
for <tt>Name</tt>. Here is the string version.
<blockquote><pre>
protected BarContext getURLOrDefaultInitBarCtx(String name)
    throws NamingException {
    Context ctx = getURLOrDefaultInitCtx(name);
    if (!(ctx instanceof BarContext)) {
	throw new NoInitialContextException("Not a BarContext");
    }
    return (BarContext)ctx;
}
</pre></blockquote>
For methods that do not process names, define a utility method that
returns the default underlying initial context.
Most of the work for this is done by 
the protected method
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html#getDefaultInitCtx()"><tt>InitialContext.getDefaultInitCtx()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html#getDefaultInitCtx()"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>. The utility method needs only to check the type of the resulting
context to make sure that it is compatible with that of the subinterface.
<blockquote><pre>
protected BarContext getDefaultInitBarCtx() throws NamingException {
    Context ctx = getDefaultInitCtx();
    if (!(ctx instanceof BarContext)) {
	throw new NoInitialContextException("Not a BarContext");
    }
    return (BarContext)ctx;
}
</pre></blockquote>
Once you have these methods, it is straightforward to provide 
implementations for all of the new methods.
New name-related methods use <tt>getURLOrDefaultInitBarCtx()</tt>,
whereas new non-name-related methods use <tt>getDefaultInitBarCtx()</tt>.
Here are some examples.
<blockquote><pre>
public Object barMethod(String name) throws NamingException {
    return getURLOrDefaultInitBarCtx(name).barMethod(name);
}

public String bazMethod() throws NamingException {
    return getDefaultInitBarCtx().bazMethod();
}
</blockquote></pre>

To use this new initial context implementation, your program must
import the new class. Here is <a href=src/Bar.java>an example</a>
that invokes one of the new methods using a <tt>bar</tt> URL.
<blockquote><pre>
tut.BarContext ctx = new tut.InitialBarContext();

// Invoke the BarContext-specific method with the URL
Object answer = ctx.barMethod("bar:/a");
</blockquote></pre>
Running this example produces the output
<blockquote><pre>
The answer is a
</pre></blockquote>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="env.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="reference.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/providerHeader.gif" width=26 height=26 align=top border=0 alt="Building a Service Provider | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Adding URL Support</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
