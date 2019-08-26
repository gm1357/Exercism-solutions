#!/usr/bin/env bash

main () {
    sentence="$1"
    stack=""

    for (( i=0; i<${#sentence}; i++ )); do
        char=${sentence:i:1}

        check_string
    done

    if [ -n "$stack" ]; then
        echo "false"
        exit "0"
    fi

    echo "true"
}

check_string() {
    check_open_close "(" ")"

    check_open_close "{" "}"

    check_open_close "[" "]"
}

check_open_close() {
    if [ "$char" = "$1" ]; then
        stack="$stack$1"
    elif [ "$char" = "$2" ]; then
        check_stack "$1"
    fi
}

check_stack() {
    if [ "${stack: -1}" = "$1" ]; then
        stack=${stack::-1}
    else
        echo "false"
        exit "0"
    fi
}

main "$@"
