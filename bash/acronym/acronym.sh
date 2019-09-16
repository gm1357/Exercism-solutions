#!/usr/bin/env bash

main () {
    phrase=`replace_symbols "$1"`
    write_acronym "$phrase"
}

replace_symbols() {
    string="$1"
    echo "${string//[-,*,_]/ }"
}

write_acronym() {
    acronym=""

    for word in $1; do
        acronym="${acronym}${word:0:1}"
    done

    echo "${acronym^^}"
}

main "$@"
