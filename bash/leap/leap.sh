#!/usr/bin/env bash

main () {
    echo "$1" | grep "[^0-9]" > /dev/null 2>&1
    if [ "$?" -eq 0 ] || [ "$#" -ne "1" ]; then
        echo "Usage: leap.sh <year>"
        return 1
    fi

    if [ `expr $1 % 4` -eq "0" ] && ! ( [ `expr $1 % 100` -eq "0" ] && [ `expr $1 % 400` -ne "0" ] ); then
        echo "true"
    else
        echo "false"
    fi

    exit 0
}

main "$@"
