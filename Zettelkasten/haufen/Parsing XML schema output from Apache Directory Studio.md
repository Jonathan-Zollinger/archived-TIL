1. After exporting the xml to a file, read the data into PowerShell 
```Powershell
[xml]$schema = Get-Content .\eDir_Schema.xml
```

The overview of the xml file reads
```xml
<?xml version="1.0" encoding="UTF-8"?>

<schemas>
  <schema name="schema">
	<attributetypes...>
	<objectclasses...>
	<syntaxes...>
  </schema>
</schemas>
```

We can select all the object class type nodes by calling an Xpath based on the the property of the object type. This will return an array of node objects.

```powershell
> $attributes = Select-Xml $schema -XPath '//attributetype[@obsolete="false"]'

> $attributes[0].Node

oid                : 2.5.4.35
obsolete           : false
singlevalue        : false
collective         : false
nousermodification : false
aliases            : aliases
description        : Internal NDS policy forces this to be single-valued
usage              : DIRECTORY_OPERATION
syntax             : 1.3.6.1.4.1.1466.115.121.1.40
syntaxlength       : 128
```

Call for the the value of the 'aliases' property in PowerShell by prefacing the node.
```Powershell
> $attributes[0].Node.aliases

alias
-----
userPassword
```

or print all 
```PowerShell
$attributes | % { Write-Output $_.Node.aliases }
```

that doesn't really do much for us since it doesn't parse them by object class. everything put together in a script and saved to a properties file could look something like this: 

```powershell
([xml] (Get-Content .\eDir_Schema.xml) | Select-Xml -XPath '//objectclass') | % { Write-Output "object class alias:`n  $($_.node.aliases.alias)`n`nobject class type:`n  $($_.Node.type)`n`noid:`n  $($_.Node.oid)`n`nmandatory attributes:`n  $(($_.Node.mandatory.attributetype) -join `"`n  `")`n`n`optional attributes:`n  $(($_.Node.optional.attributetype) -join `"`n  ")" | Out-File "$($_.node.aliases.alias).properties"}
```

which is more readable in this format: 

```powershell

$xmlContent = [xml](Get-Content .\eDir_Schema.xml)
$xmlContent.SelectNodes('//objectclass') | ForEach-Object {
    $output = "object class alias:`n  $($_.Node.aliases.alias)`n`n"
    $output += "object class type:`n  $($_.Node.type)`n`n"
    $output += "oid:`n  $($_.Node.oid)`n`n"
    $output += "mandatory attributes:`n  $($_.Node.mandatory.attributetype -join `"`n  `")`n`n"
    $output += "optional attributes:`n  $($_.Node.optional.attributetype -join `"`n  `")"

    $output | Out-File "$($_.node.aliases.alias).properties"
}
```



this all boils down to (newline formatting added for readability)
```PowerShell
[xml] (Get-Content .\eDir_Schema.xml) | 
	Select-Xml -XPath '//attributetype[@obsolete="false"]' | 
	% { Write-Output $_.Node.aliases }
```
