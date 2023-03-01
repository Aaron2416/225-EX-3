
import java.util.Scanner;

public class TicTacToe {
    private enum Cell { X, O, EMPTY };
    private Cell[][] board;

    public TicTacToe() {
        board = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Cell.EMPTY;
            }
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Cell currentPlayer = Cell.X;
        boolean gameOver = false;

        while (!gameOver) {
            System.out.println("Current board:");
            printBoard();

            System.out.println(currentPlayer + "'s turn.");
            System.out.print("Enter row number (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Enter column number (0-2): ");
            int col = scanner.nextInt();

            if (board[row][col] != Cell.EMPTY) {
                System.out.println("Invalid move. That square is already taken.");
                continue;
            }

            board[row][col] = currentPlayer;

            if (hasWon(currentPlayer)) {
                System.out.println(currentPlayer + " wins!");
                gameOver = true;
            } else if (isDraw()) {
                System.out.println("It's a draw!");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == Cell.X) ? Cell.O : Cell.X;
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean hasWon(Cell player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // row win
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // column win
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // diagonal win
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // diagonal win
        }
        return false;
    }

    private boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Cell.EMPTY) {
                    return false; // game is not a draw
                }
            }
        }
        return true; // game is a draw
    }
}
