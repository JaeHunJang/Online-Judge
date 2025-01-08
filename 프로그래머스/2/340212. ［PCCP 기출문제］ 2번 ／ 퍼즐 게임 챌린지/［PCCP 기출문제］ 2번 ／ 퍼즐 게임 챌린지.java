class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 100_001;
        
        int start = 1;
        int end = 100_000;
        
        while (start < end) {
            int level = (start + end) / 2;
            
            long totalTime = 0;
            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] > level) {
                    int prevTime = i >= 0 ? times[i-1] : 0;
                    totalTime += (times[i] + prevTime) * (diffs[i] - level);
                }
                
                totalTime += times[i];
            }
            if (totalTime > limit) {
                start = level+1;
            } else {
                end = level;
            }
        }
        
        return end;
    }
}