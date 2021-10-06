# IksOks



## About

This is a simple project done using Test Driven Development representing a basic Tic Tac Toe game.
It's written in Kotlin, using MVVM architecture, Dagger Hilt and Jetpack Compose. 

## Rules

- The board has nine squares divided in three rows and three columns
- There are two players represented by X and O
- At the begining, all squares are empty and it's X's turn to play
- The game ends when one player places three X or O in row, column or diagonal
- If after nine play none of the players has three consecutive squares, the game is considered a draw

## How to run
- First download or clone this repository from Github
- Run from Android Studio Arctic Fox
- Or from the Terminal, go to the location of the repo and run `./gradlew` & `adb install` commands. 
- In order to check tests, run `./gradlew test` for Local unit tests and `./gradlew connectedAndroidTest` for Instrumented unit tests

## Special thanks & resources

- [Coding in Flow](https://github.com/codinginflow) for its valuable content on Dagger Hilt and MVVM.

- [Philipp Lackner](https://github.com/philipplackner) and [Stevdza San](https://github.com/stevdza-san) for their inspiring tutorials on Jetpack Compose
- [Kotlin Codelabs](https://github.com/googlecodelabs/android-compose-codelabs) mainly for testing Jetpack Compose

## Possible future improvements
- Add Room DB for storage persistance
- Better handle landscape orientation
- Give the user the option to choose the size of the board


<img src="https://i.ibb.co/QCS8HLR/1-xo.jpg" width="300">




<img src="https://i.ibb.co/28bg89C/0-xo.jpg" width="300">

