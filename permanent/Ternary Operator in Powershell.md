#ternary-operator #cheatsheet #one-liner #powershell

#### Syntax:
`<expression> ? <if true> : <if false>`

#### Example:

This example  prints whether a job for vmware's rest api is running. 
```powershell
$(Get-Job -Command 'vmrest') ? ":vmware's rest api is found" : "vmware's rest api is NOT found"
```

<blockquote>NOTE: this requires PowerShell 7</blockquote>