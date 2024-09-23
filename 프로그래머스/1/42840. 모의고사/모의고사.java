class Solution {
    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        
        final int[] marking1 = {1, 2, 3, 4, 5};
        final int[] marking2 = {2, 1, 2, 3, 2, 4, 2, 5};
        final int[] marking3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        
        for (int ans : answers) {
            if (ans == marking1[cnt1++ % marking1.length]) scores[0]++;
            if (ans == marking2[cnt2++ % marking2.length]) scores[1]++;
            if (ans == marking3[cnt3++ % marking3.length]) scores[2]++;
            
        }
        
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        int maxCnt = 0;
        for (int score : scores) {
            if (maxScore == score) maxCnt++;
        }
        
        int[] answer = new int[maxCnt];
        int j = 0;
        for (int i = 0; i < scores.length; i++) {
            if (maxScore == scores[i]) answer[j++] = i+1;
        }
        
        return answer;
    }
}