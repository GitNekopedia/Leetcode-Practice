package n_queens;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] checkBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                checkBoard[i][j] = '.';
            }
        }

        Set<Integer> columns = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();


        // 每一行只有一个皇后，因此不需要两个for循坏，只需要记录放了几行
        backtrack(checkBoard, 0, result, n, columns, diag1, diag2);
        return result;
    }

    void backtrack(char[][] checkBoard, int row, List<List<String>> result, int n, Set<Integer> columns, Set<Integer> diag1, Set<Integer> diag2){

        // 放够4行就把结果加入
        if (row == n){
            result.add(construct(checkBoard));
            return;
        }

        for (int col = 0; col < n; col++) {

            // 如果检测到不合规则就跳过
            if (columns.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)){
                continue;
            }

            // 放置皇后
            checkBoard[row][col] = 'Q';
            // 记录列、对角线
            columns.add(col);
            // 重点：用row-col和row+col来表示对角线
            diag1.add(row - col);
            diag2.add(row + col);

            // 递归下一行
            backtrack(checkBoard, row + 1, result, n, columns, diag1, diag2);

            // 回溯
            checkBoard[row][col] = '.';
            columns.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);


        }
        
    }

    private List<String> construct(char[][] checkBoard) {
        List<String> path = new ArrayList<>();
        for (char[] chars : checkBoard) {
            path.add(new String(chars));
        }
        return path;
    }
}