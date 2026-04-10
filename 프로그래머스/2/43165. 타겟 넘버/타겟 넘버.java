class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(target, 0, 0, numbers);
        return answer;
    }
    
    void dfs (int target, int num, int cnt, int[] numbers) {
        if (cnt == numbers.length) {
            if (target == num) answer++;
            return;
        }
                
        dfs(target, num + numbers[cnt], cnt+1, numbers);
        dfs(target, num - numbers[cnt], cnt+1, numbers);
    }
}