import java.util.*;


class Solution {
    boolean solution(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.add(1);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pollLast();
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        

        return true;
    }
}