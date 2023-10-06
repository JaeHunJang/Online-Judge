import java.util.*;
class Solution {
    public int[][] solution(int n) {        
        
        return hanoi(n, 1, 3).toArray(new int[0][]);
    }
    
    private List<int[]> hanoi(int n, int from, int to){
        if(n == 1) return List.of(new int[] {from, to});
        int empty = 6 - from - to;
        
        List<int[]> list = new ArrayList();
        
        list.addAll(hanoi(n-1, from, empty));
        list.addAll(hanoi(1, from, to));
        list.addAll(hanoi(n-1, empty, to));
            
        return list;
    }
}