class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            if("right".equals(direction))
                answer[(i + 1) % numbers.length] = numbers[i];
            else
                answer[i == 0 ? numbers.length - 1 : i - 1] = numbers[i];
        }
        
        return answer;
    }
}