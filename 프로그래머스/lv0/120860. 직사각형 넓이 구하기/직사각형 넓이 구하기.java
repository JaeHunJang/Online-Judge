import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        int x = 0;
        int y = 0;
        Arrays.sort(dots, Comparator.comparingInt(x1 -> x1[0]));
        x =  Math.abs(Math.max(dots[0][1], dots[1][1]) - Math.min(dots[0][1], dots[1][1]));
        Arrays.sort(dots, Comparator.comparingInt(x1 -> x1[1]));
        y = Math.abs(Math.max(dots[0][0], dots[1][0]) - Math.min(dots[0][0], dots[1][0]));

        return  x * y;
    }
}