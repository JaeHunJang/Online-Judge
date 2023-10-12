import java.util.*;
class Solution {
    class Process {
        int priority;
        int index;
        
        Process(int p, int i){
            this.priority = p;
            this.index = i;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Process> list = new LinkedList<>();
        LinkedList<Process> list2 = new LinkedList<>();
        Process find = new Process(priorities[location], location);
        
        for(int p : priorities){
            list.add(new Process(p, answer++));
        }
        
        
        Arrays.sort(priorities);
        
        // for(int i = priorities.length-1; i >= 0; i--){
        //     for(int j = 0; j < list.size(); j++){
        //         Process p = list.poll();
        //     // System.out.println(p.priority + "|" + p.index + "| i : " + i + "| j : " + j);
        //         if(priorities[i] > p.priority) {
        //             list.add(p);
        //         } else {
        //             // list.add(j, p);
        //         }
        //     }
        // }
        // answer = 1;
        int i = priorities.length-1;
        while(i >= 0){
            Process p = list.poll();
        System.out.println(priorities[i]+ " | " + p.priority + "|" + p.index + "|" +(priorities[i] > p.priority));

            if(priorities[i] > p.priority) {
                list.add(p);
            } else {
                list2.add(p);
                i--; 
            }
            
        }
                        // System.out.println("---------------------");

        // }
        
                        System.out.println("---------------------");
        answer = 1;
        for(Process p : list2){
            System.out.println(p.priority + "|" + p.index);
            
            if(p.index == location) break;
            answer++;
        }
        
        return answer;
    }
}