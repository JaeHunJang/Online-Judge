import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] l = new int[200];
        
        Arrays.sort(lines, Comparator.comparingInt(x1 -> x1[0]));
        
        for(int[] line : lines){
            for(int[] line2 : lines){
                if(Arrays.equals(line, line2)) continue;
                if(line[1] > line2[0] || line[1] < line2[0]){
                    int end = Math.min(line[1], line2[1]);
                    int start = Math.max(line[0], line2[0]);
                    for(int i = start; i < end; i++){
                        l[i+100] = 1;
                    }
                } 
            }
        }
        
        if(Arrays.equals(lines[0], lines[1])) return Math.abs(Math.max(lines[0][0],lines[0][1]) - Math.min(lines[0][0],lines[0][1]));
        
        for(int n : l){
            if(n == 1) answer++;
        }
        return answer;
    }
}