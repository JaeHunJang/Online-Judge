class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int cnt, int n) {
        if (cnt == numbers.length) {
            if (target == n) answer++;
            return;
        }
        
        dfs(numbers, target, cnt+1, n+numbers[cnt]);
        dfs(numbers, target, cnt+1, n-numbers[cnt]);
    }
}
