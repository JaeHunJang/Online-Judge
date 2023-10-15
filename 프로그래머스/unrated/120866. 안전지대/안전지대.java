import java.util.*;
class Solution {
    int[] dx = {-1, -1, -1, 0, 1, 1,  1,  0};
    int[] dy = {-1,  0,  1, 1, 1, 0, -1, -1};
    
    
    private void fillCells(int x, int y, int[][]board){
        for(int i = 0; i < dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[nx].length)
                board[nx][ny] = 1;
        }
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        //1 이 있는 좌표만 map으로 저장하고 반복문 돌려서 주변을 다시 1로 채움.
        
        Queue<int[]> queue = new LinkedList();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1) queue.add(new int[]{i, j});
            }
        }
        
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            fillCells(temp[0], temp[1], board);
        }
        
        for(int[] row : board){
            for(int cell : row){
                if(cell == 1) answer++;
            }
        }
        
        
        return board.length * board.length - answer;
    }
}