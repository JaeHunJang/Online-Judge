class Solution {
    public int solution(String number) {
        int answer = 0;
        String[] nums = number.split("");
        for(String num : nums){
            answer += Integer.parseInt(num);
        }
        return answer % 9;
    }
}