/* 
 * @(#)RefObj.java	1.3 99/09/21
 * 
 * Copyright 1997, 1998, 1999 Sun Microsystems, Inc. All Rights
 * Reserved.
 * 
 * Sun grants you ("Licensee") a non-exclusive, royalty free,
 * license to use, modify and redistribute this software in source and
 * binary code form, provided that i) this copyright notice and license
 * appear on all copies of the software; and ii) Licensee does not 
 * utilize the software in a manner which is disparaging to Sun.
 *
 * This software is provided "AS IS," without a warranty of any
 * kind. ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND
 * WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE 
 * HEREBY EXCLUDED.  SUN AND ITS LICENSORS SHALL NOT BE LIABLE 
 * FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, 
 * MODIFYING OR DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN 
 * NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST 
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL,
 * CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER 
 * CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT 
 * OF THE USE OF OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS 
 * BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 * This software is not designed or intended for use in on-line
 * control of aircraft, air traffic, aircraft navigation or aircraft
 * communications; or in the design, construction, operation or
 * maintenance of any nuclear facility. Licensee represents and warrants
 * that it will not use or redistribute the Software for such purposes.  
 */

import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
  * Demonstrates how to bind a Referenceable object to a context
  * using a different encoding character.
  *
  * Need schema checking to be turned off on server (unless you add
  * a fruit objectclass to the schema).
  *
  * usage: java RefObj
  */

class RefObj {
    public static void main(String[] args) {

	// Set up environment for creating initial context
	Hashtable env = new Hashtable(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	// Ask to use ':' as the encoding character
	env.put("java.naming.ldap.ref.separator", ":");

	try {
	    // Create the initial context
	    DirContext ctx = new InitialDirContext(env);

	    // Create object to be bound
	    Fruit fruit = new Fruit("orange");

	    // Perform bind
	    ctx.rebind("cn=favorite", fruit);

	    // Read object back
	    Fruit f2 = (Fruit) ctx.lookup("cn=favorite");
	    System.out.println(f2);

	    // Read attributes to see encoding
	    Attributes attrs = ctx.getAttributes("cn=favorite");
	    System.out.println(attrs);

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    System.out.println("Operation failed: " + e);
	}
    }
}
