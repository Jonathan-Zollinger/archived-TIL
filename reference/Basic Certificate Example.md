#certificate #edirectory 
<details><summary>&nbsp;Very simple self signed cert from an eDirectory container:</summary>
<ul>

```
CONNECTED(00000003)
Can't use SSL_get_servername
depth=1 OU = Organizational CA, O = ZOLLINGER-HAUS
verify error:num=19:self signed certificate in certificate chain
verify return:1
depth=1 OU = Organizational CA, O = ZOLLINGER-HAUS
verify return:1
depth=0 O = ZOLLINGER-HAUS, CN = fedora
verify return:1
---
Certificate chain
 0 s:O = ZOLLINGER-HAUS, CN = fedora
   i:OU = Organizational CA, O = ZOLLINGER-HAUS
 1 s:OU = Organizational CA, O = ZOLLINGER-HAUS
   i:OU = Organizational CA, O = ZOLLINGER-HAUS
---
Server certificate
-----BEGIN CERTIFICATE-----
MIIGkzCCBXugAwIBAgIUHVrRNcoEtONcOitne0KuYKeOonAwDQYJKoZIhvcNAQEL
BQAwLTEaMBgGA1UECxMRT3JnYW5pemF0aW9uYWwgQ0ExDzANBgNVBAoTBlRSSVZJ
UjAeFw0yMzA1MDIxNjM2MzBaFw0yNTA1MDExNjM2MzBaMCIxDzANBgNVBAoTBlRS
SVZJUjEPMA0GA1UEAxMGZmVkb3JhMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIB
CgKCAQEAxf2J8JCyI+wMJVPXvvTeJYTeebFbDruzUHuWrG49JN2mH6sj59fMDGEk
JPJOubK/3uEeZVRWQUpTscYxQ7YOSwz2ZjN6mW2uhpdkqMSiKklWL0qjZPuBbGzz
Yvry8HkHPqK5LTA0zIG6q8Au2Pkdy8RyyE250xV/rRu3eSjgTbZLjIrcIOoJkbPv
MS8OOsCG+TllOsWG4c5+p/uzBawqRHXMFh00IZA37uYahOjL+cY5GM65el3KtXUO
9z8Bm1upgc5Se5aLnh+yhxRkDd4ykydm11dIjjF7IMaLspnV+1ay4bVfrcXKtw11
wiL7i1mCERZ9CV8Hsu4GQfuosUCdSQIDAQABo4IDtDCCA7AwHQYDVR0OBBYEFP7U
YtmJeNVliIb8DHBbZTcHRQ2BMB8GA1UdIwQYMBaAFAWhsTLj2cy3fJWDL5zTZz8h
52iYMA8GA1UdEQQIMAaHBKwRAoswCwYDVR0PBAQDAgWgMIIBzAYLYIZIAYb4NwEJ
BAEEggG7MIIBtwQCAQABAf8THU5vdmVsbCBTZWN1cml0eSBBdHRyaWJ1dGUodG0p
FkNodHRwOi8vZGV2ZWxvcGVyLm5vdmVsbC5jb20vcmVwb3NpdG9yeS9hdHRyaWJ1
dGVzL2NlcnRhdHRyc192MTAuaHRtMIIBSKAaAQEAMAgwBgIBAQIBRjAIMAYCAQEC
AQoCAWmhGgEBADAIMAYCAQECAQAwCDAGAgEBAgEAAgEAogYCARcBAf+jggEEoFgC
AQICAgD/AgEAAw0AgAAAAAAAAAAAAAAAAwkAgAAAAAAAAAAwGDAQAgEAAgh/////
/////wEBAAIEBvDfSDAYMBACAQACCH//////////AQEAAgQG8N9IoVgCAQICAgD/
AgEAAw0AQAAAAAAAAAAAAAAAAwkAQAAAAAAAAAAwGDAQAgEAAgh//////////wEB
AAIEBWLGgTAYMBACAQACCH//////////AQEAAgQFYsaBok4wTAIBAgIBAAICAP8D
DQCAAAAAAAAAAAAAAAADCQCAAAAAAAAAADASMBACAQACCH//////////AQEAMBIw
EAIBAAIIf/////////8BAQAwggF+BgNVHR8EggF1MIIBcTAnoCWgI4YhaHR0cDov
LzEyNy4wLjAuMToxMDI4L2NybC9vbmUuY3JsMFygWqBYhlZsZGFwOi8vMTI3LjAu
MC4xOjEzODkvQ049T25lLENOPU9uZSUyMC0lMjBDb25maWd1cmF0aW9uLENOPUNS
TCUyMENvbnRhaW5lcixDTj1TZWN1cml0eTAooCagJIYiaHR0cHM6Ly8xMjcuMC4w
LjE6MTAzMC9jcmwvb25lLmNybDBdoFugWYZXbGRhcHM6Ly8xMjcuMC4wLjE6MTYz
Ni9DTj1PbmUsQ049T25lJTIwLSUyMENvbmZpZ3VyYXRpb24sQ049Q1JMJTIwQ29u
dGFpbmVyLENOPVNlY3VyaXR5MF+gXaBbpFkwVzEMMAoGA1UEAxMDT25lMRwwGgYD
VQQDExNPbmUgLSBDb25maWd1cmF0aW9uMRYwFAYDVQQDEw1DUkwgQ29udGFpbmVy
MREwDwYDVQQDEwhTZWN1cml0eTANBgkqhkiG9w0BAQsFAAOCAQEAo7BLEZwfzaL/
SYfjQJvKHJt5J830YLWilVOxRfUajMITmmV5YpnORs2ix+4+tTMzLmRX+7iVkJcg
q7lORPg8vB+dps194YI+wCCoRrb8+Va4vTsQgZBaTDqJUsBMwu5PBLXfdfSEhLYW
Ki5dXqeW1d4DyZNEV4Sun9fmbuzgCxIh2iylydgjXaA6N6ISR6mwl+xmz8pVSSwW
wVOV1rHvHX9gOwYWJ6+kzLTVFWz9qeNO9DlPhdYZePeElOgTca/P4huEtS4qsby/
lxG87RUbXrX04/D5Rm7v6XefqqSDDEmTB8hw66jDSzRHCK1p6vY8i9tHhH5vOfqt
YkVPIHnyMA==
-----END CERTIFICATE-----
subject=O = ZOLLINGER-HAUS, CN = fedora

issuer=OU = Organizational CA, O = ZOLLINGER-HAUS

---
No client certificate CA names sent
---
SSL handshake has read 3323 bytes and written 611 bytes
Verification error: self signed certificate in certificate chain
---
New, TLSv1.2, Cipher is AES256-GCM-SHA384
Server public key is 2048 bit
Secure Renegotiation IS supported
Compression: NONE
Expansion: NONE
No ALPN negotiated
SSL-Session:
    Protocol  : TLSv1.2
    Cipher    : AES256-GCM-SHA384
    Session-ID: 86D64534154231614EFB20534813D4F4E5C6FDB9DB366E34E04AAA39B634FA0D
    Session-ID-ctx:
    Master-Key: 51CB384AFD3CD119F2203532932ADC83301C4C3C98BDEE257BFA8B5A509B9C0E585939E4E875382FD3070242D759CED6
    PSK identity: None
    PSK identity hint: None
    SRP username: None
    TLS session ticket lifetime hint: 300 (seconds)
    TLS session ticket:
    0000 - 98 8a 47 19 22 9d 8b d2-b8 44 bf 53 53 5b 74 52   ..G."....D.SS[tR
    0010 - 91 19 c4 83 8b 87 fd 2f-35 94 eb 31 a2 ce b3 54   ......./5..1...T
    0020 - 93 0f 7a 43 7f 35 d6 2d-a6 a2 f9 96 05 c1 9f 28   ..zC.5.-.......(
    0030 - ae 56 26 6d a6 f6 26 19-82 05 c9 af 77 06 30 13   .V&m..&.....w.0.
    0040 - 30 e3 58 14 cc 18 b0 b0-25 fc 9f 58 a5 65 a1 8f   0.X.....%..X.e..
    0050 - 62 2f f3 63 87 62 b8 69-e7 63 b3 24 ea 7f 20 37   b/.c.b.i.c.$.. 7
    0060 - 9e 4d 35 c8 2b aa 38 c5-4e 86 08 22 39 20 da bc   .M5.+.8.N.."9 ..
    0070 - a0 8d e7 69 a8 92 b5 1b-5a fe 4e 70 fd 0f d2 e0   ...i....Z.Np....
    0080 - fd 74 7c db 12 81 c1 1d-5d 26 6a f3 db c6 1e f2   .t|.....]&j.....
    0090 - 3d 4e 92 c0 15 39 82 a4-87 b2 33 53 34 5f 1d 4f   =N...9....3S4_.O
    00a0 - ab 04 c9 7c db 4f 33 b1-9c 5e e8 a5 33 b0 f7 89   ...|.O3..^..3...

    Start Time: 1683142097
    Timeout   : 7200 (sec)
    Verify return code: 19 (self signed certificate in certificate chain)
    Extended master secret: no
---
```

</ul></details>
