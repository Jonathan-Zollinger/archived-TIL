#edirectory #cli 

From Redhat's support page on installing `compat-libstdc++-33` on RHEL 8.x :
> Upgrade your application software. "compat-libstdc++-33" only exists to support binaries that were compiled on / compatible with RHEL 4 (RHEL 5 at the latest), so it is no longer supported. <br><br>If you need `compat-libstdc++-33`, chances are you are trying to run a program which is not supported on RHEL 8; the most obvious example I know of is older versions of the Oracle database (12.1.x and earlier). You need to either upgrade your application (e.g. to Oracle 19c, which is officially supported on RHEL 8) or use RHEL 7.x to support the application until you can upgrade to a newer version

I assume that packages like this (that the RHEL-Prerequisite script flags as false ) can be ignored if a more recent package of the same structure is installed (ie **libstdc++-** *8.5.0-16.el8_7* **.x86_64**)

also keep in mind packages can change names or become obsolete because of another package. ie 
```shell
❯ yum install dnf-utils.noarch -y
Updating Subscription Management repositories.
Last metadata expiration check: 0:51:11 ago on Thu 09 Mar 2023 01:41:52 PM MST.
Error:
 Problem: problem with installed package yum-utils-4.0.21-14.1.el8.noarch
  - installed package yum-utils-4.0.21-14.1.el8.noarch obsoletes dnf-utils < 4.0.21-14.1.el8 provided by dnf-utils-4.0.2.2-3.el8.noarch
```

gum filter is a handy tool for validating packages manually. 
![[gum filter.gif]]