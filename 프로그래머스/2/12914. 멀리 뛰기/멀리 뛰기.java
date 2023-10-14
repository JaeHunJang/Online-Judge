class Solution {
    public long solution(int n) {
        //피보나치 수열 1|1, 2|2, 3|3, 4|5, 5|8, 6|13
        int[] arr = new int[n];
        arr[0] = 1;
        
        if(n > 1){
            arr[1] = 2;
            for(int i = 2; i < arr.length; i++){
                arr[i] = (arr[i-1] + arr[i-2]) % 1234567;
            }
        }
        
        return arr[n-1];
    }
}