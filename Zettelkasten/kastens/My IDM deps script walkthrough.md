TL:DR netiq documented script bad, good script at the end of this note. 

The IDM deps script in the docs loops over all the dependencies, which is a joke since you can just call all of the dependencies at one time during install. Otherwise yum is going to query the subscription management repos before installing each package (that's probably 15-30 seconds each repo with 16 repos )

the script attempts to use a wildcard to match multiple packages. beyond improperly searching with a wildcard, they've also included an errant `-` in the search. properly searching (ie `yum search glibc | grep i686`) for these packages returns the following :

```bash
❯ yum search glibc | grep i686
Last metadata expiration check: 0:17:41 ago on Thu 09 Mar 2023 01:17:21 PM MST.
glibc.i686 : The GNU libc libraries
glibc-gconv-extra.i686 : All iconv converter modules for glibc.
glibc-devel.i686 : Object files for development using standard C libraries.
glibc-headers.i686 : Header files for development using standard C libraries.
```

```bash
❯ yum search libgcc | grep i686
Last metadata expiration check: 0:15:28 ago on Thu 09 Mar 2023 01:17:21 PM MST.
libgcc.i686 : GCC version 8 shared support library
gcc-toolset-11-libgccjit-devel.i686 : Support for embedding GCC inside programs and libraries
gcc-toolset-12-libgccjit.i686 : Library for embedding GCC inside programs and libraries
gcc-toolset-12-libgccjit-devel.i686 : Support for embedding GCC inside programs and libraries
```

see notes on [[False Negatives from RHEL-Prerequisite.sh script]] for presumed false errors.

Assuming all this is accurate, then the script should actually look like the following

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
