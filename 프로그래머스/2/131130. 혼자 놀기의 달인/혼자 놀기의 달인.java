import java.util.*;

class Solution {
    
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] cards;
    
    public int solution(int[] cards2) {
        cards = cards2;
        visited = new boolean[cards.length];
        for(int i = 0; i < cards.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(1, i);
            }
        }
        
        Collections.sort(list);
        if(list.size() == 1)
            return 0;
        return list.get(list.size() - 1) * list.get(list.size() - 2);
        
    }
    
    private static void dfs(int count, int idx){
        if(visited[cards[idx] - 1]){
            list.add(count);
            return;
        }
        
        visited[cards[idx] - 1] = true;
        dfs(count + 1, cards[idx] - 1);
        
    }
    
}