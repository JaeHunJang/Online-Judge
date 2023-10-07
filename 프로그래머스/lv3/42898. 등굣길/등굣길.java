class Solution {
    
    
    private int navi(int x, int y, int[][] map){
        if(x >= map.length || y >= map[0].length) return 0;
        if(map[x][y] == -1) return 0;
        if(map[x][y] == -2) return 1;
        if(map[x][y] > 0) return map[x][y];
        
        return map[x][y] = (navi(x+1, y, map) + navi(x, y+1, map)) % 1000000007;
        
    }
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[m+1][n+1];
        map[m-1][n-1] = -2;
        for(int[] puddle : puddles){
            map[puddle[0]-1][puddle[1]-1] = -1;
        }
        
        return navi(0,0,map);
    }
}