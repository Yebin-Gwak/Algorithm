import java.util.*;

class Solution {
    static int[] diffs;
    static int[] times;
    static long limit;
    
    public int solution(int[] diffs2, int[] times2, long limit2) {
        diffs = diffs2;
        times = times2;
        limit = limit2;
        
        if(diffs.length == 1){
            return 1;
        }
        int answer = 0;
        
        int level = Integer.MAX_VALUE;
        long totalTime = times[0];
        
        int min = 1;
        int[] diffSort = diffs2.clone();
        Arrays.sort(diffSort);
        int max = diffSort[diffSort.length - 1];
        
        while(min <= max){
            int mid = (min + max)/ 2;
            long sum = calc(mid);

            if(sum <= limit){
                level = Math.min(level, mid);
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        

        
        return level;
    }
    
    private static long calc(int level){
        long sum = times[0];
        for(int i = 1; i < diffs.length; i++){
            sum += (diffs[i] <= level) ? times[i] : ((diffs[i] - level) * (times[i - 1] + times[i])) + times[i];
        }
        return sum;
        
    }
}