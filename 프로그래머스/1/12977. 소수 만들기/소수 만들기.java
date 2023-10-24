class Solution {
    int answer = 0;
    
    void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            print(arr, visited, n);
            return;
        } 

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
    void print(int[] arr, boolean[] visited, int n) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                num += arr[i];
            }
        }
        isPrimeNumber(num);
    }
    
    void isPrimeNumber(int n){
        boolean flag = true;
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0) {
                flag = false;
                break;
            }
        }
        if(flag) answer++;
    }
    
    public int solution(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        
        combination(nums, visited, 0, nums.length, 3);
        
        // 더 짧게 만든 방법
        // for(int i = 0; i < nums.length - 2; i ++){
        //     for(int j = i + 1; j < nums.length - 1; j ++){
        //         for(int k = j + 1; k < nums.length; k ++ ){
        //             isPrimeNumber(nums[i] + nums[j] + nums[k]);
        //         }
        //     }
        // }

        return answer;
    }
}