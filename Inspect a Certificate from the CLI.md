#certificate #self-signed #edirectory #cli

Using openssl we can retrieve a [certificate](obsidian://open?vault=TIL&file=Basic%20Certificate%20Example) that is provided in response to an SSL handshake
```bash
openssl s_client -connect 127.0.0.1:1636
```
<details><summary>&nbsp;openssl (base program)</summary><ul>

snippets from openssl's man pages:<br>

> The openssl program is a command line program for using the various cryptography functions of OpenSSL's crypto library from the shell.<br>Detailed documentation and use cases for most standard subcommands are available (e.g., openssl-x509(1)). The subcommand openssl-list(1) may be used to list subcommands.
</ul></details>
<details><summary>&nbsp;s_client (command)</summary><ul>
Excerpt from openssl's man pages:<br>

   > s_client: <br>This implements a generic SSL/TLS client which can establish a transparent connection to a remote server speaking SSL/TLS. It's intended for testing purposes only and provides only rudimentary interface functionality but internally uses mostly all functionality of the OpenSSL ssl library.
</ul></details>
<details><summary>&nbsp;127.0.0.1 (remote server argument) </summary><ul>
Endpoint to which the openssl command will send its request. In this case, the endpoint is a service running locally.<br><br>

<details open="open"><summary>&nbsp;1636 (remote port) </summary>
The port on which the responding service is listening. In this example, an eDirectory container is listening on port 1636 for any secure LDAP requests. 
</details>

</ul></details>
``