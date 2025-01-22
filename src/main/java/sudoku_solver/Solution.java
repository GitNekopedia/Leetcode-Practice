package sudoku_solver;

class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    boolean backtrack(char[][] board){
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.'){
                    // 尝试加入1到9
                    for (char num = '1'; num <= '9'; num++) {
                        // 检查合法性
                        if (isValid(board, row, col, num)){
                            // 放置数字
                            board[row][col] = num;
                            //如果合法，就计算下一个格子
                            if (backtrack(board)){
                                return true;
                            }
                            // 回溯
                            board[row][col] = '.';
                        }

                    }
                    return false;
                }

            }

        }
        return false;

    }

    boolean isValid(char[][] board, int row, int col, char num){
        // 检查行和列
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num){
                return false;
            }
        }

        // 检查3x3
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num){
                    return false;
                }
            }
        }

        return true;
    }
}