import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int num = s / n;
        if (num == 0) return new int[] {-1};
        int mod = s % n;
        int[] answer = new int[n];
        Arrays.fill(answer, num);
        for (int i = 0; i < mod; i++) {
            answer[n-1-i]++;
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += answer[i];
        }
        if (sum != s) return new int[] {-1};
        return answer;
    }
}