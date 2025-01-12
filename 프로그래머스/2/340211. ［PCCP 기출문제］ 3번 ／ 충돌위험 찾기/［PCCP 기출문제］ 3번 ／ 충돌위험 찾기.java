import java.util.*;

class Solution {
    int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    Queue<Queue<Pos>> findRoutes;

    class Pos {
        int r, c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pos pos = (Pos) obj;
            return r == pos.r && c == pos.c;
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        findRoutes = new ArrayDeque<>();

        for (int[] route : routes) {
            Queue<Pos> path = new ArrayDeque<>();
            int[] sp = points[route[0] - 1];
            Pos start = new Pos(sp[0], sp[1]);
            path.offer(start);

            for (int i = 1; i < route.length; i++) {
                int[] ep = points[route[i] - 1];
                Pos end = new Pos(ep[0], ep[1]);
                findPath(path, start, end);
                start = end;
            }

            findRoutes.offer(path);
        }

        int maxSteps = findRoutes.stream().mapToInt(Queue::size).max().orElse(0);

        // 충돌 계산
        for (int i = 0; i < maxSteps; i++) {
            Map<Pos, Integer> map = new HashMap<>();
            for (Queue<Pos> route : findRoutes) {
                if (!route.isEmpty()) {
                    Pos step = route.poll();
                    map.put(step, map.getOrDefault(step, 0) + 1);
                }
            }

            for (int count : map.values()) {
                if (count >= 2) answer++;
            }
        }

        return answer;
    }

    void findPath(Queue<Pos> path, Pos start, Pos end) {
        int r = start.r;
        int c = start.c;

        while (r != end.r) {
            if (r < end.r) {
                r++;
            } else {
                r--;
            }
            path.offer(new Pos(r, c));
        }

        while (c != end.c) {
            if (c < end.c) {
                c++;
            } else {
                c--;
            }
            path.offer(new Pos(r, c));
        }
    }
}
