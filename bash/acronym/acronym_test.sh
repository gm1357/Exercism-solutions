#!/usr/bin/env bash

@test 'basic' {
  run bash acronym.sh 'Portable Network Graphics'
  [[ "$status" -eq 0 ]]
  [[ "$output" == 'PNG' ]]
}

@test 'lowercase words' {
  run bash acronym.sh 'Ruby on Rails'
  [[ "$status" -eq 0 ]]
  [[ "$output" == 'ROR' ]]
}

@test 'punctuation' {
  run bash acronym.sh 'First In, First Out'
  [[ "$status" -eq 0 ]]
  [[ "$output" == 'FIFO' ]]
}

@test 'all caps word' {
  run bash acronym.sh 'GNU Image Manipulation Program'
  [[ "$status" -eq 0 ]]
  [[ "$output" == 'GIMP' ]]
}

@test 'punctuation without whitespace' {
  run bash acronym.sh 'Complementary metal-oxide semiconductor'
  [[ "$status" -eq 0 ]]
  [[ "$output" == 'CMOS' ]]
}

@test 'very long abbreviation' {
  run bash acronym.sh 'Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me'
  [[ "$status" -eq 0 ]]
  [[ "$output" == 'ROTFLSHTMDCOALM' ]]
}

@test "consecutive delimiters" {
  run bash acronym.sh "Something - I made up from thin air"
  [[ "$status" -eq 0 ]]
  [[ "$output" == "SIMUFTA" ]]
}

@test "apostrophes" {
  run bash acronym.sh "Halley's Comet"
  [[ "$status" -eq 0 ]]
  [[ "$output" == "HC" ]]
}

@test "underscore emphasis" {
  run bash acronym.sh "The Road __Not__ Taken"
  [[ "$status" -eq 0 ]]
  [[ "$output" == "TRNT" ]]
}

@test "contains shell globbing character" {
  run bash acronym.sh "Two * Words"
  [[ "$status" -eq 0 ]]
  [[ "$output" == "TW" ]]
}
