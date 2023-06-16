1. After exporting the xml to a file, read the data into PowerShell 
```Powershell
[xml]$schema = Get-Content .\eDir_Schema.xml
```

The first few lines of xml read 
```xml
<?xml version="1.0" encoding="UTF-8"?>

<schemas>
  <schema name="schema">
    <attributetypes>
      <attributetype oid="2.5.4.35" obsolete="false" singlevalue="false" collective="false" nousermodification="false">
        <aliases>
          <alias>userPassword</alias>
        </aliases>
        <description>Internal NDS policy forces this to be single-valued</description>
        <usage>DIRECTORY_OPERATION</usage>
        <syntax>1.3.6.1.4.1.1466.115.121.1.40</syntax>
        <syntaxlength>128</syntaxlength>
      </attributetype>
      <attributetype oid="2.5.18.1" obsolete="false" singlevalue="true" collective="false" nousermodification="true">
	...
```

We can select all the attribute type nodes by calling an Xpath based on the the property of the attribute type. This will return an array of node objects.

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