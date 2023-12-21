#edirectory #troubleshooting 

##### [Jump to Resolution](#Resolution)

# Defect Overview
`javax.naming.directory.SchemaViolationException: [LDAP: error code 65 - NDS error: missing mandatory (-609)]; remaining name 'cn=eBogisich,o=users'`


## Environment

<table>
<tbody>
 <tr>
    <td>Device Type</td>
    <td>VM w/ Container</td>
  </tr>
  <tr>
    <td>OS</td>
    <td>Fedora</td>
  </tr>
  <tr>
    <td>Software</td>
    <td>eDirectory 9.2.5<br>Java1.8</td>
  </tr>
</tbody>
</table>

## Expected Behavior

	Can remove any LDAP attribute using opClearAttr

## Actual Behavior
	errors out with mentioned error code
## Steps to Reproduce
<ol>
<li> supply a user with an SN to eDirectory
<li> try to remove the SN
</ol>


# Resolution
SN is included in attributes that can't be removed. 

#### Further Reading
