import java.util.*;

class Solution {
    
    static class Process{
        int idx;
        int requestTime;
        int cost;
        
        public Process(int idx, int requestTime, int cost){
            this.idx = idx;
            this.requestTime = requestTime;
            this.cost = cost;
        }
    }
    
    static PriorityQueue<Process> waitQueue;
    static PriorityQueue<Process> readyQueue;
    static int time = 0;

    public int solution(int[][] jobs) {
        
        waitQueue = new PriorityQueue<>((o1, o2) -> o1.requestTime - o2.requestTime);
        readyQueue = new PriorityQueue<>((o1, o2) -> {
            if(o1.cost == o2.cost){
                if(o1.requestTime == o2.requestTime){
                    return o1.idx - o2.idx;
                }
                return o1.requestTime - o2.requestTime;
            }
            return o1.cost - o2.cost;
        });
        
        for(int i = 0; i < jobs.length; i++){
            waitQueue.add(new Process(i, jobs[i][0], jobs[i][1]));
        }
        
        int ans = 0;
        
        while(true){
            setQueue();
            
            if(readyQueue.isEmpty()){
                time = waitQueue.peek().requestTime;
                setQueue();
            }
            
            Process now = readyQueue.poll();
            time += now.cost;
            ans += time - now.requestTime;
            if(readyQueue.isEmpty() && waitQueue.isEmpty()){
                break;
            }
        }

        return ans / jobs.length;
    }
    
    private static void setQueue(){
        while(!waitQueue.isEmpty() && waitQueue.peek().requestTime <= time){
            readyQueue.add(waitQueue.poll());
        }
        return;  
    }
    
}