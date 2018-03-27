using System;
using System.Collections.Generic;

class Solution
{
    public static bool SudokuSolve(char[,] board)
    {
        // your code goes here
        if (board == null || board.GetLength(0) < 9 || board.GetLength(1) < 9)
        {
            return false;
        }

        // assume that 9 * 9
        return SudokuSolveHelper(board, 0, 0);
    }

    private static bool SudokuSolveHelper(char[,] board, int row, int col)
    {
        // base case
        if (row > 8)
        {
            return true;
        }

        var visit = board[row, col];
        var isDot = visit == '.';

        var nextRow = col == 8 ? (row + 1) : row;
        var nextCol = col == 8 ? 0 : (col + 1);

        if (!isDot)
        {
            return SudokuSolveHelper(board, nextRow, nextCol);
        }

        // assume that it is digit number 
        var availableNumbers = getAvailableNumbers(board, row, col);

        foreach (var option in availableNumbers)
        {
            board[row, col] = option;

            var result = SudokuSolveHelper(board, nextRow, nextCol);

            if (result)
            {
                return true;
            }

            board[row, col] = '.';
        }

        return false;
    }

    private static HashSet<Char> getAvailableNumbers(char[,] board, int currentRow, int currentCol)
    {
        var numbers = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        var available = new HashSet<char>(numbers);        

        // check by row
        for (int col = 0; col < 9; col++)
        {
            var visit = board[currentRow, col];
            var isDigit = visit != '.';

            if (isDigit)
            {
                available.Remove(visit);
            }
        }

        // check by col
        for (int row = 0; row < 9; row++)
        {
            var visit = board[row, currentCol];
            var isDigit = visit != '.';

            if (isDigit)
            {
                available.Remove(visit);
            }
        }

        // check by 3 * 3 matrix 
        var startRow = currentRow / 3 * 3;
        var startCol = currentCol / 3 * 3;
        for (int row = startRow; row < startRow + 3; row++)
        {
            for (int col = startCol; col < startCol + 3; col++)
            {
                var visit = board[row, col];
                var isDigit = visit != '.';

                if (isDigit)
                {
                    available.Remove(visit);
                }
            }
        }

        return available;
    }

    static void Main(string[] args)
    {
        var board = new char[,]{
        {'.','.','.','7','.','.','3','.','1'},
        {'3','.','.','9','.','.','.','.','.'},
        {'.','4','.','3','1','.','2','.','.'},
        {'.','6','.','4','.','.','5','.','.'},
        {'.','.','.','.','.','.','.','.','.'},
        {'.','.','1','.','.','8','.','4','.'},
        {'.','.','6','.','2','1','.','5','.'},
        {'.','.','.','.','.','9','.','.','8'},
        {'8','.','5','.','.','4','.','.','.'}};

        Console.WriteLine(SudokuSolve(board));
    }
}