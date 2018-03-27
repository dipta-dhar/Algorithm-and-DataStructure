package Backtracking;

class knightsTour {
    // N x N chessboard
    public static final int N = 5;

    // Below arrays details all 8 possible movements for a knight.
    // Don't change the sequence of below arrays
    public static final int row[] = { 2, 1, -1, -2, -2, -1,  1,  2 , 2 };
    public static final int col[] = { 1, 2,  2,  1, -1, -2, -2, -1, 1 };

    // Check if (x, y) is valid chess board coordinates
    // Note that a knight cannot go out of the chessboard
    private static boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N)
            return false;

        return true;
    }

    private static void print(int[][] visited) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Recursive function to perform the Knight's tour using backtracking
    public static void knightTour(int visited[][], int x, int y, int pos) {
        // mark current square as visited
        visited[x][y] = pos;

        // if all squares are visited, print the solution
        if (pos >= N*N) {
            print(visited);
            // backtrack before returning
            visited[x][y] = 0;
            return;
        }

        // check for all 8 possible movements for a knight
        // and recurse for each valid movement
        for (int k = 0; k < 8; k++) {
            // Get the new position of Knight from current
            // position on chessboard
            int newX = x + row[k];
            int newY = y + col[k];

            // if new position is a valid and not visited yet
            if (isValid(newX, newY) && visited[newX][newY] == 0)
                knightTour(visited, newX, newY, pos + 1);
        }

        // backtrack from current square and remove it from current path
        visited[x][y] = 0;
    }

    public static void main(String[] args) {
        int visited[][] = new int[N][N];
        int pos = 1;

        // start knight tour from corner square (0, 0)
        knightTour(visited, 0, 0, pos);
    }
}