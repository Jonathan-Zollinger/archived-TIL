










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Supporting Subinterfaces</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="context.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="env.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Supporting Subinterfaces
</h2>
<p>
<blockquote>
<p>

An API user can pass a URL string to methods in the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/InitialDirContext.html"><tt>InitialDirContext</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/InitialDirContext.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   class in the same way as for methods in the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html"><tt>InitialContext</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   class.
To support this capability, the corresponding URL 
context implementation must support methods in the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html"><tt>DirContext</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    interface in addition to those in the <tt>Context</tt>
interface,
using the techniques described earlier in the
<a href=context.html>URL Context Implementation section</a>.
<p>
If your URL context implementation also supports federation, 
then it should
define an internal utility method for getting the continuation
context for performing directory operations. Here is an example.
<blockquote><pre>
protected DirContext getContinuationDirContext(Name n) 
    throws NamingException {
    Object obj = lookup(n.get(0));
    CannotProceedException cpe = new CannotProceedException();
    cpe.setResolvedObj(obj);
    cpe.setEnvironment(myEnv);
    return DirectoryManager.getContinuationDirContext(cpe);
}
</blockquote></pre>
This method uses
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirectoryManager.html#getContinuationDirContext(javax.naming.CannotProceedException)"><tt>DirectoryManager.getContinuationDirContext()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirectoryManager.html#getContinuationDirContext(javax.naming.CannotProceedException)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   to get the continuation context.
Overloads that accept 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html"><tt>Name</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Name.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>  use this utility in their implementations.
Here is an example of how 
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name, java.lang.String[])"><tt>getAttributes()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(javax.naming.Name, java.lang.String[])"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   uses <tt>getContinuationDirContext()</tt>.
<blockquote><pre>
public Attributes getAttributes(Name name, String[] attrIDs) 
    throws NamingException  {
    if (name.size() == 1) {
	return getAttributes(name.get(0), attrIDs);
    } else {
	DirContext ctx = getContinuationDirContext(name);
	try {
	    return ctx.getAttributes(name.getSuffix(1), attrIDs);
	} finally {
	    ctx.close();
	}
    }
}
</blockquote></pre>
<p>
The implementation of the overloads that accept string names
uses a similar pattern to that used by methods of the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><tt>Context</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    interface.
Instead of expecting a <tt>Context</tt> as the resolved object
from the internal utility <tt>getRootURLContext()</tt>,
the <tt>DirContext</tt> methods should expect a <tt>DirContext</tt>.
Here is an example of the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(java.lang.String, java.lang.String[])"><tt>getAttributes()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html#getAttributes(java.lang.String, java.lang.String[])"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    implementation.
<blockquote><pre>
public Attributes getAttributes(String name, String[] attrIds)
     throws NamingException {
	ResolveResult res = getRootURLContext(name, myEnv);
	DirContext ctx = (DirContext)res.getResolvedObj();
        try {
	    return ctx.getAttributes(res.getRemainingName(), attrIds);
        } finally {
	    ctx.close();
        }
}	
</pre></blockquote>

<a name=SUB></a>
<h4>Supporting Nonstandard Subinterfaces</h4>

Adding URL support for methods in the <tt>DirContext</tt> interface
makes sense because that interface contains methods that process names.
Adding URL support doesn't make sense for subinterfaces
whose methods have nothing to do with names.
For example, you need not provide URL support for methods
in the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/ldap/LdapContext.html"><tt>LdapContext</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/ldap/LdapContext.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    interface because none of its methods deal with names.
<p>
Another reason that URL support might not be appropriate for
some subinterfaces is that the model might not be appropriate.
For example, the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/event/EventContext.html"><tt>EventContext</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/event/EventContext.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   and
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/event/EventDirContext.html"><tt>EventDirContext</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/event/EventDirContext.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    interfaces contain methods that process names.
However, these interfaces define a model in which listener
registration is closely tied to the <tt>Context</tt> instance.
This does not fit well with URLs, which are effectively
<em>absolute names</em> that have no allegiance to a particular 
<tt>Context</tt> instance.
(These two interfaces and the event model they support are described in the
<a target="_top" href="../../beyond/event/index.html">Event Notification</a> <a target="_top" href="../../beyond/event/index.html"><img src="../../jndiimages/beyondIcon.gif" width=20 height=20 border=0 alt="(in the Beyond the Basics trail)"></a>    lesson.)
<p>
Other, possibly proprietary, subinterfaces might exist
of <tt>Context</tt> for which it makes sense to provide URL support.
For such cases, you should follow
the guidelines given earlier
<a href=context.html>in this lesson</a> and in this section
when building your URL context implementation.
Namely, the overloads that accept <tt>Name</tt> should
use <tt>getContinuationContext()</tt> (if the context implementation
supports federation), whereas the overloads that accept string
names should use a utility similar to <tt>getRootURLContext()</tt>.
<p>
Here is an example. 
<a href=src/tut/BarContext.java><tt>BarContext</tt></a> extends the
<tt>Context</tt> interface by adding two new methods: <tt>barMethod()</tt>,
which accepts a name argument, and <tt>bazMethod()</tt>,
which does not.
(A 
sample context implementation,
<a href=src/tut/BarContextImpl.java><tt>BarContextImpl</tt></a>,
which is based on the earlier 
<a href=../basics/src/tut/HierCtx.java><tt>HierCtx</tt></a> example,
is supplied with this tutorial.)
Its URL context implementation, 
<a href=src/tut/bar/barURLContext.java><tt>barURLContext</tt></a>,
implements the subinterface and extends from the earlier example
<a href=src/tut/foo/fooURLContext.java><tt>fooURLContext</tt></a>.
Here is <tt>barURLContext</tt>'s definition of its name-related
method.
<blockquote><pre>
public Object barMethod(Name name) throws NamingException {
    if (name.size() == 1) {
	return barMethod(name.get(0));
    } else {
	Context ctx = getContinuationContext(name);
	if (!(ctx instanceof tut.BarContext)) {
	    throw new NotContextException(
		"Cannot continue operation on nonBarContext");
	}
	try {
	    return ((tut.BarContext)ctx).barMethod(name.getSuffix(1));
	} finally {
	    ctx.close();
	}
    }
}

public Object barMethod(String name) throws NamingException {
    ResolveResult res = getRootURLContext(name, myEnv);
    tut.BarContext ctx = (tut.BarContext)res.getResolvedObj();
    try {
	return ctx.barMethod(res.getRemainingName());
    } finally {
	ctx.close();
    }
}
</pre></blockquote>
Methods that are not name-related,
such as <tt>bazMethod()</tt>, typically
won't be called from the URL context because of how
URL contexts are accessed (see 
<a href=initctx.html>the discussion</a> later in this lesson).
However, you still need to provide implementations for them to
satisfy Java programming language requirements.
You then need to provide a 
<a href=src/tut/bar/barURLContextFactory.java>URL context factory</a>
for this 
URL context implementation, as described
<a href=factory.html>earlier</a> in this lesson.
<p>
You also should follow the instructions for extending the
initial context described 
later <a href=initctx.html#SUB>in this lesson</a>
for supporting URLs for subinterfaces.
This last step is not necessary for the <tt>DirContext</tt>
subinterface.
This is because an initial context class,
<tt>InitialDirContext</tt>, 
already exists that directs <tt>DirContext</tt> calls 
that involve
the URL string names to the appropriate URL context implementation.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="context.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="env.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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

