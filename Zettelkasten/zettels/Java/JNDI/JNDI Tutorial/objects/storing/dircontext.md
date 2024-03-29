










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Objects with Attributes</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="reference.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="remote.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Objects with Attributes
</h2>
<p>
<blockquote>

If the object that you're attempting to bind is
neither <tt>Serializable</tt> nor <tt>Referenceable</tt>,
then you can still bind it if it has attributes, provided
that binding
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html><tt>DirContext</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/directory/DirContext.html><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     objects is a feature supported by the underlying service provider.
Sun's LDAP service provider supports this feature.

<h4>Interoperability</h4>
Binding <tt>DirContext</tt> objects
is especially useful for interoperability with non-Java
applications. An object is represented by a set of attributes, which
can be read and used by non-Java applications from the directory.
The same attributes can also be read and interpreted by a JNDI service provider,
which, in conjunction with an object factory, converts them into a Java
object.

<p>
For example, an object might have, as some of its attribute values,
URLs that the JNDI service could use to generate an instance of a Java 
object that the application could use.
These same URLs could be used also by non-Java applications.

<a name=EXAMPLE><h4>Binding an Object by Using Its Attributes</h4></a>


The following example shows a <a href=src/Drink.java><tt>Drink</tt></a> 
class that implements
the <tt>DirContext</tt> interface. 
Most <tt>DirContext</tt> methods are not used by this example
and so simply throw an
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/OperationNotSupportedException.html"><tt>OperationNotSupportedException</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/OperationNotSupportedException.html"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>.
<p>
<a name=DRINK></a>
<blockquote>
<pre>
public class Drink implements DirContext {
    String type;
    Attributes myAttrs;
    
    public Drink(String d) {
	type = d;
	myAttrs = new BasicAttributes(true);  // Case ignore
	Attribute oc = new BasicAttribute("objectclass");
	oc.add("extensibleObject");
	oc.add("top");

	myAttrs.put(oc);
	myAttrs.put("drinkType", d);
    }
    
    public Attributes getAttributes(String name) throws NamingException {
	if (! name.equals("")) {
	    throw new NameNotFoundException();
	}
	return (Attributes)myAttrs.clone();
    }

    public String toString() {
	return type;
    }
...
}
</pre>
</blockquote>
<p>
The <tt>Drink</tt> class contains the 
<tt>"objectclass"</tt> and <tt>"drinkType"</tt>
attributes. The <tt>"objectclass"</tt> attribute contains two values: <tt>"top"</tt>
and <tt>"extensibleObject"</tt>. 
The <tt>"drinkType"</tt> attribute is set by using the string passed
to the <tt>Drink</tt> constructor.
For example, if the instance was created by using <tt>new Drink("water")</tt>,
then its <tt>"drinkType"</tt> attribute will have the value 
<tt>"water"</tt>.
<p>
<a href=src/DirObj.java>The following example</a>
creates an instance of <tt>Drink</tt> and invokes
<a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#bind(javax.naming.Name, java.lang.Object)"><tt>Context.bind()</tt></a><a target="_top" href="http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#bind(javax.naming.Name, java.lang.Object)"><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     to add it to the directory.
<blockquote>
<pre>
// Create the object to be bound
Drink dr = new Drink("water");

// Perform the bind
ctx.bind("cn=favDrink", dr);
</pre>
</blockquote>
When the object is bound, its attributes are extracted and stored in
the directory.
<p>

When that object is subsequently looked up from the directory,
its corresponding object factory will be used to return
an instance of the object. The object factory is identified
by the 
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#OBJECT_FACTORIES><tt>Context.OBJECT_FACTORIES</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#OBJECT_FACTORIES><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>     environment property when
the initial context for reading the object is created.
Conversion details are described in the
<a target="_top" href="../factory/index.html">Object Factories</a> <a href="../factory/index.html"><img src="../../jndiimages/objectsIcon.gif" width=20 height=20 border=0 alt="(in the Java Objects and the Directory trail)"></a>     lesson.
<blockquote>
<pre>
Hashtable env = ...;
// Add property so that the object factory can be found
env.put(Context.OBJECT_FACTORIES, "DrinkFactory");

// Create the initial context
DirContext ctx = new InitialDirContext(env);

// Read back the object
Drink dr2 = (Drink) ctx.lookup("cn=favDrink");
System.out.println(dr2);
</pre>
</blockquote>
This produces the following output, <tt>"water"</tt>, produced by
<a href=#DRINK><tt>Drink.toString()</tt></a>.
<blockquote>
<pre>
# java DirObj
water
</pre>
</blockquote>
<p>
From the perspective of the application using the JNDI, 
it is dealing only
with <tt>bind()</tt> and <tt>lookup()</tt>.
The service provider takes care of getting the attributes from the
object and converting them to/from the actual object itself.
<p>
Note that you can store a <tt>DirContext</tt> object in the directory
only if the underlying service provider supports that.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="reference.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="remote.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
