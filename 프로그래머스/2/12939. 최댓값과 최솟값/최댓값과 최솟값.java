import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        ArrayList<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            int a = Integer.parseInt(st.nextToken());
            list.add(a);
        }
        Collections.sort(list);
        String answer = list.get(0) + " " + list.get(list.size() -1);
        return answer;
    }
}