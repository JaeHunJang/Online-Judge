class Solution {
    public int solution(int n) {
        int answer = 1;
        
        // int a = Math.max(n, 6);
        // int b = Math.min(n, 6);
        // while(true) {
        //     int r = a % b;
        //     if (r == 0) { answer = b; break;}
        //     a = b;
        //     b = r;   
        // }
        // answer n / b;
        
        while(true) {
            if(answer * 6 % n == 0) break;
            answer++;
        }
        return answer;
    }
}