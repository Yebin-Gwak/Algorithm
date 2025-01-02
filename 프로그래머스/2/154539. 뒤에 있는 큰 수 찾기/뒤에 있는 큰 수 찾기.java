import java.util.*;

class Solution {
  
    public int[] solution(int[] numbers) {
        int[] ans = new int[numbers.length];
        ArrayDeque<Integer> left = new ArrayDeque<>();
        
        for(int i = 0; i < numbers.length; i++){
            while(!left.isEmpty() && numbers[left.peekLast()] < numbers[i]){
                ans[left.pollLast()] = numbers[i];
            }
            left.add(i);
        }
        
        for(int i = 0; i < numbers.length; i++){
            if(ans[i] == 0){
                ans[i] = -1;
            }
        }

        return ans;
    }
}