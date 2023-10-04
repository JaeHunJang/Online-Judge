class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        
        for(String s : (num+"").split("")){
            answer++;
            if((k+"").equals(s)) return answer;
        }
        
        return -1;
        //return ("-" + num).indexOf(String.valueOf(k));
    }
}