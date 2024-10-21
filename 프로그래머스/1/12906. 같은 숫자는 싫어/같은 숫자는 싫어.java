import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++){
            if(deque.isEmpty()){
                deque.addLast(arr[i]);
                System.out.println(arr[i]);
            }else{
                if(deque.peekLast() != arr[i]){
                    deque.addLast(arr[i]);
                }
            }
        }
        int[] answer = new int[deque.size()];
        int idx = 0;
        while(!deque.isEmpty()){
            answer[idx++] = deque.pollFirst();
        }

        int[] d = new int[]{};
        return answer;
    }
}