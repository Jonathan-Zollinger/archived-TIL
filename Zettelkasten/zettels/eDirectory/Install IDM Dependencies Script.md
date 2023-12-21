#bash #idmunit #redhat
```shell
#!/bin/bash
#
# Installs all needed dependencies for IDM 4.8.0
#
# Globals:
#   None
# Arguments:
#   None
#   Must be registered (or have RHEL ISO configured as a yum repo)
# Author:
#   Jonathan Zollinger
#   Mar 9 2023

yum clean all
yum repolist
yum makecache

PKGS="ksh gettext.x86_64 libXrender.i686 libXau.i686 libxcb.i686 libX11.i686 libXext.i686 libXi.i686 libXtst.i686 libstdc++.x86_64 unzip bc lsof net-tools libgcc.i686 gcc-toolset-11-libgccjit-devel.i686 gcc-toolset-12-libgccjit.i686 gcc-toolset-12-libgccjit-devel.i686 glibc.i686 glibc-gconv-extra.i686 glibc-devel.i686 glibc-headers.i686"

yum -y install $PKGS
```

### References
1. [[My IDM deps script walkthrough]]

<small><i> Created: 2023-05-30 12:47 </i></small>