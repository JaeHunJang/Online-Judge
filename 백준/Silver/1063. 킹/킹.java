import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, map[][];
    static int[][] deltas = {{0,1},{0,-1},{-1,0},{1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
    static List<String> dir = List.of("R","L","B","T","RT","LT","RB","LB");
    static class Pos {
        int r, c;

        public Pos(String input) {
            this.r = input.charAt(1) - '1';
            this.c = input.charAt(0) - 'A';
        }

        public String convert() {
            return (char)('A' + c) + "" + (char)('1' + r);
        }

        public void move(int[] d) {
            this.r += d[0];
            this.c += d[1];
        }

        public void rollback(int[] d) {
            this.r -= d[0];
            this.c -= d[1];
        }

        public boolean isMove(int[] d) {
            int nr = d[0] + r;
            int nc = d[1] + c;
            return nr >= 0 && nr < 8 && nc >= 0 && nc < 8;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new int[8][8];
        Pos king = new Pos(st.nextToken());
        Pos stone = new Pos(st.nextToken());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int[] d = deltas[dir.indexOf(br.readLine())];
            if (king.isMove(d)) {
                king.move(d);
                if (king.r == stone.r && king.c == stone.c) {
                    if (stone.isMove(d)) {
                        stone.move(d);
                    } else {
                        king.rollback(d);
                    }
                }
            }
        }

        System.out.println(king.convert());
        System.out.println(stone.convert());
    }
}