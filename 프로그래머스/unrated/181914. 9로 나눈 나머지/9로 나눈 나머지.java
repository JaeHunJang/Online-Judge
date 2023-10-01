class Solution {
    public int solution(String number) {
        int answer = 0;
        // String[] nums = number.split("");
        // for(String num : nums){
        //     answer += Integer.parseInt(num);
        // }
        char[] nums = number.toCharArray();
        for(char num : nums){
            answer += num - '0';
        }
        return answer % 9;
    }
}