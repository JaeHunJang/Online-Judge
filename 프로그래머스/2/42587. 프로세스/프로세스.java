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
        LinkedList<Process> list = new LinkedList<>(); //배열에 담긴 걸 Queue에 담음
        LinkedList<Process> list2 = new LinkedList<>(); //우선순위에 따라 정렬된 프로세스 Queue
        
        for(int p : priorities){
            list.add(new Process(p, answer++));
        }
        
        Arrays.sort(priorities); //우선순위 정렬
        
        answer = 1;
        int i = priorities.length-1;
        while(i >= 0){
            Process p = list.poll();

            if(priorities[i] > p.priority) {
                list.add(p);
            } else {
                list2.add(p);
                i--; 
            }
        }
        
        answer = 1; //location 찾기
        for(Process p : list2){
            if(p.index == location) break;
            answer++;
        }
        
        return answer;
    }
}