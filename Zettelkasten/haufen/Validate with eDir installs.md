

**environment variables**
- [ ] PATH includes `/opt/novell/eDirectory/bin:/opt/novell/eDirectory/sbin`
- [ ] MANPATH includes `/opt/novell/man:/opt/novell/eDirectory/man`
- [ ] TEXTDOMAINDIR reads `/opt/novell/eDirectory/share/locale`

#### ports
TCP
- [ ] 524
- [ ] 8028
- [ ] 8030
- [ ] 389
TLS
- [ ] 636
eDir 

`ldapsearch -h SERVERNAME -p 389 -D cn=admin,o=services -w PASSWORD_HERE -b o=services`



