import java.util.*;
import java.io.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(int i = 0; i < my_string.length(); i++){
            if(set.contains(my_string.charAt(i)))
                continue;
            sb.append(my_string.charAt(i));
        }
        return sb.toString();
    }
}