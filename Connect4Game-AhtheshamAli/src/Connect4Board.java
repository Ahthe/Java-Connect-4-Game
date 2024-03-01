/*
    Ahthesham Ali Syed
    Java Connect 4 Game
    1/24/2022
 */

import java.awt.*;
import java.util.*;

public class Connect4Board {

    private Connect4Square[][] board = new Connect4Square[8][9];

    private int selectedRow;
    private int selectedColumn;

    public Connect4Board() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Connect4Square(Connect4Square.EMPTY, i, j);
            }
        }

        selectedRow = -1;

        selectedColumn = -1;

    } // end of Constructor

    public void setValue(int r, int c, int value) {
        if (r >= 0 && r <= 7) {
            if (c >= 0 && c <= 8) {
                if (value >= 0 && value <= 2) {
                    board[r][c].setValue(value);
                }
            }
        }
    } // end of setValue()

    public void setSelected(int value) {
        this.setValue(selectedRow, selectedColumn, value);
    } // end of setSelected()

    public void setSelectedRow(int r) {

        if (r >= 0 && r <= 7) {

            selectedRow = r;

        } else {
            // System.err.println("ERROR");
        }
    } // end of setSelectedRow()

    public void setSelectedColumn(int c) {

        if (c >= 0 && c <= 8) {

            selectedColumn = c;

        } else {
            //System.err.println("ERROR");
        }
    } // end of setSelectedColumn()

    public int getSelectedRow() {
        return this.selectedRow;
    } // end of getSelectedRow()

    public int getSelectedColumn() {
        return this.selectedColumn;
    } // end of getSelectedColumn()

    public int getValue(int r, int c) {

        if (c >= 0 && c <= 8 && r >= 0 && r <= 7) {

            return board[r][c].getValue();

        }

        return -1;
    } // end of getValue() 

    public int getRowOfLowestEmptySquareInSelectedColumn() {

        int row = 7;

        while (row >= 0 && board[row][selectedColumn].getValue() != Connect4Square.EMPTY) {

            row--;

        }
        return row;
    } // end of getRowOfLowestEmptySquareInSelectedColumn()

    public int checkRowForRedWin(int rowNum) {

        int consecutiveRedPieces = 0;

        int columnNum = 0;
        while (columnNum < 9) {
            if (board[rowNum][columnNum].getValue() == Connect4Square.RED) {
                consecutiveRedPieces++;   // just saw another RED piece
                if (consecutiveRedPieces >= 4) {
                    return Connect4Square.RED;  // this indicates a RED win
                }
            } else {
                consecutiveRedPieces = 0; // just saw a non-RED piece, reset count
            }
            columnNum++;
        } // end while

        return Connect4Square.EMPTY;  // if we go all the way through the loop, we
        // never saw 4 reds in a row, so there is no red win
    } // end checkRowForRedWin()

    public int checkRowForGreenWin(int rowNum) {

        int consecutiveGreenPieces = 0;

        int columnNum = 0;
        while (columnNum < 9) {
            if (board[rowNum][columnNum].getValue() == Connect4Square.GREEN) {
                consecutiveGreenPieces++;
                if (consecutiveGreenPieces >= 4) {
                    return Connect4Square.GREEN;
                }
            } else {
                consecutiveGreenPieces = 0;
            }
            columnNum++;
        } // end while

        return Connect4Square.EMPTY;
    } // end checkRowForGreenWin()

    public int checkColumnForRedWin(int columnNum) {
        // this time, the while-loop variable to be tested should be the row number...
        // be careful -- there are only 8 rows in the board...
        int consecutiveRedPieces = 0;

        int rowNum = 0;
        while (rowNum < 8) {
            if (board[rowNum][columnNum].getValue() == Connect4Square.RED) {
                consecutiveRedPieces++;
                if (consecutiveRedPieces >= 4) {
                    return Connect4Square.RED;
                }
            } else {
                consecutiveRedPieces = 0;
            }
            rowNum++;
        } // end while

        return Connect4Square.EMPTY;
    } // end checkColumnForRedWin()

    public int checkColumnForGreenWin(int columnNum) {

        int consecutiveGreenPieces = 0;

        int rowNum = 0;
        while (rowNum < 8) {
            if (board[rowNum][columnNum].getValue() == Connect4Square.GREEN) {
                consecutiveGreenPieces++;
                if (consecutiveGreenPieces >= 4) {
                    return Connect4Square.GREEN;
                }
            } else {
                consecutiveGreenPieces = 0;
            }
            rowNum++;
        } // end while

        return Connect4Square.EMPTY;
    } // end checkColumnForGreenWin()

    public int checkDownToRightDiagonalForRedWin(int rowNum, int columnNum) {
        // use only one loop; each time through the loop, both rowNum and columnNum should
        // be incremented

        int consecutiveRedPieces = 0;

        while (rowNum < 8 && columnNum < 9) {
            if (board[rowNum][columnNum].getValue() == Connect4Square.RED) {
                consecutiveRedPieces++;
                if (consecutiveRedPieces >= 4) {
                    return Connect4Square.RED;
                }
            } else {
                consecutiveRedPieces = 0;
            }
            rowNum++;
            columnNum++;
        } // end while
        return Connect4Square.EMPTY;
    } // end checkDownToRightDiagonalForRedWin()

    public int checkDownToRightDiagonalForGreenWin(int rowNum, int columnNum) {

        int consecutiveGreenPieces = 0;

        while (rowNum < 8 && columnNum < 9) {
            if (board[rowNum][columnNum].getValue() == Connect4Square.GREEN) {
                consecutiveGreenPieces++;
                if (consecutiveGreenPieces >= 4) {
                    return Connect4Square.GREEN;
                }
            } else {
                consecutiveGreenPieces = 0;
            }
            rowNum++;
            columnNum++;
        } // end while
        return Connect4Square.EMPTY;
    } // end checkDownToRightDiagonalForGreenWin()

    public int checkDownToLeftDiagonalForRedWin(int rowNum, int columnNum) {
        // use only one loop; each time through the loop, rowNum should be incremented
        // and columnNum should be decremented

        int consecutiveRedPieces = 0;

        while (rowNum < 8 && columnNum >= 0) {
            if (board[rowNum][columnNum].getValue() == Connect4Square.RED) {
                consecutiveRedPieces++;
                if (consecutiveRedPieces >= 4) {
                    return Connect4Square.RED;
                }
            } else {
                consecutiveRedPieces = 0;
            }
            rowNum++;
            columnNum--;
        } // end while
        return Connect4Square.EMPTY;
    } // end checkDownToLeftDiagonalForRedWin()

    public int checkDownToLeftDiagonalForGreenWin(int rowNum, int columnNum) {

        int consecutiveGreenPieces = 0;

        while (rowNum < 8 && columnNum >= 0) {
            if (board[rowNum][columnNum].getValue() == Connect4Square.GREEN) {
                consecutiveGreenPieces++;
                if (consecutiveGreenPieces >= 4) {
                    return Connect4Square.GREEN;
                }
            } else {
                consecutiveGreenPieces = 0;
            }
            rowNum++;
            columnNum--;
        } // end while
        return Connect4Square.EMPTY;
    } // end checkDownToLeftDiagonalForGreenWin()

    public int checkForAWinner() {

        for (int r = 0; r < 8; r++) {
            if (checkRowForRedWin(r) == Connect4Square.RED) {
                return Connect4Square.RED;
            }
            if (checkRowForGreenWin(r) == Connect4Square.GREEN) {
                return Connect4Square.GREEN;
            }
        } // end of For loop 

        for (int c = 0; c < 9; c++) {
            if (checkColumnForRedWin(c) == Connect4Square.RED) {
                return Connect4Square.RED;
            }
            if (checkColumnForGreenWin(c) == Connect4Square.GREEN) {
                return Connect4Square.GREEN;
            }
        } // end of For loop

        //for Loops for Right Diagonal
        for (int r = 0; r < 5; r++) {
            if (checkDownToRightDiagonalForRedWin(r, 0) == Connect4Square.RED) {
                return Connect4Square.RED;
            }
            if (checkDownToRightDiagonalForGreenWin(r, 0) == Connect4Square.GREEN) {
                return Connect4Square.GREEN;
            }
        } // end of For loop for checkDownToRightDiagonalForRedWin

        for (int c = 1; c < 6; c++) {
            if (checkDownToRightDiagonalForRedWin(0, c) == Connect4Square.RED) {
                return Connect4Square.RED;
            }
            if (checkDownToRightDiagonalForGreenWin(0, c) == Connect4Square.GREEN) {
                return Connect4Square.GREEN;
            }
        } // end of For loop for checkDownToRightDiagonalForRedWin 

        //for Loops for Left Diagonal
        for (int r = 0; r < 5; r++) {

            if (checkDownToLeftDiagonalForRedWin(r, 8) == Connect4Square.RED) {
                return Connect4Square.RED;
            }
            if (checkDownToLeftDiagonalForGreenWin(r, 8) == Connect4Square.GREEN) {
                return Connect4Square.GREEN;
            }
        } // end of For loop for checkDownToRightDiagonalForRedWin

        for (int c = 3; c < 8; c++) {
            if (checkDownToLeftDiagonalForRedWin(0, c) == Connect4Square.RED) {
                return Connect4Square.RED;
            }
            if (checkDownToLeftDiagonalForGreenWin(0, c) == Connect4Square.GREEN) {
                return Connect4Square.GREEN;
            }
        } // end of For loop for checkDownToRightDiagonalForRedWin         

        return Connect4Square.EMPTY;
    }

