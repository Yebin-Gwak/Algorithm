import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : participant){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for(String s : completion){
            int n = map.get(s);
            if(n == 1){
                map.remove(s);
            }else{
                map.put(s, n - 1);
            }
        }
        for(String s : map.keySet()){
            return s;
        }
        
        return "";
    }
}