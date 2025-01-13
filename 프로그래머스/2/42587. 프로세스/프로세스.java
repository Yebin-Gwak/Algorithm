import java.util.*;

class Solution {
    static class Process{
        int idx;
        int priority;
        
        public Process(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        ArrayDeque<Process> deque = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++){
            deque.addLast(new Process(i, priorities[i]));
            pq.add(priorities[i]);
        }
        
        int ans = 0;
        while(true){
            Process now = deque.pollFirst();
            if(now.priority >= pq.peek()){
                ans++;
                pq.poll();
                if(now.idx == location){
                    return ans;
                }
            }else{
                deque.addLast(now);
            }
        }

        // return ans;
    }
}