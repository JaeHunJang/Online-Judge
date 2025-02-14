class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        for (int i = 0; i < section.length; i++) {
            int start = section[i];
            for (int j = i+1; j < section.length && section[j] < start + m; j++) {
                i++;
            }
            answer++;
        }
        
        return answer;
    }
}