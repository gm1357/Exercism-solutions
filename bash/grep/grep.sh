#!/usr/bin/env bash

main () {
    flags=""
    pattern=""
    files=""
    
    get_params "$@"
    grep_files "$flags" "$pattern" "$files"
}

get_params() {

    while [[ -n "$1" ]]; do

        if [[ "${1:0:1}" = "-" ]]; then
            [[ -z "$flags" ]] && flags="${1}" || flags="${flags} ${1}"
        elif [[ -z "$pattern" ]]; then
            pattern="$1"
        else
            [[ -z "$files" ]] && files="$1" || files="${files} $1"
        fi

        shift
    done
}

grep_files() {

    for file in $3; do
        grep_string="`grep ${1} "${2}" $file`"

        if [[ -n $grep_string ]]; then
        
            [[ `echo "$3" | wc -w` -gt "1" ]] && \
                echo "`grep --with-filename ${1} "${2}" $file`" || \
                echo "$grep_string"
        fi
    done
}

main "$@"