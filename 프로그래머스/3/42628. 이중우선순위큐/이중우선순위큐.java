import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String s : operations){
            st = new StringTokenizer(s);
            char c = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken());
            
            if(c == 'I')
                map.put(n, map.getOrDefault(n, 0) + 1);
            else{
                if(map.isEmpty())
                    continue;
                int key = (n == 1) ? map.lastKey() : map.firstKey();
                if(map.get(key) == 1)
                    map.remove(key);
                else
                    map.put(key, map.get(key) - 1);
            }
        }
        
        if(map.isEmpty())
            return new int[]{0, 0};
        return new int[]{map.lastKey(), map.firstKey()};

    }
}