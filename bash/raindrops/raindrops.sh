#!/usr/bin/env bash


main () {
    if (( "$#" != 1 )); then
        echo "Usage: ./$(basename "$0") <number>"
        exit 1
    fi

    raindrop_string=$(build_raindrop "$@")

    echo "${raindrop_string:-$1}"
}

build_raindrop() {
    echo "$(check_factor "$1" 3 "Pling")$(check_factor "$1" 5 "Plang")$(check_factor "$1" 7 "Plong")"
}

check_factor() {
    if (( "$1" % "$2" == 0 )); then
        echo "$3"
    fi
}

main "$@"
