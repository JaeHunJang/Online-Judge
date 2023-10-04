class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int temp = Integer.MAX_VALUE;
        
        for(int i = 0; i < array.length; i++){
            int calc = Math.abs(array[i] - n);
            if(calc < temp){
                answer = array[i];
                temp = calc;
            } else if (calc == temp) {
                answer = Math.min(array[i], answer);
            }
        }
        
        return answer;
    }
}