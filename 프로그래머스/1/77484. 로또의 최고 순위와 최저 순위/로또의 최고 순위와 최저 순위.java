class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        for (int i = 0; i < lottos.length; ++i) {
            if (lottos[i] == 0) answer[0]++;
            for (int j = 0; j < win_nums.length; ++j) {
                if (lottos[i] == win_nums[j]) {
                    answer[0]++;
                    answer[1]++;
                }
            }
        }
        answer[0] = convRank(answer[0]);
        answer[1] = convRank(answer[1]);
        
        return answer;
    }
    
    int convRank(int n) {
        if (n >= 2) {
            return 7 - n;
        }
        
        return 6;
    }
}