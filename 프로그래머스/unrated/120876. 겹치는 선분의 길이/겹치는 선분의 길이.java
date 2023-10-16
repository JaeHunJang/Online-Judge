import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] l = new int[200];
        
        Arrays.sort(lines, Comparator.comparingInt(x1 -> x1[0])); //start가 작은 순으로 정렬
        
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
        //배열 내 선분이 모두 같은 경우 비교해서 처리
        if(Arrays.equals(lines[0], lines[1])) return Math.abs(Math.max(lines[0][0],lines[0][1]) - Math.min(lines[0][0],lines[0][1])); 
        
        for(int n : l){
            if(n == 1) answer++;
        }
        return answer;
        
        /*
        int[] thickness = new int[200];
        for (int[] line : lines) { //선분을 처음부터 전부 채워넣어서 값이 1이상이면 겹친선분
            int start = line[0] + 100;
            int end = line[1] + 100;
            for (int i = start; i < end; ++i) {
                ++thickness[i];
            }
        }
        int answer = 0;
        for (int i = 0; i < 200; ++i) {
            if (thickness[i] > 1) {
                ++answer;
            }
        }
        return answer;
        
        */
    }
}