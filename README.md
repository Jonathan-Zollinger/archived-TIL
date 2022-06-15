# TIL
###### Zettelkasten style notes

*****
## Firefox
<details><summary>Allow HTTP Sites</summary>

1. Open [`about:config`](/images/Firefox%3Babout-config.png) in Firefox. 
    - ##### *You may be prompted to accept the risk of changing firefox configuration.* 
2. [Search for and set](/images/Firefox%3Babout-config%3Bchanging_properties.gif) the following properties to `false` 
```
network.cookie.sameSite.laxByDefault:  false
network.cookie.sameSite.noneRequiresSecure:  false
network.cookie.sameSite.schemeful:  false
```
> **_TIP_** <br />Properties like `netw...noneRequiresSecure` may not have an assignment when you go to make your edits. In this case add the property to Firefox's configuration by selecting `boolean` as the property type and selecting the **_+_** button before setting this property to false
3. Restart Firefox
    - ##### *You can restart firefox by hitting `ctrl + F5`*

</details>


<a name="Firewall"></a>
*****
## Firewall
<details><summary>Open a port</summary>

### **RHEL 7 & 8**

Use the `firewall-cmd` interface to modify the firewall via the bash terminal. The following code block will allow tomcat webapps through the firewall, if using tomcat's default port.

```bash
# Open port 8080
firewall-cmd --zone=public --permanent --add-port=8080/udp
# Firewall daemon needs to restart in order to put changes into effect.
firewall-cmd --reload
```
</details>

## Postgres
<details><summary>Add or change a password</summary>

### **PSQL 11**
To add or change a password, log in as the database admin (default is postgres). Supplying the password can either be done in line using the [ALTER ROLE](https://www.postgresql.org/docs/11/sql-alterrole.html) command. 
    
- Supplying the password in line for the batman user would be: 
<ul>

```SQL
ALTER ROLE batman WITH PASSWORD 'Dark Knight';
```
</ul>

- The password for the database admin can be obfuscated when initializing the database. This is done by providing a file containing the password and referencing that file with the `--pwfile` flag along with specifying the appropriate security setting with the [`-A md5`](https://www.postgresql.org/docs/11/pgcrypto.html) flag. 
<ul>

 ```SQL
 /usr/lib/postgresql11/bin/initdb -D /usr/local/pgsql/data --pwfile /usr/local/pgsql/postgres-password.txt  -A md5
 ```
</ul>
    
##### [PSQL Documentation](https://www.postgresql.org/docs/9.0/sql-alterrole.html)
</details>


