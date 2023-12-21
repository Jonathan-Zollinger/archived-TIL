### show mapped network drives
```PowerShell
Get-ChildItem -Path HKCU:\Network -Recurse | Get-ItemProperty | Select-Object pschildname, remotepath | Out-String
```
[source](https://www.reddit.com/r/PowerShell/comments/tqz5m7/script_sharing_show_mapped_network_drives_for/?utm_source=share&utm_medium=web2x&context=3)

