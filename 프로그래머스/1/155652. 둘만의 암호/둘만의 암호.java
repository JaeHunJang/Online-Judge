class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for (char ch : s.toCharArray()) {
            int cnt = 0;
            while (cnt < index) {
                ch = (char)((ch - 'a' + 1) % 26 + 'a');
                if (!skip.contains(ch + "")) {
                    cnt++;
                }
            }
            answer += ch;            
        }
        
        return answer;
    }
}