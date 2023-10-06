import java.util.*;
class Solution {
    // '주어진 네 개의 점을 두 개씩 이었을 때' 3가지 경우의 수 만을 의미
    // [a-b, c-d],[a-c, b-d],[a-d, b-c]
    private double slope(int x1, int y1, int x2, int y2){
        return (double) (y2-y1) / (x2-x1); //기울기 구하기
    }
    
    public int solution(int[][] dots) {
        List<Double> slopes1 = new ArrayList<>();
        List<Double> slopes2 = new ArrayList<>();
        int cnt = 0;
        
        for(int i = 0; i < dots.length; i++){
            for(int j = i + 1; j < dots.length; j++){
                double s = slope(dots[i][0], dots[i][1], dots[j][0], dots[j][1]); //기울기 결과
                
                if (i == 0) slopes1.add(s); // 선 X의 기울기
                else slopes2.add(s); // 선 Y의 기울기
            }
        }
        for(int i = 0; i < slopes1.size(); i++){
            if((double)slopes1.get(i) == (double)slopes2.get(slopes2.size() - 1 - i))
                return 1;
        }
        
        return 0; 
    }
}