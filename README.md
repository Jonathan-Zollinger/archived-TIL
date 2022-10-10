# TIL 
<ul>

[by making this an unordered list w/ no items, this is a work-around for indenting this section.]: #
##### Today I Learned &nbsp;&nbsp;&nbsp;&nbsp;| &nbsp;&nbsp;&nbsp;&nbsp; Zettelkasten style notes
</ul>

# Topics
- [eDirectory](#eDirectory)
- [Firefox](#Firefox)
- [Firewall](#Firewall)
- [Git](#Git)
- [IG Install](#IG-Installation)
- [InstallAnywhere](#InstallAnywhere)
- [Maven](#Maven)
- [Postgres](#Postgres)
- [SSH](#SSH)
- [Wget](#Wget)

## eDirectory
<ul>
<details><summary>Download</summary>

| Version | Download|     | Documentation |
|---------|---------|-----|---------------|
| 9.2.1   | [Windows](http://prvbuilder02.provo.novell.com/artifacts/edir/921/eDirectory_921_Windows_x86_64.exe) | [Linux](http://prvbuilder02.provo.novell.com/artifacts/edir/921/eDirectory_921_Linux_x86_64.tar.gz) | [Release Notes](https://www.netiq.com/documentation/edirectory-92/edirectory921_releasenotes/data/edirectory921_releasenotes.html)| 
| 9.2.5   | [Windows](http://prvbuilder02.provo.novell.com/artifacts/edir/925/eDirectory_925_Windows_x86_64.exe) | [Linux](http://prvbuilder02.provo.novell.com/artifacts/edir/925/eDirectory_925_Linux_x86_64.tar.gz) | [Release Notes](https://www.netiq.com/documentation/edirectory-92/edirectory925_releasenotes/data/edirectory925_releasenotes.html) | 

> :bulb: More eDir downloads (including some md5 versions) are available from [provo's artifactory](http://prvbuilder02.provo.novell.com/artifacts/edir/). Install and admin guides can be found in [eDir's doc suite](https://www.netiq.com/documentation/edirectory-92/)

<br>
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

<br>
</details>
</ul>

*****
## Firewall

<ul>
<details><summary>List open ports</summary>

##### There's more than one way to skin a cat. 

### Firewallcmd

```bash
firewall-cmd --list-ports    
```

```bash
firewall-cmd --list-all-zones    
```
[Docs](https://firewalld.org/documentation/man-pages/firewall-cmd.html)
<br>
</details>
</ul>

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
<br>
</details>
</ul>

*****
## Git
<ul>
    
<details><summary>Message patterns to update ALM automatically</summary>
<br>

Within ALM for defects, stories (user & quality), and features, there is a “Development” tab that will show 
associated commits. This integration is handled through ALM using “SCM change pattern” profiles. 
Currently the following profiles are available and triggered based on certain message patterns

|Entity type|Message pattern|Applies to|Example|
|:----|:----|:----|:----|
|Defect|defect\s*#(\d+)|Branches;<br>Commits;<br>Pull requests|Fix defect #1234|
|Defect|bug\s*#(\d+)|Branches;<br>Commits;<br>Pull requests|Fix bug #1234|
|User story|user story\s*#(\d+)|Branches;<br>Commits;<br>Pull requests|Part of user story #56789|
|Quality story|quality story\s*#(\d+)|Branches;<br>Commits;<br>Pull requests|Part of quality story #56789|
|Feature|feature\s*#(\d+)|Branches;<br>Pull requests<br>|feature #98765|
    
<br>
</details>
<details><summary>Rename a branch</summary>
<br>This is a long 'un. 
    
```bash
git -c credential.helper= -c core.quotepath=false -c log.showSignature=false branch -m <current-branch-name> <new-branch-name> 
```
</details>
<details><summary>Stage changes and commit changes in one command</summary>
<br>

There's no built in way to perform this with git, but git permits the creation of aliases. <br>

```bash
$ git config --global alias.add-commit '!git add -A && git commit'
```

To unset the alias use <br>

```bash
git config --global --unset alias.<your_alias>`
```
</details>
</ul>

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
<br>
</details>

<details><summary>Silent Install</summary>

### <font color="red"><ins>[Read the documentation first!](https://www.microfocus.com/documentation/identity-governance/3.7/install-guide/b19v78jo.html)</ins></font>
> :warning: **See [Documentation]((https://www.microfocus.com/documentation/identity-governance/3.7/requirements/requirements.html#b1a4zqh1)) for all current details.** <br>This page is meant to be used as a quick reference.<br>This page may be out of date and is not intended to replace IG's documentation.<br>
*****
<br>
</details>
</ul>

*****
## InstallAnywhere

<ul>
<details><summary>Download</summary>

Install anywhere is published by [Revenera](https://www.revenera.com/install/products/installanywhere). The
InstallAnywhere product itself can be downloaded from their 
[Product and License Center](https://flexerasoftware.flexnetoperations.com/). <br> Micro Focus's account manager 
will need to create an account for anyone looking to access this resource. 

> :warning: In order to access a newly created account, users will need to go through the process of resetting a 
> forgotten password through the Product and License Center

<br>
</details>


<details><summary>License IA</summary>

1. Execute the binary and open the IA Licensing Wizard.
2. Select the concurrent license option.
3. Enter `ia-lm.idmapps.nqbuild.lab` for the license server's hostname. The port is `27000`

<ul>
<br>
<img src="images/InstallAnywhereLicenseWizard.png" alt="Alt text" width="75%"/> 
</ul>

<br>
</details>

<details><summary>Call Maven with InstallAnywhere profile</summary>

To specify InstallAnywhere's install folder as `ia.root`, assign the `ia.root` value when invoking 
maven with the `-D` flag.

If InstallAnywhere is installed on a Windows' `C:/Program Files/InstallAnywhere 2021/` or `/root/InstallAnywhere 2021`, the following 
can be invoked to prepare the installer:
```bash
mvn clean compile -D"ia.root"="C:\Program Files\InstallAnywhere 2021"
```
```bash
mvn clean compile -Dia.root=/root/InstallAnywhere\ 2021
```
Likewise, to build the installer:
```bash
mvn clean install -D"ia.root"="C:\Program Files\InstallAnywhere 2021"
```
```bash
mvn clean install -Dia.root=/root/InstallAnywhere\ 2021
```
> :bulb: When calling maven on Linux, the double quotes aren't needed. However, they are needed on Windows.

<br>
</details>
</ul>

*****

## <a href=https://maven.apache.org/>Maven</a>

<ul>
<details><summary>Versions Maven Plugin</summary>
<br>

The [versions-maven-plugin](https://www.mojohaus.org/versions-maven-plugin/index.html) can update dependency and plugin version values in pom files for a given project. It can handle direct manipulation of the version tag inside a dependency entry, it can also handle updating properties used for version numbers.

<a id='versions-set'></a>
    
<details><summary>Re-versioning a repo using <a href=https://www.mojohaus.org/versions-maven-plugin/set-mojo.html>versions:set</a></summary>
<br>
Using IG's idgov repo as an example, I want to update all instances of the project version through all pom files (this project has several pom files). From the project root, the following example can be called to set the project version to 4.0.0-SNAPSHOT. I'm Using the `-DprocessAllModules` flag to include the changes in all modules, whether a parent pom or child pom. 

```bash
mvn versions:set -DnewVersion=4.0.0-SNAPSHOT -DprocessAllModules -DgenerateBackupPoms=false -DfullBuild
```
<ul>
    
> :bulb: Can't get this to work on windows?<br>When running this from windows, you may recieve errors that can be resolved by double-quoting assignments within flags, ie `-DnewVersion="4.0.0-SNAPSHOT"`
</ul>
</details>
    
<a id='versions-set-property'></a>
    
<details><summary>Re-versioning a repo using <a href=https://www.mojohaus.org/versions-maven-plugin/set-property-mojo.html>versions:sets-property</a></summary>
<br>

Using  IG's ig-install repo as an example, I want to change all the property versions for dependencies using maven's versions:set-property plugin. I'll first create a properties file in .ini format. the .ini format is a key-value pair, where the key is the property as called in the pom file. An example could be the following: 
    
```
igclient.version=4.0.0-SNAPSHOT
igserver.version=4.0.0-SNAPSHOT
postgres.version=42.3.4
```
To use the maven plugin and reference our newly created properties file, we can use the following command (where `release-versions.properties` is the new key-value pair file we created):
    
```bash
mvn versions:set-property -DpropertiesVersionsFile=release-versions.properties -DgenerateBackupPoms=false
```

> :bulb: Can't get this to work on windows?<br>When running this from windows, you may recieve errors that can be resolved by double-quoting assignments within flags, ie `-DpropertiesVersionsFile="release-versions.properties"`    
    
</details>
    
</details>

</ul></details>

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
    
##### [PSQL Documentation](https://www.postgresql.org/docs/11.0/sql-alterrole.html)
<br>
</details>
</ul>

*****
## SSH
<ul>
<details><summary>Generate an SSH key</summary>
The following command will generate a new SSH key.


```bash
ssh-keygen -t rsa -C "your@email.com" -b 4096
```
After calling the previous cmdlet, the prompt will present a few questions to determine file location and password. 
<br>The following is an example of the full process of creating a new SSH key:

```PowerShell
PS C:\Users\Batman> ssh-keygen -t rsa -C 'Bat.Man@microfocus.com' -b 4096
Generating public/private rsa key pair.
Enter file in which to save the key (C:\Users\Batman/.ssh/id_rsa):
Created directory 'C:\Users\Batman\.ssh'.
Enter passphrase (empty for no passphrase):
Enter same passphrase again:
Your identification has been saved in C:\Users\Batman/.ssh/id_rsa.
Your public key has been saved in C:\Users\Batman/.ssh/id_rsa.pub.
The key fingerprint is:
SHA256:TcRYOBuHd4hSq6RBUoXrVlmY6YkoYyxxLUwKH94j8IM Bat.Man@microfocus.com
The key's randomart image is:
+---[RSA 4096]----+
|oo+ooo.=.Bo.     |
|oB+=o = Oo= .    |
|Eo*o++.=.*..     |
|+o.oo==..o       |
|oo .... S .      |
|    o            |
|   .             |
|                 |
|                 |
+----[SHA256]-----+
PS C:\Users\Batman>
```

<br>
</details>
</ul>

*****
## Wget
<ul>

##### *The non-interactive network downloader.*
<details><summary>Specify download directory</summary>

The `-o` flag is synonymous to `--output-document=<value>`. Even though it seems to be used just to rename a downloaded file, the Documentation states:
> Use of ‘-O’ is not intended to mean simply “use the name file instead of the one in the URL;” rather, it is analogous to shell redirection: ‘wget -O file http://foo’ is intended to work like ‘wget -O - http://foo > file’; file will be truncated immediately, and all downloaded content will be written there.
So this flag is the same as using redirection but in the end you're just renaming the downloaded document.

This example downloads an image to the `/batman/` directory from unsplash.com:
```bash
mkdir /batman/
wget -o /batman/ https://bit.ly/3QrimZb
```
<br>
</details>
</ul>
