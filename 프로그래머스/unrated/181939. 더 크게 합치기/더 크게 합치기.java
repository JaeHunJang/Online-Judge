class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        int s1 = Integer.parseInt(a + "" + b);
        int s2 = Integer.parseInt(b + "" + a);
        
        answer = s1 >= s2 ? s1 : s2;
        
        return answer;
    }
}