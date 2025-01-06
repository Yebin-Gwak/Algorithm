class Solution {
    static int[] stones;
    static int k;
    
    public int solution(int[] stones2, int k2) {
        stones = stones2;
        k = k2;
        
        int min = 0;
        int max = 200000002;
        int answer = Integer.MAX_VALUE;
        
        while(min <= max){
            int mid = (min + max) / 2;
            if(binarySearch(mid)){
                answer = mid;
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }
        return answer;
    }
    
    private boolean binarySearch(int count){
        int jump = 0;
        for(int i = 0; i < stones.length; i++){
            if(stones[i] - count + 1 <= 0){
                jump++;
                if(jump >= k){
                    return false;
                }
            }else{
                jump = 0;
            }
        }
        return true;
    }
}