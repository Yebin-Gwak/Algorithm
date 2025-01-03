import java.util.*;

class Solution {
    
    static ArrayDeque<Integer> leftR = new ArrayDeque<>();
    static ArrayDeque<ArrayDeque<Integer>> middleC = new ArrayDeque<>();
    static ArrayDeque<Integer> rightR = new ArrayDeque<>();
    
    public int[][] solution(int[][] rc, String[] operations) {
        int N = rc.length;
        int M = rc[0].length;
        
        for(int i = 0; i < N; i++){
            leftR.addLast(rc[i][0]);
            
            ArrayDeque<Integer> deque =  new ArrayDeque<>();
            for(int j = 1; j < M - 1; j++){
                deque.addLast(rc[i][j]);
            }
            middleC.addLast(deque);
            
            rightR.addLast(rc[i][M - 1]);
        }
        
        for(String s : operations){
            if(s.equals("ShiftRow")){
                shift();
            }else{
                rotate();
            }
        }
        
        int[][] ans = new int[N][M];
        for(int i = 0; i < N; i++){
            ans[i][0] = leftR.pollFirst();
            
            ArrayDeque<Integer> deque = middleC.pollFirst();

            for(int j = 1; j < M - 1; j++){
                ans[i][j] = deque.pollFirst();
            }
            
            ans[i][M - 1] = rightR.pollFirst();
        }
        
        return ans;
    }
    
    private static void shift(){
        leftR.addFirst(leftR.pollLast());
        middleC.addFirst(middleC.pollLast());
        rightR.addFirst(rightR.pollLast());
    }
    
    private static void rotate(){
        middleC.peekFirst().addFirst(leftR.pollFirst());
        rightR.addFirst(middleC.peekFirst().pollLast());
        middleC.peekLast().addLast(rightR.pollLast());
        leftR.addLast(middleC.peekLast().pollFirst());
    }
    
    
}