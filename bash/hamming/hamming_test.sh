#!/usr/bin/env bash

@test 'empty strands' {
  run bash hamming.sh '' ''
  [[ $status -eq 0 ]]
  [[ $output == "0" ]]
}

@test 'single letter identical strands' {
  run bash hamming.sh 'A' 'A'
  [[ $status -eq 0 ]]
  [[ $output == "0" ]]
}

@test 'single letter different strands' {
  run bash hamming.sh 'G' 'T'
  [[ $status -eq 0 ]]
  [[ $output == "1" ]]
}

@test 'long identical strands' {
  run bash hamming.sh 'GGACTGAAATCTG' 'GGACTGAAATCTG'
  [[ $status -eq 0 ]]
  [[ $output == "0" ]]
}

@test 'long different strands' {
  run bash hamming.sh 'GGACGGATTCTG' 'AGGACGGATTCT'
  [[ $status -eq 0 ]]
  [[ $output == "9" ]]
}

@test 'disallow first strand longer' {
  run bash hamming.sh 'AATG' 'AAA'
  [[ $status -eq 1 ]]
  [[ $output == 'left and right strands must be of equal length' ]]
}

@test 'disallow second strand longer' {
  run bash hamming.sh 'ATA' 'AGTG'
  [[ $status -eq 1 ]]
  [[ $output == 'left and right strands must be of equal length' ]]
}

@test 'disallow left empty strand' {
  run bash hamming.sh '' 'G'
  [[ $status -eq 1 ]]
  [[ $output == 'left strand must not be empty' ]]
}

@test 'disallow right empty strand' {
  run bash hamming.sh 'G' ''
  [[ $status -eq 1 ]]
  [[ $output == 'right strand must not be empty' ]]
}

@test "no input" {
  run bash hamming.sh
  [[ $status -eq 1 ]]
  [[ $output == 'Usage: hamming.sh <string1> <string2>' ]]
}

@test "invalid input" {
  run bash hamming.sh 'A'
  [[ $status -eq 1 ]]
  [[ $output == 'Usage: hamming.sh <string1> <string2>' ]]
}
