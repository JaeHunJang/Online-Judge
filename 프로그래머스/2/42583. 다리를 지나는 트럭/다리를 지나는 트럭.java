import java.util.*;
class Solution {
    class Truck {
        int w, time;
        Truck(int w, int time) {
            this.w = w;
            this.time = time;
        }
        public String toString() {
            return "w: " + w + ", time: " + time;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> bridge = new ArrayDeque<>();
        Queue<Truck> trucks = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            //bridge.offer(new Truck(0, 0));
        }
        for (int w : truck_weights) {
            trucks.offer(new Truck(w, 0));
        }
        int time = 1, totalW = trucks.peek().w;
        bridge.offer(trucks.poll());
        while (!trucks.isEmpty()) {
            time++;
            for (Truck truck : bridge) {
                truck.time++;
            }
            
            if (bridge.peek().time >= bridge_length) {
                totalW -= bridge.poll().w;
            }
            if (totalW + trucks.peek().w <= weight) {
                totalW += trucks.peek().w;
                bridge.offer(trucks.poll());
            } else {
                bridge.offer(new Truck(0,0));
            }
        }
        
        while(!bridge.isEmpty()) {
            time++;
            for (Truck truck : bridge) {
                truck.time++;
            }
            
            if (bridge.peek().time >= bridge_length) {
                totalW -= bridge.poll().w;
            }
        }
        
        return time;
    }
    
    int totalWeight(Queue<Truck> bridge) {
        return bridge.stream()
            .mapToInt((truck) -> truck.w)
            .sum();
    }
}