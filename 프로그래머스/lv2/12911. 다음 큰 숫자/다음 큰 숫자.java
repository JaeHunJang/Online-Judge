class Solution {
    public int solution(int n) {
        int answer = 0;
        String num = Integer.toString(n, 2);
        int cnt = 0;
        for(char ch : num.toCharArray()){
            if(ch == '1') cnt++;
        }

        while(answer == 0) {
            String temp_num = Integer.toString(++n, 2);
            int temp_cnt = 0;
            for(char ch : temp_num.toCharArray()){
                if(ch == '1') temp_cnt++;
            }
            if(temp_cnt == cnt) answer = Integer.parseInt(temp_num, 2);
        }
        
        return answer;
    }
}