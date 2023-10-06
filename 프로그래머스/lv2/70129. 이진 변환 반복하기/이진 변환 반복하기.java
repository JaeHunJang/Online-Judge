class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")){
            answer[0]++;
            answer[1] += countZero(s);
            s = Integer.toString(s.length() - countZero(s), 2);
        }
        
        return answer;
    }
    
    private int countZero(String s) {
        int cnt = 0;
        for(char ch : s.toCharArray()){
            if(ch == '0') cnt++;
        }
        return cnt;
    }
}