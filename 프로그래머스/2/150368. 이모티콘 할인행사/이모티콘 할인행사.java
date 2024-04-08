import java.util.*;
import java.io.*;
// 5:30

class Solution {
    static int membership = 0;
    static int money = 0;
    static int userCount;
    static int emoticonCount;
    
    static int[][] userList;
    static int[] emoticonList;
    
    static int[] numbers = {1, 2, 3, 4};
    static int[] input;
    
    static int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        userList = users;
        emoticonList = emoticons;
        
        userCount = users.length;
        emoticonCount = emoticons.length;
        input = new int[emoticons.length];
        
        
        permutation(0);
        
        answer[0] = membership;
        answer[1] = money;
        
        
        return answer;
    }
    
    
    private static void permutation(int cnt){
        if(cnt == emoticonCount){
            calc(input.clone());
            return;
        }
        
        for(int i = 0; i < 4; i++){
            input[cnt] = numbers[i];
            permutation(cnt + 1);
        }
    }
    
    private static void calc(int[] input){
        int join = 0;
        int sell = 0;
        int[] price = new int[emoticonCount];
        for(int i = 0; i < emoticonCount; i++)
            price[i] = emoticonList[i] - (emoticonList[i] / 10 * input[i]);
        
        for(int i = 0; i < userList.length; i++){
            int sum = 0;
            for(int j = 0; j < emoticonList.length; j++){
                if(input[j] * 10 < userList[i][0])
                    continue;
                else
                    sum += price[j];
            }
            if(sum >= userList[i][1])
                join++;
            else
                sell += sum;
        }

        if(join < membership)
            return;
        if(join > membership){
            membership = join;
            money = sell;
            return;
        }
        if(join == membership){
            money = Math.max(money, sell);
        }
            
        
    }
}