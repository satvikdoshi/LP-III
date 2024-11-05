public class NQueensSimplified {
    static int N = 4;
    static int[][] board = new int[N][N];
    static int[] placed = {0, 2}; // Pre-placed queen at (2,3)

    public static void main(String[] args) {
        board[placed[0]][placed[1]] = 1; // Place the queen initially
        System.out.println("Initial Board");
        printBoard();

        if (solveNQueens(0)) {
            System.out.println("Solution:");
            printBoard();
        } else {
            System.out.println("No Solution");
        }
    }

    // Method to print the board
    static void printBoard() {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print((cell == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
        System.out.println("********");
    }

    // Method to check if it's safe to place a queen at (row, col)
    static boolean isSafe(int row, int col) {
        for (int i = 0; i < N; i++) {
            if (board[i][col] == 1 || board[row][i] == 1) return false; // Check row & column
        }
        for (int i = -N; i <= N; i++) { // Check diagonals
            if (row + i >= 0 && row + i < N && col + i >= 0 && col + i < N && board[row + i][col + i] == 1) return false;
            if (row + i >= 0 && row + i < N && col - i >= 0 && col - i < N && board[row + i][col - i] == 1) return false;
        }
        return true;
    }

    // Recursive method to solve the N-Queens problem
    static boolean solveNQueens(int col) {
        if (col == N) return true; // All columns filled successfully

        if (col == placed[1]) return solveNQueens(col + 1); // Skip fixed queen column

        for (int row = 0; row < N; row++) {
            if (row == placed[0]) continue; // Skip row with fixed queen

            if (isSafe(row, col)) {
                board[row][col] = 1;
                if (solveNQueens(col + 1)) return true;
                board[row][col] = 0; // Backtrack
            }
        }
        return false;
    }
}
