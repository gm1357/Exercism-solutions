#!/usr/bin/env bash

main () {
    error_handling "$@"
    calculate_hamming "$@"
}

error_handling() {
    if (( "$#" != 2 )); then
        echo "Usage: hamming.sh <string1> <string2>"
    elif [[ -z "$1" ]] && [[ -n "$2" ]]; then
        echo "left strand must not be empty"
    elif [[ -z "$2" ]] && [[ -n "$1" ]]; then
        echo "right strand must not be empty"
    elif (( ${#1} != ${#2} )); then
        echo "left and right strands must be of equal length"
    else
        return
    fi

    exit 1
}

calculate_hamming() {
    left="$1"
    right="$2"
    distance=0

    for (( i=0; i<${#left}; i++ )); do
        if [[ "${left:i:1}" != "${right:i:1}" ]]; then
            (( distance++ ))
        fi
    done

    echo $distance
}

main "$@"
