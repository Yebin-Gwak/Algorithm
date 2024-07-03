import java.util.*;
import java.io.*;

class Solution {
    static HashMap<Character, String> filter = new HashMap<>();
    public int solution(String[] babbling) {
        int answer = 0;
        filter.put('a', "aya");
        filter.put('y', "ye");
        filter.put('w', "woo");
        filter.put('m', "ma");
        
        
        w : for(String data : babbling){
            // 최대 조합 글자 수인 10을 넘어가면 false
            if(data.length() > 10)
                continue;
            
            for(int i = 0; i < data.length(); i+= 0){
                char c = data.charAt(i);
                // 첫글자가 발음 불가능한 글자면 false;
                if(!filter.containsKey(c))
                    continue w;
                
                // 발음할 말이 남은 문자열 길이보다 크다면 false;
                String saying = filter.get(c);
                if(saying.length() > data.length() - i)
                    continue w;
                
                // 발음할 말과 부분 문자열이 일치하지 않다면 false;
                if(!data.substring(i, i + saying.length()).equals(saying))
                    continue w;
                
                i += saying.length();
                
            }
            answer++;
        }
        
        return answer;
    }
}