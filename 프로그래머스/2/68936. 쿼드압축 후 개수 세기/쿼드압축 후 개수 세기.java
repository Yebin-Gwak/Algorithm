class Solution {
 
    static int[][] arr;
    static int[] ans = new int[3];
    static int zero = 0;
    static int one = 0;
    
    public int[] solution(int[][] arr2) {
        arr = arr2;
        
        int result = recursion(arr2.length, 0, 0);
        if(result != 2){
            ans[result]++;
        }
        
        
        int[] answer = new int[]{ans[0], ans[1]};
        return answer;
    }
    
    private static int recursion(int size, int x, int y){
        if(size == 2){
            int p1 = arr[x][y];
            int p2 = arr[x][y + 1];
            int p3 = arr[x + 1][y];
            int p4 = arr[x + 1][y + 1];
            if(p1 == p2 && p2 == p3 && p3 == p4){
                return p1;
            }else{
                ans[p1]++;
                ans[p2]++;
                ans[p3]++;
                ans[p4]++;
                return 2;
            }
        }else{
            int sq1 = recursion(size/2, x, y);
            int sq2 = recursion(size/2, x, (y + size/2));
            int sq3 = recursion(size/2, (x + size/2), y);
            int sq4 = recursion(size/2, (x + size/2), (y + size/2));
            if(sq1 == 2 || sq2 == 2 || sq3 == 2 || sq4 == 2){
                ans[sq1]++;
                ans[sq2]++;
                ans[sq3]++;
                ans[sq4]++;
                return 2;
            }else if(sq1 == sq2 && sq2 == sq3 && sq3 == sq4){
                return sq1;
            }else{
                ans[sq1]++;
                ans[sq2]++;
                ans[sq3]++;
                ans[sq4]++;
                return 2;
            }
            
        }

    }
    

}