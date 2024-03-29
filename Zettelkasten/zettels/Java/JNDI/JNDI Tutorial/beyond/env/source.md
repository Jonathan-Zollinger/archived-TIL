










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Specifying Environment Properties</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="overview.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="context.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Specifying Environment Properties
</h2>
<p>
<blockquote>

You can specify environment properties to the JNDI by using
the environment parameter to the
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html#InitialContext(java.util.Hashtable)"><tt>InitialContext</tt> constructor</a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/InitialContext.html#InitialContext(java.util.Hashtable)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>   and
<a href=#APPRES>application resource files</a>. 
Several JNDI standard environment properties could be specified also by
using <a href=#SYS>system properties</a> and
<a href=#APPLET>applet parameters</a>, 
as described later in this section.


<a name=APPRES><h4>Application Resource Files</h4></a>

To simplify the task of setting up the environment required by a JNDI
application, you may distribute 
<em><a href=../../getStarted/concepts/glossary.html#APPRES>application resource files</a></em>
along with application components and service providers.
An application resource file has the name <tt>jndi.properties</tt>.
It contains a list of key/value pairs presented in the properties file format 
(see <tt>java.util.Properties</tt>). 
The key is the name of the property
(for example, <tt>java.naming.factory.object</tt>) and the value is a string 
in the format defined for that property. 
<p>
Here is an example of an application
resource file.

<blockquote><pre>
java.naming.factory.object=com.sun.jndi.ldap.AttrsToCorba:com.wiz.from.Person
java.naming.factory.state=com.sun.jndi.ldap.CorbaToAttrs:com.wiz.from.Person
java.naming.factory.control=com.sun.jndi.ldap.ResponseControlFactory
java.naming.factory.initial=com.sun.jndi.ldap.LdapCtxFactory
java.naming.provider.url=ldap://localhost:389/o=jnditutorial
com.sun.jndi.ldap.netscape.schemaBugs=true
</pre></blockquote>

Notice that no restrictions apply regarding
the type of environment
property that you can have in this file.

<p>
The JNDI automatically reads the application resource files
from all components in the applications' classpaths and
<em>JAVA_HOME</em><tt>/lib/jndi.properties</tt>, where <em>JAVA_HOME</em>
is the file directory that contains your JRE (Java Runtime Environment).
The JNDI then makes the properties from these files 
available to the service providers and other components
that need to use them.
Therefore these files should be considered <em>world-readable</em>
and should not contain sensitive information, such as clear-text passwords.

<blockquote>
<hr>
<strong>Note:</strong> 
Except for <em>JAVA_HOME</em><tt>/lib/jndi.properties</tt>,
application resource files are supported only when you use the
<a href="http://java.sun.com/products/jdk/1.2/">Java 2 platform</a>.
If you use the JDK 1.1 software, then you can see only
<em>JAVA_HOME</em><tt>/lib/jndi.properties</tt>.
<hr>
</blockquote>

For example, following is <a href=src/AppList.java>a program</a> that lists a context
without specifying any environment properties in the <tt>InitialContext</tt>
constructor.
<blockquote><pre>
InitialContext ctx = new InitialContext();
NamingEnumeration enum = ctx.list("");
</pre></blockquote>
If you run this program with the 
<a href=src/jndi.properties><tt>jndi.properties</tt></a> file shown previously, then
it will list the contents of the <tt>o=jnditutorial</tt> entry
on the specified LDAP server.
<p>
The use of application resource files to specify any JNDI environment properties
allows the JNDI to be configured with minimal programmatic setup.
By using the 
<em>JAVA_HOME</em><tt>/lib/jndi.properties</tt> file,
you can also configure the JNDI for all applications
and applets that use the same Java interpreter.
<p>
If you use application resource files, then you must remember to grant
your applet or application permission to read all of the application
resource files.

<a name=SYS><h4>System Properties</h4></a>

