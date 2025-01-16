class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 4; i <= n; i+=3) {
            sb.append("4");
        }
        return sb.toString();
    }
}