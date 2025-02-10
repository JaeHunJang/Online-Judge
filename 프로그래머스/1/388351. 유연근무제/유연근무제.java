class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < timelogs.length; i++) {
            int day = startday;
            int cnt = 0;
            for (int j = 0; j < timelogs[i].length; j++) {
                if (day <= 5 && convTime(schedules[i]) + 10 >= convTime(timelogs[i][j])) {
                    cnt++;
                }
                
                day = day % 7 + 1;
            }
            if (cnt >= 5) answer++;
        }
        
        return answer;
    }
    
    int convTime(int n) {
        int hour = n / 100;
        int min = n % 100;
        
        return hour * 60 + min;
    }
}