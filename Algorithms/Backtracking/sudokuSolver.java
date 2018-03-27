package Backtracking;


import java.util.Scanner;

public class sudokuSolver {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int SIZE = N * N;
        int CELLS = N * N * N * N;
        int[] puzzle = new int[CELLS];
        for (int i = 0; i < CELLS; i++) {
            puzzle[i] = input.nextInt();
        }
        if (solve(puzzle)) {
            System.out.println("Puzzle Solved, here is the solution: ");
            for (int i = 0; i < CELLS; i++) {
                System.out.print(" " + puzzle[i]);
                if ((i + 1) % N == 0) System.out.print(" |");
                if (i != 0 && (i + 1) % SIZE == 0) System.out.println();
                if ((i + 1) % (N*SIZE)  == 0) System.out.println("----------------------");
            }
        } else {
            System.out.println("Could not solve this puzzle");
        }
        System.out.println();
        
        input.close();
    }

    public static boolean solve(int[] puzzle) {
        int N = (int) Math.round(Math.pow(puzzle.length, 0.25d)); // length ^ 0.25
        int SIZE = N * N;
        int CELLS = SIZE * SIZE;
        boolean noEmptyCells = true;
        int myRow = 0, myCol = 0;
        for (int i = 0; i < CELLS; i++) {
            if (puzzle[i] == 0) {
                myRow = i / SIZE;
                myCol = i % SIZE;
                noEmptyCells = false;
                break;
            }
        }
        if (noEmptyCells) return true;

        for (int choice = 1; choice <= SIZE; choice++) {
            boolean isValid = true;
            int gridRow = myRow / N;
            int gridCol = myCol / N;
            // check grid for duplicates
            for (int row = N * gridRow; row < N * gridRow + N; row++)
                for (int col = N * gridCol; col < N * gridCol + N; col++)
                    if (puzzle[row * SIZE + col] == choice)
                        isValid = false;

            // row & column
            for (int j = 0; j < SIZE; j++)
                if (puzzle[SIZE * j + myCol] == choice || puzzle[myRow * SIZE + j] == choice) {
                    isValid = false;
                    break;
                }


            if (isValid) {
                puzzle[myRow * SIZE + myCol] = choice;
                boolean solved = solve(puzzle);
                if (solved) return true;
                else puzzle[myRow * SIZE + myCol] = 0;
            }
        }
        return false;
    }
}


/*
Sample Input:
-------------

3
4 0 0 0 0 0 0 0 5
0 0 9 4 0 2 8 0 0
0 6 0 0 5 0 0 9 0
0 3 0 0 8 0 0 2 0
0 0 2 5 0 1 3 0 0
0 9 0 0 4 0 0 7 0
0 1 0 0 6 0 0 5 0
0 0 8 1 0 5 9 0 0
5 0 0 0 0 0 0 0 7

*/
