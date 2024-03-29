










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Customizing a Service Provider</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="update.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="../event/index.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/beyondHeader.gif" width=26 height=26 align=bottom border=0 alt="Beyond the Basics | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Environment Properties</em></strong></a>
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
    Customizing a Service Provider
</h2>
<p>
<blockquote>

Environment properties allow an application and its
user to customize the usage of the JNDI.
You can customize a particular service provider by using a
<em><a href=../../getStarted/concepts/glossary.html#PROVRES>provider resource file</a></em>.
Like an application resource file, 
a provider resource file contains key/value pairs presented in
the properties file format (see <tt>java.util.Properties</tt>).
<p>
A provider resource file has the name
<blockquote>
[<em>prefix</em>/]<tt>jndiprovider.properties</tt>
</blockquote>
where <em>prefix</em> is the package name of the provider's context
implementation, with each period character converted to a 
forward slash character.
For example, suppose that the context implementation's class name is
<tt>com.sun.jndi.ldap.LdapCtx</tt>; its provider resource filename
would be <tt>"com/sun/jndi/ldap/jndiprovider.properties"</tt>.
Whereas a single application can use multiple
application resource files, there is atmost one provider resource
file per service provider. In fact, the provider resource file is typically
bundled with the service provider and is loaded using the same class loader
that loads the service provider.

<h4>Usage</h4>
The provider resource file serves two purposes.
First, it allows the service provider to be built without
being hardwired to components, such as object and state factories,
and at the same times allows some defaults to be specified.
<p>
Second, it can be used as a deployment mechanism.
For example, suppose that you get an LDAP service provider from a vendor.
You can customize that provider by adding, for example, some object
and state factories suitable for your enterprise, such as
factories for accounting and employee objects.
When that LDAP provider is subsequently used by your applications
within your enterprise, those factories will be used automatically
without the application's or user's having to specify the relevant properties
via application resource files, system properties, applet parameters,
or initial context environment parameters.
<p>
The degree to which you can manipulate a service provider's
provider resource file depends on how the provider has been packaged.
For example, if the provider is packaged as a JAR, then
you can supply an updated provider resource file for the provider
by first extracting the contents of the JAR and then repackaging 
it with the updated provider resource file.
Note that this procedure is not recommended for
the service providers that are packaged in the 
<a href=http://java.sun.com/j2se/1.3/docs/guide/jndi/>Java 2 SDK/JRE,
Standard Edition, v1.3</a>.
For those service providers, you should not try to update
their provider resource files. Instead, use application resource files
as described previously in <a href=source.html#APPRES>this lesson</a>.

<h4>Affected Properties</h4>
Although a provider resource file can contain any property, the
JNDI looks only for the following from a provider resource file:
<blockquote><pre>
java.naming.factory.object
java.naming.factory.state
java.naming.factory.control
java.naming.factory.url.pkgs
</pre></blockquote>
Unlike the contents of an application resource file, the contents
of a provider resource file are not added to the environment.
Instead, those contents augment the value of 
the environment supplied to the following methods.
<ul>
<li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/NamingManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><tt>NamingManager.getObjectInstance(Object, Name, Context, Hashtable)</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/NamingManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirectoryManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable, javax.naming.directory.Attributes)"><tt>DirectoryManager.getObjectInstance(Object, Name, Context, Hashtable, Attributes)</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirectoryManager.html#getObjectInstance(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/NamingManager.html#getStateToBind(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><tt>NamingManager.getStateToBind(Object, Name, Context, Hashtable)</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/NamingManager.html#getStateToBind(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirectoryManager.html#getStateToBind(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable, javax.naming.directory.Attributes)"><tt>DirectoryManager.getStateToBind(Object, Name, Context, Hashtable, Attributes)</tt> </a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/spi/DirectoryManager.html#getStateToBind(java.lang.Object, javax.naming.Name, javax.naming.Context, java.util.Hashtable, javax.naming.directory.Attributes)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a><li>
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/ldap/ControlFactory.html#getControlInstance(javax.naming.ldap.Control, javax.naming.Context, java.util.Hashtable)"><tt>ControlFactory.getControlInstance(Control, Context, Hashtable)</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/ldap/ControlFactory.html#getControlInstance(javax.naming.ldap.Control, javax.naming.Context, java.util.Hashtable)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a></ul>
When a service provider calls one of these methods, it supplies
an instance of the <tt>Context</tt> from which the method is being called
and the context's environment.
The JNDI uses the context's class loader to find the provider resource file
and appends the value of the property (relevant for the method) to
the same property found in the environment. It then uses the resulting property as the
ordered list of factories to search.
<p>
For example, suppose that the LDAP service provider, implemented
by using the class <tt>com.sun.jndi.ldap.LdapCtx</tt>, calls
<tt>DirectoryManager.getObjectInstance()</tt>.
The JNDI will find the value of the
<tt>"java.naming.factory.object"</tt> property from the
<tt>com/sun/jndi/ldap/jndiprovider.properties</tt> file
and append that to the value of the
<tt>"java.naming.factory.object"</tt> property found in the environment parameter
(<tt>Hashtable</tt>).
The JNDI will then use this list of factories to find an object
factory that returns a non-<tt>null</tt> answer.
<p>
A service provider is free to access the provider resource file
for other properties, but that behavior is provider-specific.

<P ALIGN="CENTER">
<IMG SRC="../../jndiimages/shoeline2.GIF" ALIGN="BOTTOM" BORDER="0" WIDTH="202"
    HEIGHT="25" NATURALSIZEFLAG="3">
<IMG SRC="../../jndiimages/shoeline2.GIF" ALIGN="BOTTOM" BORDER="0" WIDTH="202"
    HEIGHT="25" NATURALSIZEFLAG="3">
</P>
<strong>Environment Properties: End of Lesson</strong>
<p>
What's next? 
Now you can:
<ul>
<li> <a href=../event/index.html>Continue</a> on in this trail
to learn about event notification.

<li> Go to the 
<a target="_top" href="../url/index.html">URLs</a> <a target="_top" href="../url/index.html"><img src="../../jndiimages/beyondIcon.gif" width=20 height=20 border=0 alt="(in the Beyond the Basics trail)"></a>     lesson to learn about the relationship between URLs and the JNDI.

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
<a href="update.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="../event/index.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/beyondHeader.gif" width=26 height=26 align=top border=0 alt="Beyond the Basics | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Environment Properties</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
