import java.util.*;

class Solution {

    static HashMap<String, Integer>[] costs = new HashMap[3];
    
    static int[] picks;
    static String[] minerals;
    
    static int ans = Integer.MAX_VALUE;
    
    public int solution(int[] picks2, String[] minerals2) {
        picks = picks2;
        minerals = minerals2;
 
        for(int i = 0; i < 3; i++){
            costs[i] = new HashMap<String, Integer>();
        }
        costs[0].put("diamond", 1);
        costs[0].put("iron", 1);
        costs[0].put("stone", 1);
        
        costs[1].put("diamond", 5);
        costs[1].put("iron", 1);
        costs[1].put("stone", 1);
        
        costs[2].put("diamond", 25);
        costs[2].put("iron", 5);
        costs[2].put("stone", 1);
        
        dfs(0, 0, 0, 0);
        
        return ans;
    }
    
    private static void dfs(int pick, int durable, int turn, int cost){
        if(ans <= cost){
            return;
        }
        if(turn >= minerals.length){
            ans = Math.min(ans, cost);
            return;
        }
        
        if(durable == 0){
            if(picks[0] == 0 && picks[0] == picks[1] && picks[1] == picks[2]){
                ans = Math.min(ans, cost);
                return;
            }
            
            for(int i = 0; i < 3; i++){
                if(picks[i] == 0) continue;
                picks[i]--;
                pick = i;
                dfs(pick, 4, turn + 1, cost + costs[pick].get(minerals[turn]));
                picks[i]++;
            }
        }else{
            dfs(pick, durable - 1, turn + 1, cost + costs[pick].get(minerals[turn]));
        }
        
    } 
}