A <em>system property</em> is a key/value pair that the Java
runtime defines to describe the user, system environment, and Java system.
The runtime defines and uses a set of default system properties.
Other properties can be made available to a Java program 
via the <tt>-D</tt> command line option to the Java interpreter.
For example, running the interpreter as follows
<blockquote><pre>
# java -Dmyenviron=abc Main
</pre></blockquote>
adds the property <tt>myenviron</tt> with the value <tt>abc</tt> to the
list of system properties visible to the program <tt>Main</tt>.
The <tt>java.lang.System</tt> class contains static methods
for reading and updating system properties. The ability
to read or update any system property is controlled by the security
policy of the Java runtime system.
<p>
The JNDI reads the following standard JNDI properties from the system properties:
<blockquote><pre>
java.naming.factory.initial
java.naming.factory.object
java.naming.factory.state
java.naming.factory.control
java.naming.factory.url.pkgs
java.naming.provider.url
java.naming.dns.url	
</blockquote></pre>

When set as system properties, these
environment properties affect the contexts of all applications or applets
(if the applet is allowed permission to read these properties).
<p>
Using the same program in the previous application resource file example, specify the initial context factory to use by 
giving the initial context to use on the command line.
Here are two examples.
<blockquote><pre>
# java -Djava.naming.factory.initial=com.sun.jndi.ldap.LdapCtxFactory \
      -Djava.naming.provider.url=ldap://localhost:389/o=jnditutorial \
      List
# java -Djava.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory \
      -Djava.naming.provider.url=file:/tmp \
      List 
</pre></blockquote>
The first example uses LDAP, and the second one uses the file system.

<p>
The use of system properties to specify standard JNDI environment properties
allows the JNDI to be configured with minimal programmatic setup.
However, they are probably convenient to use only from scripts.
This is because
items with long property names must be specified on the command line.
Also, applets generally do not have permission to read arbitrary
system properties and must be explicitly granted permission to do so.

<a name=APPLET><h4>Applet Parameters</h4></a>

You can pass parameters to an applet by using simple key/value pairs.
They are specified in the HTML file that references the applet.
How you specify them depends on the applet context.
For example, if the applet is referenced from an <tt>applet</tt>,
then you specify the parameters by using the <tt>param</tt> tag.
Here is <a href=src/appletlist.html>an example</a>.
<blockquote><pre>
&lt;param 
name=java.naming.factory.initial
value=com.sun.jndi.ldap.LdapCtxFactory&gt;

&lt;param
name=java.naming.provider.url
value=ldap://localhost:389/o=jnditutorial&gt;
</pre></blockquote>
If the applet is referenced from the 
<a href=http://java.sun.com/products/plugin/>Java Plug-in</a>,
then you specify its parameters
by using key/value pairs. 
Here is <a href=src/pluginlist.html>an example</a>.
<blockquote><pre>
java.naming.provider.url="ldap://localhost:389/o=jnditutorial"
java.naming.factory.initial="com.sun.jndi.ldap.LdapCtxFactory"
</pre></blockquote>
<p>
For the JNDI to access an applet's parameters, you must
set the 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#APPLET><tt>Context.APPLET</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#APPLET><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    (<tt>"java.naming.applet"</tt>) environment property.
The JNDI reads the following standard JNDI properties from the applet parameters:
<blockquote><pre>
java.naming.factory.initial
java.naming.factory.object
java.naming.factory.state
java.naming.factory.control
java.naming.factory.url.pkgs
java.naming.provider.url
java.naming.dns.url	
</blockquote></pre>
<p>
Here is <a href=src/AppletList.java>an example</a> that adds
a single property (<tt>"java.naming.applet"</tt>) to the environment.
<blockquote><pre>
// Put this applet instance into the environment
Hashtable env = new Hashtable();
env.put(Context.APPLET, this);

// Pass the environment to the initial context constructor
Context ctx = new InitialContext(env);

// List the objects 
NamingEnumeration enum = ctx.list(target);
while (enum.hasMore()) {
     out.println(enum.next());
}
ctx.close();
</pre></blockquote>

The JNDI then obtains the necessary environment properties from the
applet parameters (shown previously).
<p>
This use of applet parameters to specify standard JNDI environment properties
allows the JNDI to be configured in the same way that an applet
typically performs configuration for other subsystems or components.
System properties and application resource files
are not good mechanisms for applets to depend on.
This is because applets typically cannot read system properties or arbitrary
files (including <tt>jndi.properties</tt>).


</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="overview.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="context.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
