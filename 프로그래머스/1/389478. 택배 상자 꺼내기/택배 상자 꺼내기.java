import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int map[][] = new int[n/w+1][w];
        
        int k = 1;
        for (int i = 0; i < map.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = k++;
                }
            } else {
                for (int j = w - 1; j >= 0; j--) {
                    map[i][j] = k++;
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == num) {
                    for (int l = map.length-1; l >= i; l--) {
                        if (map[l][j] <= n) {
                            answer++;
                        }
                    }
                    return answer;
                }
            }
        }
        
        return answer;
    }
}