# 🕹️ Java Connect 4 Game

A classic Connect 4 game implementation in Java using Swing for the user interface.

## 🎮 Features

* **Visual Game Board:** The `MUPanel` class renders a graphical Connect 4 board. Players can visually place pieces by clicking on the desired column.
* **Player Modes:**  Supports two game modes:
   * _Human vs. Human:_  Two players take turns.
   * _Human vs. Computer:_  A computer AI opponent that makes moves.
* **Improved Computer AI:** The AI exhibits the following strategic behaviors:
    * _Offensive:_ Attempts to win the game if an immediate win possibility is found.
    * _Defensive:_ Blocks the opponent's imminent win if detected.
    * _Fallback:_ Resorts to random column selection if no immediate win or block is available. 
* **Game Logic:** The `Connect4Board` class encapsulates the core game logic:
    * _Piece Placement:_ Handles dropping pieces into the selected column.
    * _Win Condition Checking:_  Implements functions to check for winning combinations in rows, columns, and diagonals.
* **Game State Management:** The game tracks the current player's turn, displays instructions and messages in the `TextArea` components, and determines the winner.

## 💻 Getting Started

**Prerequisites**

* Java Development Kit (JDK) _(specify version if applicable)_

**Running the Game**

1. Clone or download the repository.
2. Compile the Java code (e.g., `javac MUPanel.java Connect4Board.java Connect4Square.java`)
3. Run the main class `MUPanel` (e.g., `java MUPanel`)


## 🧑‍💻 About the Author

This project was created by Ahthesham Ali Syed.
