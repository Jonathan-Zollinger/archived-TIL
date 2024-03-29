










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>URL Context Implementation</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="factory.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="dircontext.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    URL Context Implementation
</h2>
<p>
<blockquote>

A <em>URL context implementation</em> is a context that
can handle arbitrary URL strings of the URL scheme supported
by the context.
It is a class that implements the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><tt>Context</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    interface or one of its subinterfaces.
It differs from the (plain) context implementation described in
the 
<a target="_top" href="../basics/context.html">The Essential Components</a> <a target="_top" href="../basics/context.html"><img src="../../jndiimages/providerIcon.gif" width=20 height=20 border=0 alt="(in the Building a Service Provider trail)"></a>    lesson in the way that its methods accept and process the name argument.

<h4>Structured versus String Names</h4>

<a target="_top" href="../ground/names.html">The Ground Rules</a> <a target="_top" href="../ground/names.html"><img src="../../jndiimages/providerIcon.gif" width=20 height=20 border=0 alt="(in the Building a Service Provider trail)"></a>    lesson suggests that you implement the context methods
that accept strings in terms of their 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html"><tt>Name</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    counterparts because string names should be treated like
(JNDI) composite names.
This rule does not apply to URL context implementations, because
a URL string is not a JNDI composite name.
A URL string should be processed according to the syntax
defined by its URL scheme.
In fact, the dependency is the other way around. That is, the
overloads that accept <tt>Name</tt> should be implemented in
terms of their string counterparts.
<p>
If you do not want to support federation, then you can just throw
an <tt>InvalidNameException</tt> when presented with a multicomponent
<tt>Name</tt>:
<blockquote><pre>
public void bind(Name name, Object obj) throws NamingException {
    if (name.size() == 1) {
        bind(name.get(0), obj);
    } else {
        throw new InvalidNameException(
	    "Cannot have composite names with URLs");
    }
}
</pre></blockquote>


<p>
If you do support federation,
then when presented with a 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompositeName.html"><tt>CompositeName</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/CompositeName.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    whose first component is a valid URL string, you should treat
the first component as a URL and the rest as components for
federation (that is, resolving the URL will tell you
which naming system to use to resolve the remaining part).
If presented with a <tt>Name</tt> that is not a <tt>CompositeName</tt>,
you should treat this as an error case and throw an
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InvalidNameException.html"><tt>InvalidNameException</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InvalidNameException.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
This is because a URL embedded within a compound name is nonsensical.
<p>
<a href=src/tut/foo/fooURLContext.java>This example</a>
doesn't check whether the input is a <tt>CompositeName</tt>.
Here is the definition of 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#bind(javax.naming.Name, java.lang.Object)"><tt>bind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#bind(javax.naming.Name, java.lang.Object)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   from the example.
<blockquote><pre>
public void bind(Name name, Object obj) throws NamingException {
    if (name.size() == 1) {
        bind(name.get(0), obj);
    } else {
	Context ctx = getContinuationContext(name);
	try {
	    ctx.bind(name.getSuffix(1), obj);
	} finally {
	    ctx.close();
        }
    }
}
</pre></blockquote>
<p>
All overloads that accept <tt>Name</tt> use a similar pattern.
If the name contains a single component, then extract the first
component and pass it to the overload that accepts a string name.
This resembles the caller's using the overload that accepts a string name
in the first place.
Otherwise, use the utility method <tt>getContinuationContext()</tt>
to resolve the first component (i.e., the URL string)
and continue the operation in that context.
Here is the definition of <tt>getContinuationContext()</tt>.
<blockquote><pre>
protected Context getContinuationContext(Name n) throws NamingException {
    Object obj = lookup(n.get(0));
    CannotProceedException cpe = new CannotProceedException();
    cpe.setResolvedObj(obj);
    cpe.setEnvironment(myEnv);
    return NamingManager.getContinuationContext(cpe);
}
</pre></blockquote>
This utility method resolves the first component of the name
and uses the result as the "resolved object" in a call to
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/NamingManager.html#getContinuationContext(javax.naming.CannotProceedException)"><tt>NamingManager.getContinuationContext()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/NamingManager.html#getContinuationContext(javax.naming.CannotProceedException)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   to get the target context in which to continue the operation
on the remainder of the name.


<h4>The Root URL Context </h4>

