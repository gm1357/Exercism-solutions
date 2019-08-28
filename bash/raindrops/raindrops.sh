#!/usr/bin/env bash


main () {
    if (( "$#" != 1 )); then
        echo "Usage: ./$(basename "$0") <number>"
        exit 1
    fi

    raindrop_string=""

    build_raindrop "$@"

    echo "$raindrop_string"
}

build_raindrop() {

    check_factor "$1" 3 "Pling"
    check_factor "$1" 5 "Plang"
    check_factor "$1" 7 "Plong"

    if [[ -z "$raindrop_string" ]]; then
        raindrop_string="$1"
    fi
}

check_factor() {
    if (( "$1" % "$2" == 0 )); then
        raindrop_string="${raindrop_string}$3"
    fi
}

main "$@"
