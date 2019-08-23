#!/usr/bin/env bash

@test "an empty string" {
  run bash reverse_string.sh ""

  [[ $status -eq 0 ]]
  [[ $output = "" ]]
}

@test "a word" {
  run bash reverse_string.sh "robot"

  [[ $status -eq 0 ]]
  [[ $output = "tobor" ]]
}

@test "a capitalised word" {
  run bash reverse_string.sh "Ramen"

  [[ $status -eq 0 ]]
  [[ $output = "nemaR" ]]
}

@test "a sentence with punctuation" {
  run bash reverse_string.sh "I'm hungry!"

  [[ $status -eq 0 ]]
  [[ $output = "!yrgnuh m'I" ]]
}

@test "a palindrome" {
  run bash reverse_string.sh "racecar"

  [[ $status -eq 0 ]]
  [[ $output = "racecar" ]]
}

@test "an even-sized word" {
  run bash reverse_string.sh "drawer"

  [[ $status -eq 0 ]]
  [[ $output = "reward" ]]
}