Now that you have taken care of the overloads that accept <tt>Name</tt>,
you can turn your attention to the overloads that accept 
<tt>java.lang.String</tt>.
The implementations of these methods depend highly
on their "non-URL" counterpart context implementation.
For example, a URL context implementation for the LDAP URL
is highly dependent on the context implementation for the LDAP
service. A lookup of an LDAP URL in an LDAP URL context
typically results in a lookup in an LDAP context
(from the LDAP context implementation) using an LDAP DN.
In this scenario, the URL context implementation is really
just a front-end to the actual service's context implementation.
Because of this close relationship, 
<a href=src/tut/foo/fooURLContext.java>this example</a>
might not apply as well to some actual implementations.
<p>
<a href=src/tut/foo/fooURLContext.java>The example</a>
uses the notion of a <em>root context</em> that is derived
from the input URL string.
It defines a utility method, <tt>getRootURLContext()</tt>,
that accepts a URL string. This method returns a 
tuple that consists of
a context that is derived from information in the URL and
the remaining name from the URL to be resolved relative to
the root context.
For example, in the LDAP example, suppose that the input URL string
is <tt>"ldap://favserver:289/o=jnditutorial"</tt>.
The root context might be the context at the root of the 
LDAP server at machine <tt>favserver</tt> and port <tt>289</tt>.
In that case, the <tt>"ldap://favserver:289/"</tt> portion of the URL string
will be consumed in producing the root context and
the remaining name will be <tt>"o=jnditutorial"</tt>.
<p>
In our <tt>foo</tt> URL example, the root context points to
the root of the <tt>HierCtx</tt> static namespace, and 
<tt>"foo:/"</tt> is consumed in producing the root context.
The remaining name is represented as a single component
<tt>CompositeName</tt>.
<blockquote><pre>
protected ResolveResult getRootURLContext(String url, Hashtable env) 
    throws NamingException {
    if (!url.startsWith("foo:/")) {
	throw new IllegalArgumentException(url + " is not a foo URL");
    }

    String objName = url.length() &gt; 5 ? url.substring(5) : null;

    // Represent the object name as empty or a single-component composite name.
    CompositeName remaining = new CompositeName();
    if (objName != null) {
	remaining.add(objName);
    }

    // Get the handle to the static namespace to use for testing
    // In an actual implementation, this might be the root
    // namespace on a particular server
    Context ctx = tut.HierCtx.getStaticNamespace(env);

    return (new ResolveResult(ctx, remaining));
}
</pre></blockquote>
The overloads that accept string names use this
utility method to process the URL string and then complete 
the operation.
Here is the definition of 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#bind(java.lang.String, java.lang.Object)"><tt>bind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#bind(java.lang.String, java.lang.Object)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   from the example.
<blockquote><pre>
public void bind(String name, Object obj) throws NamingException {
    ResolveResult res = getRootURLContext(name, myEnv);
    Context ctx = (Context)res.getResolvedObj();
    try {
        ctx.bind(res.getRemainingName(), obj);
    } finally {
        ctx.close();
    }
}
</pre></blockquote>
Notice that before the method returns, it closes the root context.
In this example, this step is not really necessary
because <tt>fooURLContext</tt> doesn't maintain any connections
or resources.
However, doing this is good practice so as to ensure that implementations
that do maintain connections or resources are cleaned up properly.
This also means that stateful methods such as 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#list(java.lang.String)"><tt>list()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#list(java.lang.String)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   must ensure that the enumeration results that they return remain usable even
after the context has been closed.

<h4>Special Considerations for rename()</h4>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#rename(java.lang.String, java.lang.String)"><tt>rename()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#rename(java.lang.String, java.lang.String)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>
   differs from the other context methods in that it accepts
two names instead of one. With one name, you can use 
<tt>getRootURLContext()</tt> to get a workable context to
complete the operation. With two names, you cannot call
<tt>getRootURLContext()</tt> twice, once for each name, because
each call might return a different context. 
<tt>rename()</tt> can have only one context in which to do the renaming.
<p>
To solve this for
<a href=src/tut/foo/fooURLContext.java>the example here</a>,
you first extract from both names a common prefix
(by using the internal utility <tt>getURLPrefix()</tt>).
Then you use <tt>getRootURLContext()</tt> to get the
root context and remaining name of the original name.
To get the remaining name of the new name, you use
another internal utility, <tt>getURLSuffix()</tt>.
Note that it is very important that all three methods--<tt>getRootURLContext()</tt>, 
<tt>getURLPrefix()</tt>, and
<tt>getURLSuffix()</tt>--are in complete agreement regarding
how a URL string is  parsed and which parts are
designated the prefix and suffix.
<p>
In particular,
<tt>getRootURLContext()</tt> should consume the portion
that is returned by <tt>getURLPrefix()</tt> to create
its root context and return as remaining name
the portion that <tt>getURLSuffix()</tt> will return.
You also should take into account
the restrictions on a context implementation's ability
to perform renames across different servers or namespaces.
<p>
Here is the example of <tt>rename()</tt>.
<blockquote><pre>
public void rename(String oldName, String newName) 
    throws NamingException {
    String oldPrefix = getURLPrefix(oldName);
    String newPrefix = getURLPrefix(newName);
    if (!urlEquals(oldPrefix, newPrefix)) {
	throw new OperationNotSupportedException(
	    "Renaming using different URL prefixes not supported : " +
		oldName + " " + newName);
    }

    ResolveResult res = getRootURLContext(oldName, myEnv);
    Context ctx = (Context)res.getResolvedObj();
    try {
        ctx.rename(res.getRemainingName(), 
	    getURLSuffix(newPrefix, newName));
    } finally {
	ctx.close();
    }
}
</blockquote></pre>

Here are the implementations of <tt>getURLPrefix()</tt> and
<tt>getURLSuffix()</tt>.
<blockquote><pre>
protected String getURLPrefix(String url) throws NamingException {
    int start = url.indexOf(":");

    if (start &lt; 0) {
        throw new OperationNotSupportedException("Invalid URL: " + url);
    }
    ++start; // Skip ":"

    if (url.startsWith("//", start)) {
	start += 2;  // Skip the double forward slash
	    
	// Find the last forward slash
	int posn = url.indexOf("/", start);
	if (posn &gt;= 0) {
	    start = posn;
	} else {
	    start = url.length();  // Rest of the URL
	}
    }

    // Else 0 or 1 initial slashes; the start is unchanged
    return url.substring(0, start);
}

protected Name getURLSuffix(String prefix, String url) 
    throws NamingException {
    String suffix = url.substring(prefix.length());
    if (suffix.length() == 0) {
        return new CompositeName();
    }

    if (suffix.charAt(0) == '/') {
	suffix = suffix.substring(1); // Skip the leading forward slash
    }

    // Note: This is a simplified implementation;
    // a real implementation should
    // transform any URL-encoded characters into their Unicode char
    // representations
    return new CompositeName().add(suffix);
}
</blockquote></pre>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="factory.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="dircontext.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
