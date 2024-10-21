import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int idx = 0;
        
        while(idx != progresses.length){
            while(progresses[idx] < 100){
                for(int i = idx; i < progresses.length; i++){
                    progresses[i] += speeds[i];
                }
            }
            int cnt = 0;
            for(int i = idx; i < progresses.length; i++){
                if(progresses[i] >= 100){
                    cnt++;
                }else break;
            }
            deque.addLast(cnt);
            idx += cnt;
        }
        
        int[] answer = new int[deque.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = deque.pollFirst();
        }
        return answer;
    }
}