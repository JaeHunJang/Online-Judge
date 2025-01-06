class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        int time = 1;
        for (int[] attack : attacks) {
            int stopTime = attack[0];
            int continueTime = 0;
            for (; time < stopTime; time++) {
                continueTime++;
                int addHealth = bandage[1];
                if (continueTime >= bandage[0]) {
                    continueTime = 0;
                    addHealth += bandage[2];
                }
                answer += addHealth;
                if (answer >= health) answer = health;
            }
            answer -= attack[1];
            time++;
            if (answer <= 0) return -1;
            
        }
        return answer;
    }
}