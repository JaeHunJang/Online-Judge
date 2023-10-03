class Solution {
    public int solution(int n) {
        int answer = 0;
        for (String s : (n + "").split(""))
            answer += Integer.parseInt(s);
        return answer;
    }
}