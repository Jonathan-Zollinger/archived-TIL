[SCP command](Secure%20Transfer%20Protocol%20(scp).md)

```shell
scp file.txt user@host:/path/to/copied_file.txt
```

This command produces a new file named 'copied_file.txt' in the remote directory. This new `copied_file.txt` inherits the permissions, owners, smell, etc. of the original `file.txt`