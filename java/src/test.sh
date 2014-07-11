#!/bin/bash

FTPHOST="192.168.3.114"
FTPUSER="wangweiwei"
FTPPASS="wangweiwei"


echo "shell test very good"

# function app_release()
# {
# 	LOCALFILE=$1
# 	SERVERDIR=$2

#  #   echo "localfile " $LOCALFILE
# 	if [ -r $LOCALFILE ]; # File seems to exist and is readable
# 	then
# 	lftp  $FTPHOST <<END_SCRIPT
# 		#quote USER $FTPUSER
# 		#quote PASS $FTPPASS
# 		user $FTPUSER $FTPPASS
# 		cd $SERVERDIR
# 		put $LOCALFILE 
# 		quit
# END_SCRIPT
# 	else
# 	    echo "The file $LOCALFILE does not exist.Please check it!"
# 	exit 0				    
# fi
# }

# app_release 
