import java.util.*;
class Solution {
    int[][] result = new int[500][500];
    
    private int max(int x, int y, int[][] triangle){ //x 삼각형의 세로, y 삼각형의 가로
        if(x == triangle.length) return 0;
        if(result[x][y] != -1) return result[x][y];
        
        return result[x][y] = triangle[x][y] + Math.max(
            max(x+1, y, triangle),
            max(x+1, y+1, triangle)
        );
    }
    
    public int solution(int[][] triangle) {
        for(int[] r : result){
            Arrays.fill(r, -1);
        }
        int answer = max(0, 0, triangle);
        
        return answer;
    }
    
    
}