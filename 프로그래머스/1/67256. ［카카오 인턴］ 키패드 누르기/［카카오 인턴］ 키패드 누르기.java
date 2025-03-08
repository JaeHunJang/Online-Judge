class Solution {
    class Pos {
        int r, c;
        Pos(int[] pos) {
            r = pos[0];
            c = pos[1];
        }
    }
    int[][] deltas = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        Pos left = new Pos(new int[]{3,0});
        Pos right = new Pos(new int[]{3,2});
        for (int n : numbers) {
            if (n == 1 || n == 4 || n == 7) {
                left = new Pos(deltas[n]);
                sb.append("L");
            } else if (n == 3 || n == 6 || n == 9) {
                right = new Pos(deltas[n]);
                sb.append("R");
            } else {
                Pos btn = new Pos(deltas[n]);
                int rightDist = convDist(right, btn);
                int leftDist = convDist(left, btn);
                if (rightDist > leftDist) {
                    left = new Pos(deltas[n]);
                    sb.append("L");
                } else if (rightDist < leftDist) {
                    right = new Pos(deltas[n]);
                    sb.append("R");
                } else {
                    if ("right".equals(hand)) {
                        right = new Pos(deltas[n]);
                        sb.append("R");
                    } else {
                        left = new Pos(deltas[n]);
                        sb.append("L");
                    }
                }
            }
        }
        
        return sb.toString();
    }
    
    int convDist(Pos hand, Pos btn) {
        return Math.abs(hand.r - btn.r) + Math.abs(hand.c - btn.c);
    }
}