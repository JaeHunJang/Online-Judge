class Solution {
    int[] dx = {0, -1, -1, -1, 0, 1, 1,  1,  0};
    int[] dy = {0, -1,  0,  1, 1, 1, 0, -1, -1};
    
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
        int n = board.length;
        int[][] copyBoard = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1) fillCells(i, j, copyBoard);
            }
        }
        
        for(int[] rows : copyBoard){
            for(int cell : rows){
                if(cell == 1) answer++;
            }
        }
        
        return n * n - answer;
    }
}