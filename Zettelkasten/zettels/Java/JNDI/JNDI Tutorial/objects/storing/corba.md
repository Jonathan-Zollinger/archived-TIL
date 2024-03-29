










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>CORBA Objects</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="remote.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="../state/index.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=bottom border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/objectsHeader.gif" width=26 height=26 align=bottom border=0 alt="Java Objects and the Directory | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Storing Objects in the Directory</em></strong></a>
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
    CORBA Objects
</h2>
<p>
<blockquote>

The
<a href=http://www.corba.org>CORBA (Common Object Request Broker Architecture)</a>
defines a language-independent framework for objects to
invoke methods on each other.
Before an object can invoke a method on another object, it must
first obtain a reference to the object.
The target object can use different ways to make
its reference known to other objects.
The traditional way is to use a naming service, such as the
<a href="ftp://ftp.omg.org/pub/docs/orbos/98-10-11.pdf">Common
Object Services (COS) Name Service</a>.
Another way is to publish its object reference in
an LDAP server that supports the schema defined <A HREF="http://www.ietf.org/rfc/rfc2714.txt">RFC 2714</A>.
Using the JNDI, the code to use either of these ways
are the same. You can select the underlying naming service
or directory to use at runtime by selecting the
<a href=../../getStarted/concepts/glossary.html#IC>initial context</a>
to use.
The example shown in this section uses an LDAP directory.

<a name=EXAMPLE><h4>Binding a CORBA Object Reference</h4></a>

<blockquote>
<hr>
<strong>Before you go on:</strong>
To run this example,
you need <tt>ldapbp.jar</tt>,
as stated in the <a href=index.html#REQ>introduction of this lesson</a>.
If you are not using the
<a href=http://java.sun.com/products/jdk/1.2/>Java 2 SDK, v1.2</a> 
or higher release, then you also need to install Java IDL,
a version of which comes with the
<a href="http://java.sun.com/products/rmi-iiop/">RMI-IIOP Standard Extension</a>.
<hr>
</blockquote>
<p>
The following example first defines an interface, 
<a href=src/HelloApp.idl>HelloApp</a>
by using the Interface Description Language (IDL).
<blockquote><pre>
module HelloApp {
    interface hello
    {
        string sayHello();
    };
};
</pre></blockquote>

It then defines an implementation of this interface,
<a href=src/CorbaObj.java>helloServant</a>.
<blockquote><pre>
class helloServant extends HelloApp._helloImplBase {
    public String sayHello() {
	return "\nHello world !!\n" + new java.util.Date();
    }
}
</pre></blockquote>
Next, <a href=src/CorbaObj.java>it</a> creates an instance of
<tt>helloServant</tt> and binds it to the directory, assigning it
the name <tt>"cn=CorbaHello"</tt>.
<blockquote><pre>
// Create and initialize the ORB
ORB orb = ORB.init(args, null);

// Create the servant and register it with the ORB
helloServant helloRef = new helloServant();
orb.connect(helloRef);

// Let service provider use the ORB
env.put("java.naming.corba.orb", orb);

// Create the initial context
DirContext ctx = new InitialDirContext(env);

// Bind the object to the directory
ctx.bind("cn=CorbaHello", helloRef);
</pre></blockquote>

<p>
After the object has been bound in the directory, an application can look
it up by using the following code.
<blockquote><pre>
// Look up and narrow the object
HelloApp.hello h2 = HelloApp.helloHelper.narrow(
	(org.omg.CORBA.Object)ctx.lookup("cn=CorbaHello"));

// Invoke the method
System.out.println(h2.sayHello());
</blockquote></pre>


<p>
To run this example, you must do the following.
<ol>
<li>Run <tt>idltojava</tt> with <tt>HelloApp.idl</tt> as the argument to
produce the stubs for the CORBA object:
<blockquote><pre>
# idltojava HelloApp
</blockquote></pre>
This generates a directory <tt>HelloApp</tt> that contains <tt>.java</tt> and
<tt>.class</tt> files.
<li>Compile this example:
<blockquote><pre>
# javac CorbaObj.java
</pre></blockquote>
<li>Run the example:
<blockquote><pre>
# java CorbaObj
</pre></blockquote>
If you want the <tt>helloServant</tt> created by the example to
hang around for other CORBA clients to access, then run the program
with the <tt>-wait</tt> parameter:
<blockquote><pre>
# java CorbaObj -wait
</pre></blockquote>
</ol>
When you later look up this object from the directory, the directory
will return the bound <tt>helloServant</tt> CORBA object.
See the 
<a target="_top" href="../reading/lookup.html">Reading Objects from the Directory</a> <a href="../reading/lookup.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>    lesson for an example.


<P ALIGN="CENTER">
<IMG SRC="../../jndiimages/shoeline2.GIF" ALIGN="BOTTOM" BORDER="0" WIDTH="202"
    HEIGHT="25" NATURALSIZEFLAG="3">
<IMG SRC="../../jndiimages/shoeline2.GIF" ALIGN="BOTTOM" BORDER="0" WIDTH="202"
    HEIGHT="25" NATURALSIZEFLAG="3">
</P>

<strong>Storing Objects in the Directory: End of Lesson</strong>
<p>
What's next? 
Now you can:
<ul>
<li> <a href=../state/index.html>Continue</a> on in this trail
     lesson to learn how to bind arbitrary types of objects.

<li> Go to the 
<a target="_top" href="../reading/index.html">Reading Objects from the Directory</a> <a href="../reading/index.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>     lesson to learn how to read objects from the directory.

<li> Go to the 
<a target="_top" href="../representation/index.html">Representation in the Directory</a> <a href="../representation/index.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>     lesson to read about the physical representation of
Java objects in the directory.

</ul>

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="remote.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="../state/index.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
href="../../trailmap.html"><img src="../../images/WayUpArrow.gif" width=26 height=26 align=top border=0 alt="Trail Map | "></a><a
href="../index.html"><img src="../../jndiimages/objectsHeader.gif" width=26 height=26 align=top border=0 alt="Java Objects and the Directory | "></a>
</td>
<td align=right>
<a href="index.html"><strong><em>Storing Objects in the Directory</em></strong></a>
</td>
</tr>
</table>
</body>
</html>
