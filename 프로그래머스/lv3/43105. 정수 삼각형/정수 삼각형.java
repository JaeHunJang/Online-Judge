import java.util.*;
class Solution {
    int[][] result = new int[500][500]; //계산 값 저장
    
    private int max(int x, int y, int[][] triangle){ //x 삼각형의 세로, y 삼각형의 가로
        if(x == triangle.length) return 0;
        if(result[x][y] != -1) return result[x][y]; //이미 계산한 값 있으면 바로 반환
        
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
        
        /*
        //별도의 계산값 저장공간을 만들지 않고 삼각형에 바로 계산값 저장
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j = 1; j < i; j++) 
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
        
        */
    }
    
    
}