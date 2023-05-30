#troubleshooting #edirectory

[Jump to resolution](#resolution)
## Overview

Error Code when installing eDir 9.2.7 in a container:
```
Configuring SAS service... Failed to configure SAS service: unknown error -1266 (fffffb0e hex) err=-1266
```
| - | - |
|-----------------|----|
| Environment  | Fedora 37 workstation|
| eDirectory | 9.2.7 container |
| How to Produce | - Run container with compose. <br>- Use the host network. <br>- The host's /etc/hosts file is to have two entries for the 127.0.0.1 address, the first of which is NOT localhost. |
| /etc/hosts file |<samp> # Loopback entries; do not change.<br># For historical reasons, localhost precedes localhost.localdomain:<br>127.0.0.1&ensp; fedora-dev-vm fedora-dev-vm.jonathan-trivir.com<br>127.0.0.1&ensp; localhost localhost.localdomain localhost4 localhost4.localdomain4<br>::1&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; localhost localhost.localdomain localhost6 localhost6.localdomain6 </samp>|
| compose file | <samp>services:<br>&ensp;eDir:<br>&ensp;&ensp;command: new -t ${TREENAME} -a ${ADMIN_DN} -w ${ADMIN_SECRET} -n ${SERVER_CONTEXT} -S ${SERVER_NAME} -B ${IP}@\${NCP_PORT} -o ${HTTP_PORT} -O ${HTTPS_PORT} -L ${LDAP_PORT} -l ${SSL_PORT} --configure-eba-now yes<br>&ensp;&ensp;container_name: 'edir'<br>&ensp;&ensp;deploy:<br>&ensp;&ensp;&ensp;resources:<br>&ensp;&ensp;&ensp;&ensp;limits:<br>&ensp;&ensp;&ensp;&ensp;&ensp;memory: '700m'<br>&ensp;&ensp;&ensp;restart_policy:<br>&ensp;&ensp;&ensp;&ensp;condition: on-failure<br>&ensp;&ensp;&ensp;&ensp;max_attempts: 5<br>&ensp;&ensp;expose:<br>&ensp;&ensp;&ensp;- 1389<br>&ensp;&ensp;&ensp;- 1636<br>&ensp;&ensp;&ensp;- 2524<br>&ensp;&ensp;&ensp;- 1028<br>&ensp;&ensp;image: edirectory:9.2.7<br>&ensp;&ensp;network_mode: 'host'<br>&ensp;&ensp;pids_limit: 300 </samp>|
| .env file | <samp>IP='127.0.0.1'<br>NCP_PORT=2524<br>SERVER_CONTEXT='novell'<br>SERVER_NAME='IDM-unit'<br>TREENAME='trivir'<br>ADMIN_DN='admin.services'<br>ADMIN_SECRET='trivir'<br>LDAP_PORT=1389<br>SSL_PORT=1636<br>HTTP_PORT=1028<br>HTTPS_PORT=1030</samp>|

## Resolution

the first entry for 127.0.0.1 is to be for localhost. may be easier to just remove other entries for localhost.