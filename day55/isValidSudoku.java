/*
36. 有效的数独
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-sudoku
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer>[] row = new HashMap[9];
        Map<Integer, Integer>[] col = new HashMap[9];
        Map<Integer, Integer>[] box = new HashMap[9];
        
        for (int i = 0; i < 9; i++) {
            row[i] = new HashMap<Integer, Integer>();
            col[i] = new HashMap<Integer, Integer>();
            box[i] = new HashMap<Integer, Integer>();

        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int num = (int) board[i][j]; 
                int k = i / 3 * 3 + j / 3;

                row[i].put(num, row[i].getOrDefault(num, 0) + 1);
                col[j].put(num, col[j].getOrDefault(num, 0) + 1);
                box[k].put(num, box[k].getOrDefault(num, 0) + 1);

                if (row[i].get(num) > 1 || col[j].get(num) > 1 || box[k].get(num) > 1)
                    return false;

            }
        }

        return true;
    }
}
