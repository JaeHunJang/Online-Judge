class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int i = 1, j = 0, k = 0;
        answer[j][k] = i++;
        
        while(i <= n*n) {
            
            while(k+1 < n && answer[j][k+1] == 0) 
                answer[j][++k] = i++;
            
            while(j+1 < n && answer[j+1][k] == 0) 
                answer[++j][k] = i++;
            
            while(k-1 >= 0 && answer[j][k-1] == 0) 
                answer[j][--k] = i++;
            
            while(j-1 >= 0 && answer[j-1][k] == 0)
                answer[--j][k] = i++;
            
        }
        
        return answer;
    }
}