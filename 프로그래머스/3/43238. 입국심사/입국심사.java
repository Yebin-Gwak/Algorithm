import java.util.*;
// 3:00

class Solution {
    static int N;
    static int[] times;
    public long solution(int n, int[] times2) {
        N = n;
        times = times2;
        
        Arrays.sort(times2);
        long MAX_VALUE = 1000000000;
        long min = 0;
        long max = MAX_VALUE * MAX_VALUE;
        long answer = 0;
        
        while(min <= max){
            long mid = (min + max) / 2;
            long pass = binarySearch(mid);
            
            if(pass >= n){
                answer = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
  
        return answer;
    }
    
    private long binarySearch(long time){
        long pass = 0;
        for(int i = 0; i < times.length; i++){
            pass += time / (long) times[i];
        }
        return pass;
    }
}