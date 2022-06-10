# TIL 
<ul>

[by making this an unordered list w/ no items, this is a work-around for indenting this section.]: #

##### Today I Learned &nbsp;&nbsp;&nbsp;&nbsp;| &nbsp;&nbsp;&nbsp;&nbsp; Zettelkasen style notes
</ul>

# Topics
- [eDirectory](#eDirectory)
- [Firefox](#Firefox)
- [Firewall](#Firewall)

## eDirectory
<ul>
<details><summary>Download</summary>

 Version | Download|   |
 ---     |---      |---
 9.2.1 | [Windows](http://prvbuilder02.provo.novell.com/artifacts/edir/921/eDirectory_921_Windows_x86_64.exe) | [Linux](http://prvbuilder02.provo.novell.com/artifacts/edir/921/eDirectory_921_Linux_x86_64.tar.gz)
 9.2.5    | [Windows](http://prvbuilder02.provo.novell.com/artifacts/edir/925/eDirectory_925_Windows_x86_64.exe) | [Linux](http://prvbuilder02.provo.novell.com/artifacts/edir/925/eDirectory_925_Linux_x86_64.tar.gz) 

 > :bulb: More eDir downloads (including some md5 versions) are available from the [provo's artifactory](http://prvbuilder02.provo.novell.com/artifacts/edir/).

</details>
</ul>

*****
## Firefox
<ul>
<details><summary>Allow HTTP Sites</summary>

1. Open [`about:config`](images\Firefox;about-config.png) in Firefox. 
    - ##### *You may be prompted to accept the risk of changing firefox configration.* 
2. [Search for and change](images\Firefox;about-config;changing_properties.gif) the following properties `false` 
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


## <font color="red"><ins>[Use Documentation First!](https://www.microfocus.com/documentation/identity-governance/3.7/requirements/requirements.html#b1a4zqh1)</ins></font>
> :warning: See [Documentation]((https://www.microfocus.com/documentation/identity-governance/3.7/requirements/requirements.html#b1a4zqh1)) for all current details. This page is meant to be a quick reference. This page may be out of date and is not intended to replace documentation.

<br></br>

| OS     | Release |
|---     |---      |
|Red Hat | <ul><li>8.3 (64-bit)</li><li>Later patched versions of 8.x</li></ul>

| LDAP      | Release |
|---        |---      |
|[eDirectory](#eDirectory) | <ul><li>9.2</li><li>Later patched versions of 9.<font color="red">2</font>.x</li></ul>


</ul>

*****
