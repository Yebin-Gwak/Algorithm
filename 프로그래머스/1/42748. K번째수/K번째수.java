import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int N = commands.length;
        int[] answer = new int[N];
        
        for(int i = 0; i < N; i++){
            ArrayList<Integer> list = new ArrayList<>();
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            for(int j = start; j < end; j++)
                list.add(array[j]);
            Collections.sort(list);
            answer[i] = list.get(commands[i][2] - 1);
        }
        return answer;
    }
}