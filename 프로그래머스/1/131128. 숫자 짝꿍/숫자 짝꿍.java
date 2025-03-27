import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int numx[] = new int[10];
        int numy[] = new int[10];
        
        for (char ch : X.toCharArray()) {
            numx[ch-'0']++;
        }
        for (char ch : Y.toCharArray()) {
            numy[ch-'0']++;
        }
        for (int i = 0; i < numx.length; i++) {
            for (int cnt = Math.min(numx[9-i], numy[9-i]); cnt > 0; cnt--) {
                answer.append((9-i));
            }
        }
        if (answer.toString().isBlank()) {
            return "-1";
        } else if (answer.toString().startsWith("0")) {
            return "0";
        }
        
        return answer.toString();
    }
}