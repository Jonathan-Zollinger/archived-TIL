










<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<!--NewPage-->
<html>
<head>
<title>Authentication Mechanisms</title>
</head>
<body BGCOLOR="#ffffff">
<table width="100%">
<tr>
<td align=left>
<a href="ldap.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=bottom border=0 alt="Previous | "></a><a
href="anonymous.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=bottom border=0 alt="Next | "></a><a
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
    Authentication Mechanisms
</h2>
<p>
<blockquote>

Different versions of the LDAP 
support different types of authentication.
The LDAP v2 defines three types of authentication: anonymous, simple
(clear-text password), and Kerberos v4.
<p>
The LDAP v3 supports anonymous, simple, and SASL authentication.
SASL is the Simple Authentication
and Security Layer (<A HREF="http://www.ietf.org/rfc/rfc2222.txt">RFC 2222</A>). 
It specifies a challenge-response protocol in which data is
exchanged between the client and the server for the purposes of
authentication and establishment of a security layer on which to
carry out subsequent communication.
By using SASL, the LDAP can support any type of
authentication agreed upon by the LDAP client and server.
<p>
This lesson contains descriptions of how to authenticate by using 
<a href=anonymous.html>anonymous</a>, <a href=simple.html>simple</a>,
and <a href=sasl.html>SASL</a> authentication.

<h4>Specifying the Authentication Mechanism</h4>

The authentication mechanism is specified by using the
<a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#SECURITY_AUTHENTICATION><tt>Context.SECURITY_AUTHENTICATION</tt></a><a target="_top" href=http://java.sun.com/j2se/1.3/docs/api/javax/naming/Context.html#SECURITY_AUTHENTICATION><img src="../../images/apiIcon.gif" width=20 height=20 border=0 alt="(in the API reference documentation)"></a>    environment property.
The property may have one of the following values.
<p>
<TABLE>
<TR>
<TD><em>sasl_mech</em></TD>

<TD> 
A space-separated list of SASL mechanism names.
Use one of the SASL mechanisms listed (e.g.,
<tt>"CRAM-MD5"</tt> means to use the CRAM-MD5 SASL mechanism described in
<A HREF="http://www.ietf.org/rfc/rfc2195.txt">RFC 2195</A>).
</TD>
</TR>

<TR>
<TD><TT>none</TT></TD>

<TD>Use no authentication (anonymous)</TD>
</TR>

<TR>
<TD><TT>simple</TT></TD>

<TD>Use weak authentication (clear-text password)</TD>
</TR>

</TABLE>

<h4>The Default Mechanism</h4>

If the client does not specify any authentication environment properties, 
then the default authentication mechanism is <tt>"none"</tt>.
The client will then be treated as an anonymous client.
<p>
If the client specifies authentication information without explicitly specifying
the <tt>Context.SECURITY_AUTHENTICATION</tt> property, then the default
authentication mechanism is <tt>"simple"</tt>.

</blockquote>
<p>
<hr size=4>
<p> 
<table width="100%">
<tr>
<td align=left>
<a href="ldap.html"><img src="../../images/PreviousArrow.gif" width=26 height=26 align=top border=0 alt="Previous | "></a><a
href="anonymous.html"><img src="../../images/NextArrow.gif" width=26 height=26 align=top border=0 alt="Next | "></a><a
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
