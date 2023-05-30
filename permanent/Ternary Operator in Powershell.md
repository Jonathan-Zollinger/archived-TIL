#ternary-operator #cheatsheet #one-liner #powershell

#### Syntax:
`\<expression\> ? \<if true\> : \<if false\>`

#### Example:
```powershell
$(Get-Job -Command 'vmrest') ? ":vmware's rest api is found" : "vmware's rest api is NOT found"
```
The above would print whether a job for vmware's rest api is running. 

> NOTE: this requires PowerShell 7