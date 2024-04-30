import java.util.*;
import java.io.*;

class Solution {
    // 8:20
    static HashSet<Integer> list = new HashSet<>();
    static List<String> bannedList = new ArrayList<>();
    static int N, M;
    static boolean[] visited;
    static boolean[] visited2;
    
    static String[] userList;
    static String[] trashList;
    
    static List<Integer>[] possibleList;
    
    
    static int answer = 0;
    public int solution(String[] user_id, String[] banned_id) {
        N = user_id.length;
        M = banned_id.length;

        visited = new boolean[N];
        visited2 = new boolean[M];
        
        possibleList = new ArrayList[N];
        for(int i = 0; i < N; i++)
        	possibleList[i] = new ArrayList<Integer>();
        
        userList = user_id;
        trashList = banned_id;
        initPossibleList();
        comb(0);
        
        
        return list.size();
    }
    
    private static void initPossibleList(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                validCheck(i, j);
            }
        }
    }
    
    private static void comb(int cnt){
        if(cnt == M){
            calc(visited.clone());
            return;
        }
        for(int i = 0; i < possibleList[cnt].size(); i++) {
            int v = possibleList[cnt].get(i);
            if(visited[v]) continue;
            visited[v] = true;
            comb(cnt + 1);
            visited[v] = false;
        }
        /*
        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            for(int j = 0; j < M; j++){
                if(visited2[j]) continue;
                visited2[j] = true;
                if(possibleList[j].contains(i)){
                    comb(cnt + 1);
                }
                visited2[j] = false;
            }
            visited[i] = false;
        }*/
    }
    
    private static boolean validCheck(int a, int b){
        String user = userList[a];
        String trash = trashList[b];
        
        if(user.length() != trash.length())
            return false;
        for(int i = 0; i < user.length(); i++){
            if(trash.charAt(i) == '*') continue;
            if(user.charAt(i) != trash.charAt(i))
                return false;
        }
        possibleList[b].add(a);
        return true;
    }
    
    private static void calc(boolean[] result){
        int mul = 10000000;
        int sum = 0;
        
        for(boolean x : result){
            if(x)
                sum += mul;
            mul /= 10;
        }
        
        list.add(sum);

    }
}