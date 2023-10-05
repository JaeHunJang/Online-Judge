class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String[] nums = {"zero:0", "one:1", "two:2", "three:3", "four:4", "five:5", "six:6", "seven:7", "eight:8", "nine:9"};
        
        for(String n : nums){
            numbers = numbers.replaceAll(n.split(":")[0], n.split(":")[1]);
        }
        
        return Long.parseLong(numbers);
    }
}