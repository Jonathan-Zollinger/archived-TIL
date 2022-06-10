# TIL 
###### Zettelkasten style notes

# Topics
- [Firefox](#Firefox)
- [Firewall](#Firewall)
## Firefox
<details><summary>Allow HTTP Sites</summary>

1. Open [`about:config`](images\Firefox;about-config.png) in Firefox. 
    - ##### *You may be prompted to accept the risk of changing firefox configration.* 
2. [Search for and change](images\Firefox;about-config;changing_properties.gif) the following properties `false` 
```
network.cookie.sameSite.laxByDefault:  false
network.cookie.sameSite.noneRequiresSecure:  false
network.cookie.sameSite.schemeful:  false
```
> **_TIP_** <br />Properties like `netw...noneRequiresSecure` may not have an assignment when you go to make your edits. In this case add the property to Firefox's configuration by selecting `boolean` as the property type and selecting the **_+_** button before setting this property to false
3. Restart Firefox
    - ##### *You can restart firefox by hitting `ctrl + F5`*

</details>

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

*****

