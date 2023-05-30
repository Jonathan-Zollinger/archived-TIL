## Synopsis
**ln** creates **_links_** to one or more files or directories. A normal hard link is a new directory entry that refers to the same file, either in the directory that currently contains the file or in a different directory. The result is a new path name that refers to the file. You can access the file using either the old path name or the new one; both path names are of equal importance. If you [**rm**](https://www.mkssoftware.com/docs/man1/rm.1.asp) either name, the other one remains and the file contents are still available under that name. The contents of the file do not disappear until you remove the last link.

A file may have any number of links to it. Thus you can establish any number of different path names for any file.

A symbolic link is similar to a normal hard link but it can only be created for directories. See the description of the **-s** option below for more information on symbolic links.

In the first form given in the synopsis, _new_ becomes a new path name for the file _old_. In the second form, **ln** creates entries for all the _old_ files under the directory _dir_. For example,

<code>ln yourdir/* mydir</code>

creates links under mydir to all the files under yourdir. The files have the same names under mydir that they had under yourdir. **ln** always assumes this directory form when the last operand on the command line is the name of a directory. In this case, none of the _old_ names may be a directory
## Syntax

<code>**ln** \[**-fiqRrv**] _old_ _new_<br>**ln** \[**-fiqRrsv**] _old old ... dir_ </code>
## Symbolic Link
### Symbolic Link Synopsis
creates a symbolic link. You can only create symbolic links on systems using the NTFS file system.

On Windows XP/Server 2003, symbolic links can only be created for directories on local drives; you cannot create a symbolic link for a file.

On Windows `8.1/2012R2`,`10/2016/2019`,`11/2022`, you can create symbolic links to both directories and files. However, to do so, the user must have the `SeCreateSymbolicLinkPrivilege` privilege. By default, this privilege is only assigned to administrators; however it can be assigned to any user through the use of standard Windows tools or the MKS Toolkit [**priv**](https://www.mkssoftware.com/docs/man1/priv.1.asp) command. The target file or directory need not exist. It is perfectly legal (as it is on UNIX) to create a symblic link to a target that does not yet exist. However Windows (unlike UNIX) needs to know if the target will file or a directory. By default a file symbolic link will be created, but setting the environmant variable **_TK_MISSING_SYMLINK_TARGET_TYPE_**=D, a directory symbolkc link can be created.

<blockquote>

**Note:**<br> The **-s** option does not work with drives which use removable media (for example, CD drives and tape drives).
</blockquote>

A symbolic link is a pointer to the directory to which it is linked. Like a normal hard link, you can refer to the directory by either its original name or the name of the symbolic link. Unlike a normal hard link, deleting the original directory leaves a link pointing nowhere and the contents of the directory are gone.
<blockquote>

**Note:**<br>When using Explorer, selecting a symbolic link and dragging it to the **Recycle Bin** (or hitting the DELETE key) deletes just the symbolic link. Using the Windows command line **del** command to delete a symbolic link deletes the symbolic link and the contents (excluding subdirectories and their contents) of the original directory, but not the original directory itself.
</blockquote>

## Examples
1. This example creates links under mydir to all the files under yourdir. The files have the same names under mydir that they had under yourdir. **ln** always assumes this directory form when the last operand on the command line is the name of a directory. In this case, none of the _old_ names may be a directory
<ul>

```bash
ln yourdir/* mydir
```

</ul>


## References
1. [ln -- create a link to a file or directory (mkssoftware.com)](https://www.mkssoftware.com/docs/man1/ln.1.asp)

<small><i> Created: 2023-05-30 13:33 </i></small>