//    // Checks if a player can win in the next move by playing a piece in a given column
//    private boolean canWinNextMove(int column, int playerColor) {
//        setValue(getRowOfLowestEmptySquareInSelectedColumn(), column, playerColor); // Temporarily place piece
//        int result = checkForAWinner();
//        setValue(getRowOfLowestEmptySquareInSelectedColumn(), column, Connect4Square.EMPTY); // Undo the move
//        return (result == playerColor);
//    }
//
//    public void makeAMove(int colorOfMove) {
//        boolean gameOver = true;
//        if (!gameOver) {
//            return;
//        }
//        // Priority 1: Win if possible
//        for (int c = 0; c < 9; c++) {
//            if (canWinNextMove(c, colorOfMove)) {
//                setSelectedColumn(c);
//                placePieceAndUpdate(colorOfMove);
//                return;
//            }
//        }
//
//        // Priority 2: Block opponent's win if possible
//        for (int c = 0; c < 9; c++) {
//            if (canWinNextMove(c, (colorOfMove == Connect4Square.RED) ? Connect4Square.GREEN : Connect4Square.RED)) {
//                setSelectedColumn(c);
//                placePieceAndUpdate(colorOfMove);
//                return;
//            }
//        }
//
//        // Fallback: If no immediate win/block, use random logic
//        do {
//            setSelectedColumn((int) (Math.random() * 9));
//        } while (getValue(0, getSelectedColumn()) != Connect4Square.EMPTY);
//
//        // Place the piece and update game state
//        placePieceAndUpdate(colorOfMove);
//    }
//
//    // Helper function to encapsulate the common 'place piece' logic
//    private void placePieceAndUpdate(int colorOfMove) {
//        int r = getRowOfLowestEmptySquareInSelectedColumn();
//        if (r >= 0) {
//            setSelectedRow(r);
//            setSelected(colorOfMove);
//
//            occupiedSpaces++;
//            currentTurnColor = (currentTurnColor == Connect4Square.RED) ? Connect4Square.GREEN : Connect4Square.RED;
//            messageArea.setText("Placed a " + ((currentTurnColor == Connect4Square.RED) ? "RED" : "GREEN" ) + " piece in\n   row " + r + ", column " + selectedColumn);
//
//            int winner = checkForAWinner();
//            if (winner != Connect4Square.EMPTY) {
//                messageArea.setText(((winner == Connect4Square.RED) ? "RED" : "GREEN") + " player has won the game");
//                gameOver = true;
//            } else if (occupiedSpaces >= 72) {
//                messageArea.setText("Game ends in a draw");
//                gameOver = true;
//            }
//        }
//    }



    public int initializeBoard(String input) {
        int returnValue = 0;
        String[] inputLine = input.split("\n");
        String firstMoveColor = inputLine[0].substring(0, inputLine[0].indexOf(" "));
        if (firstMoveColor.equals("GREEN")) {
            returnValue = Connect4Square.GREEN;
        } else if (firstMoveColor.equals("RED")) {
            returnValue = Connect4Square.RED;
        }

        for (int i = 1; i < inputLine.length; i++) {
            int r = i - 1;
            String[] pieceColor = inputLine[i].split(",");
            for (int c = 0; c < pieceColor.length; c++) {
                if (pieceColor[c].trim().equals("0")) {
                    board[r][c].setValue(Connect4Square.EMPTY);
                } else if (pieceColor[c].trim().equals("1")) {
                    board[r][c].setValue(Connect4Square.RED);
                } else if (pieceColor[c].trim().equals("2")) {
                    board[r][c].setValue(Connect4Square.GREEN);
                }
            }
        }
        selectedRow = selectedColumn = -1;
        return returnValue;
    } // end of initializeBoard()

    public void drawBoard(Graphics g) {

        g.setColor(Color.lightGray);
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 9; c++) {
                g.drawRect(c * 50 + 130, r * 50 + 30, 50, 50);
            }
        }

        g.setColor(Color.black);
        g.drawRect(130, 30, 450, 400);
        g.drawRect(129, 29, 452, 402);

        g.setFont(new Font("Helvetica", Font.BOLD, 18));
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 9; c++) {
                switch (board[r][c].getValue()) {
                    case Connect4Square.EMPTY:
                        g.setColor(Color.WHITE);
                        break;
                    case Connect4Square.RED:
                        g.setColor(Color.RED);
                        break;
                    case Connect4Square.GREEN:
                        g.setColor(Color.GREEN);
                        break;
                } // end if
                g.fillOval(c * 50 + 131, r * 50 + 31, 48, 48);
                if (selectedRow == r && selectedColumn == c) {
                    g.setColor(Color.red.darker());
                    g.drawRect(c * 50 + 130, r * 50 + 30, 50, 50);
                    g.drawRect(c * 50 + 131, r * 50 + 31, 48, 48);
                }
            }
        }

    } // end of drawBoard()

} // end of class Connect4Board
