import java.util.*;

class Solution {
    static int answer = 1;
    static ArrayList<Integer>[] list;
    static int[] info2;
    static int[][] edges;
    public int solution(int[] info, int[][] edges) {
        for(int i = 0; i < info.length; i++){
            info[i] = (info[i] == 0) ? 1 : -1;
        }
        info2 = info.clone();
        list = new ArrayList[info.length];
        for(int i = 0; i < info.length; i++){
            list[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            int start = e[0];
            int end = e[1];
            list[start].add(end);
        }
        
        ArrayList<Integer> map = new ArrayList<>();
        for(int i = 0; i < list[0].size(); i++){
            map.add(list[0].get(i));
                    
        }
        dfs(map, 0, 1, 1);
        return answer;
    }
    
    private static void dfs(ArrayList<Integer> map, int target, int life, int sheep){
        if(life == 0){
            answer = Math.max(answer, sheep);
            return;
        }
        if(map.size() == 0){
            answer = Math.max(answer, sheep);
            return;
        }
        
        for(Integer next : map){
            ArrayList<Integer> nextMap = new ArrayList<>(map);
            nextMap.remove(next);
            
            for(int i = 0; i < list[next].size(); i++){
                nextMap.add(list[next].get(i));
            }
            int l = info2[next];
            int s = (info2[next] == 1) ? 1 : 0;
            
            dfs(nextMap, next, life + l, sheep + s);
        }
    }
}