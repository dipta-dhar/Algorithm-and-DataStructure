#include<bits/stdc++.h>
using namespace std;

int isAvailable(int sudoku[][9], int row, int col, int num) {
    int i, j;
    for(i=0; i<9; ++i)
        if ((sudoku[row][i] == num) || (sudoku[i][col] == num))
            return 0;

     //checking in the grid
    int rowStart = (row/3) * 3;
    int colStart = (col/3) * 3;

    for(i=rowStart; i<(rowStart+3); ++i) {
        for(j=colStart; j<(colStart+3); ++j) {
            if (sudoku[i][j] == num)
                return 0;
        }
    }

    return 1;
}

int fillsudoku(int sudoku[][9], int row, int col) {
    int i;
    if (row<9 && col<9) {
        if (sudoku[row][col] != 0) {
            if ((col+1) < 9)
                return fillsudoku(sudoku, row, col+1);
            else if ((row+1) < 9)
                return fillsudoku(sudoku, row+1, 0);
            else
                return 1;
        }

        else {
            for(i=0; i<9; ++i) {
                if (isAvailable(sudoku, row, col, i+1)) {
                    sudoku[row][col] = i+1;

                    if ((col+1) < 9) {
                       if (fillsudoku(sudoku, row, col +1))
                           return 1;
                        else
                            sudoku[row][col] = 0;
                    }
                    else if ((row+1) < 9) {
                        if (fillsudoku(sudoku, row+1, 0) )
                            return 1;
                        else
                            sudoku[row][col] = 0;
                    }
                    else
                        return 1;
                }
            }
        }
        return 0;
    }
    else {
        return 1;
    }
}

int main()
{
    int i, j;
    int sudoku[9][9]={{3, 0, 6, 5, 0, 8, 4, 0, 0},
                      {5, 2, 0, 0, 0, 0, 0, 0, 0},
                      {0, 8, 7, 0, 0, 0, 0, 3, 1},
                      {0, 0, 3, 0, 1, 0, 0, 8, 0},
                      {9, 0, 0, 8, 6, 3, 0, 0, 5},
                      {0, 5, 0, 0, 9, 0, 6, 0, 0},
                      {1, 3, 0, 0, 0, 0, 2, 5, 0},
                      {0, 0, 0, 0, 0, 0, 0, 7, 4},
                      {0, 0, 5, 2, 0, 6, 3, 0, 0}};

    if(fillsudoku(sudoku, 0, 0)) {
        printf(" After solving:\n\n");
        for(i=0; i<9; ++i) {
            for(j=0; j<9; ++j) {
                if (i%3 == 0 && j==0 && i!=0)
                    printf(" ------+-------+--------\n");

                printf(" %d", sudoku[i][j]);

                if ((j+1)%3 == 0) printf(" |");
            }
            printf("\n");
        }
    }

    else    printf("\n\nNO SOLUTION\n\n");

    return 0;
}
