import java.util.*;

class Solution {
    static class Point{
        int idx;
        int num;
        
        public Point(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }
  
    public int[] solution(int[] numbers) {
        int[] ans = new int[numbers.length];
        
        ArrayDeque<Point> left = new ArrayDeque<>();
        
        for(int i = 0; i < numbers.length; i++){
            int now = numbers[i];
            
            if(left.isEmpty()){
                left.add(new Point(i, now));
                continue;
            }
            
            while(!left.isEmpty()){
                if(left.peekLast().num < now){
                    ans[left.pollLast().idx] = now;
                }else
                    break;
            }

            left.add(new Point(i, now));

        }
        
        for(int i = 0; i < numbers.length; i++){
            if(ans[i] == 0){
                ans[i] = -1;
            }
        }

        return ans;
    }
}