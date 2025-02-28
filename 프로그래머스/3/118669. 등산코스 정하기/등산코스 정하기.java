import java.util.*;

class Solution {
    int parents[];
    int nodes[];
    List<Node>[] list;
    class Node {
        int e, w;
        Node (int e, int w) {
            this.e = e;
            this.w = w;
        }
        
        public String toString() {
            return "e: "+ e + ", w: " + w;
        }
    }
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {0, Integer.MAX_VALUE};
        nodes = new int[n+1];
        
        list = new List[n+1];
        for (int i = 0; i < list.length; ++i) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < gates.length; ++i) {
            nodes[gates[i]] = 1;
        }
        for (int i = 0; i < summits.length; ++i) {
            nodes[summits[i]] = 2;
        }

        for (int i = 0; i < paths.length; ++i) {
            int s = paths[i][0];
            int e = paths[i][1];
            int w = paths[i][2];
            if (nodes[s] == 1 || nodes[e] == 2) {
                list[s].add(new Node (e, w));
            } else if (nodes[e] == 1 || nodes[s] == 2) {
                list[e].add(new Node (s, w));
            } else {
                list[s].add(new Node (e, w));
                list[e].add(new Node (s, w));
            }
        }
        
        return bfs(nodes);
    }
    
    int[] bfs(int nodes[]) {
        int indensity[] = new int[list.length];
        Arrays.fill(indensity, Integer.MAX_VALUE);
        Queue<Node> q = new ArrayDeque<>();
        // 출발지 다 넣기
        for (int i = 0; i < nodes.length; ++i) {
            if (nodes[i] == 1) {
                q.offer(new Node(i, 0));
                indensity[i] = 0;
            }
        }
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            
            if (now.w > indensity[now.e]) continue;
            
            for (Node next : list[now.e]) {
                int max = Math.max(indensity[now.e], next.w);
                if (indensity[next.e] > max) {
                    indensity[next.e] = max;
                    q.offer(new Node(next.e, max));
                }
            }
        }
        
        int summit = 0;
        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.length; ++i) {
            if (nodes[i] == 2 && minTime > indensity[i]) {
                summit = i;
                minTime = indensity[i];
            }
        }
        
        return new int[] {summit, minTime};
    }
    
    void make(int n) {
        
    }
    
}