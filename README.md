# TIL 
<ul>

[by making this an unordered list w/ no items, this is a work-around for indenting this section.]: #
##### Today I Learned &nbsp;&nbsp;&nbsp;&nbsp;| &nbsp;&nbsp;&nbsp;&nbsp; Zettelkasen style notes
</ul>

# Topics
- [eDirectory](#eDirectory)
- [Firefox](#Firefox)
- [Firewall](#Firewall)
- [IG Install](#IG-Installation)
- [Postgres](#Postgres)

## eDirectory
<ul>
<details><summary>Download</summary>

| Version | Download|     |
|---------|---------|-----|
| 9.2.1   | [Windows](http://prvbuilder02.provo.novell.com/artifacts/edir/921/eDirectory_921_Windows_x86_64.exe) | [Linux](http://prvbuilder02.provo.novell.com/artifacts/edir/921/eDirectory_921_Linux_x86_64.tar.gz) |
| 9.2.5   | [Windows](http://prvbuilder02.provo.novell.com/artifacts/edir/925/eDirectory_925_Windows_x86_64.exe) | [Linux](http://prvbuilder02.provo.novell.com/artifacts/edir/925/eDirectory_925_Linux_x86_64.tar.gz) |

> :bulb: More eDir downloads (including some md5 versions) are available from the [provo's artifactory](http://prvbuilder02.provo.novell.com/artifacts/edir/).

</details>
</ul>

*****
## Firefox
<ul>
<details><summary>Allow HTTP Sites</summary>

1. Open [`about:config`](/images/Firefox%3Babout-config.png) in Firefox. 
    - ##### *You may be prompted to accept the risk of changing firefox configuration.* 
2. [Search for and set](/images/Firefox%3Babout-config%3Bchanging_properties.gif) the following properties to `false` 
```
network.cookie.sameSite.laxByDefault:  false
network.cookie.sameSite.noneRequiresSecure: false
network.cookie.sameSite.schemeful:  false
```
>  :memo: **Note:** <br />Properties like `netw...noneRequiresSecure` may not have an assignment when you go to make your edits. In this case add the property to Firefox's configuration by selecting `boolean` as the property type and selecting the **_+_** button before setting this property to false
3. Restart Firefox
    - ##### *You can restart firefox by hitting `ctrl + F5`*

</details>
</ul>

*****
## Firewall

<ul>
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
</ul>

*****
## IG Installation
<ul>
<details><summary>Required Software</summary>

*****

### <font color="red"><ins>[Read the documentation first!](https://www.microfocus.com/documentation/identity-governance/3.7/requirements/requirements.html#b1a4zqh1)</ins></font>
> :warning: **See [Documentation]((https://www.microfocus.com/documentation/identity-governance/3.7/requirements/requirements.html#b1a4zqh1)) for all current details.** <br>This page is meant to be used as a quick reference.<br>This page may be out of date and is not intended to replace IG's documentation.<br>

| OS      | Release                                                              |
|---------|----------------------------------------------------------------------|
| Red Hat | <ul><li>8.3 (64-bit)</li><li>Later patched versions of 8.x</li></ul> |

| LDAP      | Release |
|---        |---      |
|[eDirectory](#eDirectory) | <ul><li>9.2</li><li>Later patched versions of 9.<font color="red">2</font>.x</li></ul> |
</details>

<details><summary>Silent Install</summary>

### <font color="red"><ins>[Read the documentation first!](https://www.microfocus.com/documentation/identity-governance/3.7/install-guide/b19v78jo.html)</ins></font>
> :warning: **See [Documentation]((https://www.microfocus.com/documentation/identity-governance/3.7/requirements/requirements.html#b1a4zqh1)) for all current details.** <br>This page is meant to be used as a quick reference.<br>This page may be out of date and is not intended to replace IG's documentation.<br>
*****
</details>
</ul>

*****

## Postgres
<ul>
<details><summary>Add or change a password</summary>

### **PSQL 11**
To add or change a password, log in as the database admin (default is postgres). Supplying the password can either be done in line using the [ALTER ROLE](https://www.postgresql.org/docs/11/sql-alterrole.html) command. 
    
- Supplying the password in line for the batman user would be: 
<ul>

```SQL
ALTER ROLE batman WITH PASSWORD 'Dark Knight';
```

</ul>
- or, more useful for actual use:
<ul>
    
```SQL
ALTER ROLE postgres WITH PASSWORD 'postgres';
```
</ul>

The password for the database admin can be obfuscated when initializing the database. This is done by providing a file containing the password and referencing that file with the `--pwfile` flag along with specifying the appropriate security setting with the [`-A md5`](https://www.postgresql.org/docs/11/pgcrypto.html) flag. 
<ul>

 ```SQL
 /usr/lib/postgresql11/bin/initdb -D /usr/local/pgsql/data --pwfile /usr/local/pgsql/postgres-password.txt  -A md5
 ```
</ul>
    
##### [PSQL Documentation](https://www.postgresql.org/docs/9.0/sql-alterrole.html)
</details>
</ul>

*****
