import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; ++i) {
            int item = getItem(board, moves[i]-1);
            if (item == -1) continue;
            if (!stack.isEmpty() && stack.peek() == item) {
                stack.pop();
                answer += 2;
                continue;
            }
            stack.push(item);
        }
        return answer;
    }
    
    int getItem(int[][] board, int line) {
        for (int i = 0; i < board.length; ++i) {
            if (board[i][line] != 0) {
                int item = board[i][line];
                board[i][line] = 0;
                return item;
            }
        }
        return -1;
    }
}