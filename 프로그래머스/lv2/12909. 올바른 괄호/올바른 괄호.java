class Solution {
    boolean solution(String s) {
        char[] chars = s.toCharArray();
        
        int cnt = 0;

        if(chars[0] == ')') return false;
        if(chars[chars.length-1] == '(') return false;
        
        for(char ch : chars){
            if(ch == '(') {
                cnt++;
            } else if(ch == ')') {
                cnt--;
            }
            if(cnt < 0) return false;
        }
        
        if(cnt != 0) return false;
        
        return true;
    }
}