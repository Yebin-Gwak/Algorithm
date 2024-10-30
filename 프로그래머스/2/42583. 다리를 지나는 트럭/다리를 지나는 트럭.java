import java.util.*;

class Solution {
    static class Truck implements Comparable<Truck>{
        int weight;
        int done;
        
        public Truck(int weight){
            this.weight = weight;
        }
        
        public int compareTo(Truck o){
            return this.weight - o.weight;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Truck> deque = new ArrayDeque<>();
        for(int i = 0; i < truck_weights.length; i++){
            deque.add(new Truck(truck_weights[i]));
        }
        
        ArrayDeque<Truck> ready = new ArrayDeque<>();
        
        int time = 1;
        Truck t = deque.pollFirst();
        t.done = time + bridge_length;
        int limit = t.weight;
        ready.add(t);
        
        while(!deque.isEmpty()){
            time++;
            if(ready.peekFirst().done == time){
                Truck tr = ready.pollFirst();
                limit -= tr.weight;
            }
            
            if(deque.peekFirst().weight + limit <= weight){
                Truck truck = deque.pollFirst();
                truck.done = time + bridge_length;
                ready.addLast(truck);
                limit += truck.weight;
            }
        }
        
        time = ready.peekLast().done;
        return time;
        
    }
}