import java.util.ArrayList;
import java.util.List;

class NQueens {
    public static void main(String args[]) {
        int n = 4;
        List<List<String>> nqueens = new ArrayList<>();
        nqueens = GenrateQueens(n);

        // Print solutions
        for (int i = 0; i < nqueens.size(); i++) {
            System.out.println("Solution " + (i + 1) + ":");
            for (String row : nqueens.get(i)) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public static List<List<String>> GenrateQueens(int n) {
        List<List<String>> allboard = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(board, allboard, 0);
        return allboard;
    }

    public static void helper(char[][] board, List<List<String>> allboard, int col) {
        if (col == board.length) {
            saveBoard(board, allboard);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(i, col, board)) {
                board[i][col] = 'Q';
                System.out.println("borad at row " + i + " and col " + col + " : " + board[i][col]);
                helper(board, allboard, col + 1);
            }
            System.out.println("backtraking at row " + i + " and " + col);
            board[i][col] = '.';
            System.out.println("borad at row " + i + " and col " + col + " : " + board[i][col]);
        }
    }

    public static boolean isSafe(int row, int col, char[][] board) {
        // 1. Check this row on left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q')
                return false;
        }

        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // 2. Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // 3. Check lower diagonal on left side
        for (int i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    public static void saveBoard(char[][] board, List<List<String>> allboard) {
        String row = "";
        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            row = "";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q') {
                    row += 'Q';
                } else {
                    row += '.';
                }

            }
            newBoard.add(row);
        }
        allboard.add(newBoard);

    }
}