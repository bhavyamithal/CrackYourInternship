package Arrays;

public class GameOfLife {
    public void gameOfLife(int[][] board) {

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countLiveNeighbours(board, i, j);

                if (board[i][j] == 0) {

                    // if the original element was 0
                    if (count == 3) {
                        board[i][j] = 2;
                    } else {
                        board[i][j] = 0;
                    }

                } else {

                    // if the original element was 1
                    if (count < 2) {
                        board[i][j] = 1;
                    } else if (count > 3) {
                        board[i][j] = 1;
                    } else if (count == 2 || count == 3) {
                        board[i][j] = 3;
                    }

                }
            }
        }

        // change the board back to it's next generation in 0s and 1s
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 0;
                } else if (board[i][j] == 1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }

    static boolean isSafe(int[][] board, int i, int j) {
        int m = board.length, n = board[0].length;

        if (i >= 0 && j >= 0 && i < m && j < n) {
            return true;
        }

        return false;
    }

    static int countLiveNeighbours(int[][] board, int row, int col) {
        int count = 0;

        int start_i = row - 1;
        int start_j = col - 1;

        for (int i = start_i; i < start_i + 3; i++) {
            for (int j = start_j; j < start_j + 3; j++) {
                if (!(i == row) && !(j == col)) {
                    continue;
                } else {
                    if (isSafe(board, i, j)) {

                        if (board[i][j] == 1 || board[i][j] == 3) {
                            count++;
                        }

                    }
                }
            }
        }

        return count;
    }
}
