# Pig Latin Translator

A simple command-line project that translates a string (word, sentence or paragraph) into Pig
Latin.

## Table of Contents
- [Features](#features)
- [Build](#Build)
- [Run](#Run)

## Features

- Words that start with a consonant have their first letter moved to the end of the word and the
letters "ay" added to the end (Hello becomes Ellohay).
- Words that start with a vowel have the letters "way" added to the end (apple becomes appleway).
- Words that end in "way" are not modified (stairway stays as stairway).
- Punctuation remain in the same relative place from the end of the word (can’t becomes
antca’y, end. becomes endway.).
- Hyphens are treated as two words (this-thing becomes histay-hingtay).
- Capitalization remain in the same place (Beach becomes Eachbay, McCloud becomes
CcLoudmay).

## Build
```script
mvn clean install
```

## Run

Program can be executed from command line, and has two modes of operation:
- Interactive: prompts for source string and writes translation to the console (can be terminated
  with SIGINT, ie. CTRL+C). Please check interactive.bat
```script
java -cp .\target\classes eu.feg.assigment.piglatin.PigLatinTranslator
```
- Parametrized: program accepts parameter -s with source string enclosed by quotes, writes
  translation to the console and terminates (eg. java PiglatinTranslator -s "I want to translate
  this to pig latin"). You can check parametrized.bat
```script
java -cp .\target\classes eu.feg.assigment.piglatin.PigLatinTranslator -s "I want to translate this to pig latin"
```