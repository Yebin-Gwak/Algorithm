import java.util.*;

class Solution {

    public long solution(int n, int[] times2) {
        long min = 1;
        long max = Long.MAX_VALUE;
        for(int m : times2)
            max = Math.min(max, m);
        max *= n;
        long ans = max;
        while(min <= max){
            long mid = (min + max) / 2;
            long cnt = 0;
            for(int m : times2)
                cnt += mid / m;
            if(cnt >= n){
                ans = mid;
                max = mid - 1;
            }else
                min = mid + 1;
        }
        
        return ans;
    }
    

}