import java.util.*;

class Solution {
    class Pair {
        int num1, num2;
        Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < weights.length; i++) {
            map.put(weights[i], map.getOrDefault(weights[i], 0L) + 1);
        }
        
        int[] w = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < w.length; ++i) {
            long cnt = map.get(w[i]);
            if (cnt > 1) {
                answer += cnt * (cnt-1) / 2;
            }
            for (int j = i+1; j < w.length; ++j) {
                for (int n = 2; n <= 4; n++) {
                    for (int m = 2; m <= 4; m++) {
                        if (w[i] * n == w[j] * m) {
                            answer += cnt * map.get(w[j]);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}