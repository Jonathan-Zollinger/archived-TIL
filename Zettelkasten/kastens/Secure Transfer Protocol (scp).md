```shell
scp <options> source_path destination_path
```

```bash
-r      # transfer directory 
-v      # see the transfer details
-C      # copy files with compression
-l 800  # limit bandwith with 800
-p      # preserving the original attributes of the copied files
-P      # connection port
-q      # hide the output
```

# Examples

![SCP a local file to a remote filename](SCP%20a%20local%20file%20to%20a%20remote%20filename.md)

![SCP a local file to a remote directory](SCP%20a%20local%20file%20to%20a%20remote%20directory.md)

![SCP a remote file to a local file](SCP%20a%20remote%20file%20to%20a%20local%20file.md)

Copying multiple files to a remote system (but not all files in a directory) using the  `scp` command
```shell
scp file.sh file2.sh user@host:/path/to/directory
```


### Copying a directory to a remote system using the  `scp` command
```shell
scp -r /path/to/directory user@host:/path/to/directory
```
