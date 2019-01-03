# UNIX Commands Cheatsheet

## Everyday Commands

`ls` - Lists items in current directory.

`cd ..` - Takes us up one level to the directory above your current location.

`cd <directory name>` - Moves us into the specified directory path.

`mkdir <directory name>` - Creates the specified directory.

`touch <filename>` - Creates the specified file

## Useful to Know (Just Incase)

`pwd` - Prints the current 'working directory' (where you currently are in the directory tree)

`ls -a` - Lists all items in the current directory including hidden files (files with a dot in front of their names).

`ls -l` - Gives a long list of items in the current directory including permissions, size and last modified date.

`ls -la` - Combines the two previous options to show a long listing of all files.

`cd` - With no directory specified, this will take us to our home directory. Alternatively we can use `cd ~`

`history` - Lists your entire commands history (use `!<line_number>` to retrieve a specific command... for example `!232`)

`mv <source> <target>` - Can be used for moving files, or alternatively renaming them

`cp <source> <target>` - Copies the first file to the location (and optionally, new name) of the second file

## Dangerous Commands (Use with Extreme Caution)

`rm <filename>` - removes the specified file **This is very DANGEROUS.** If you ever come across this do not execute it unless you are sure you are removing the right file, and you definitely don't need it. (Items deleted with `rm` do NOT going in the "Trash" folder, they are just completely deleted!

`rm -rf <directory name>` - removes the specified directory and all subdirectories and files (This can be extremely dangerous!! **Be _very_ careful** with this command and ensure you are in the right place before hitting enter! You can imagine how bad the results could be if you did that in your home folder!)
