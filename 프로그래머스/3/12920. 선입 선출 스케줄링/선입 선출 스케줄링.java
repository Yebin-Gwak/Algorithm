import java.util.*;

class Solution {
    

    static int[] cores;
    
    public int solution(int n, int[] cores2) {
        cores = cores2;
        
        int min = 0;
        int max = cores[0] * n;
        
        int time = 0;
        int task = 0;
        
        while(min <= max){
            int mid = (min + max) / 2;
            int count = binarySearch(mid);
            
            if(count >= n){
                max = mid - 1;
                task = count;
                time = mid;
            }else{
                min = mid + 1;
            }
            
        }
        task -= n;
      
        for(int i = cores.length - 1; i >= 0; i--){
            if(time % cores[i] == 0){
                if(task == 0){
                    return i + 1;
                }
                task--;
            }
        }
        
        return -1;

        
    }
    
    private int binarySearch(int time){
        int count = cores.length;
        for(int i = 0; i < cores.length; i++){
            count += time / cores[i];
        }
        return count;
    }
}