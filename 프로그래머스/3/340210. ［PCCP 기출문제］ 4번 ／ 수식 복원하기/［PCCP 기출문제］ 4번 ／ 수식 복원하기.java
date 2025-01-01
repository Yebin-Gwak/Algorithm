import java.util.*;
import java.io.*;


class Solution {
    
    static class Problem{
        String a;
        char op;
        String b;

        String result;
        
        public Problem(String a, char op, String b, String result){
            this.a = a;
            this.op = op;
            this.b = b;
            this.result = result;
        }
    }
    
    static StringTokenizer st;
    
    static boolean[] radix = new boolean[10];
    static ArrayList<Problem> normal = new ArrayList<>();
    static ArrayList<Problem> hidden = new ArrayList<>();
    
    public String[] solution(String[] expressions) throws Exception{    
        separate(expressions);
        
        Arrays.fill(radix, true);
        
        // 가능 진법 체크
        validateDefaultRadix();
        
        // 결과값 대조
        findAnswer();

        String[] answer = new String[hidden.size()];
        
        for(int i = 0; i < hidden.size(); i++){
            Problem p = hidden.get(i);
            answer[i] = p.a + " " + p.op + " " + p.b + " = " + p.result;
        }
        
        return answer;
    }
    
    private static void separate(String[] arr){
        for(int i = 0; i < arr.length; i++){
            st = new StringTokenizer(arr[i]);
            String a = st.nextToken();
            char op = st.nextToken().charAt(0);
            String b = st.nextToken();
            st.nextToken();
            String result = st.nextToken();
            
            if(result.equals("X")){
                hidden.add(new Problem(a, op, b, "?"));
            }else{
                normal.add(new Problem(a, op, b, result));
            }
        }
    }
    
    private static void validateDefaultRadix(){
        w : for(int i = 2; i <= 9; i++){
            for(Problem p : normal){
                if(!radixCheck(p.a, i) || !radixCheck(p.b, i) || !radixCheck(p.result, i)){
                    radix[i] = false;
                    continue w;
                }
                
                int a = Integer.parseInt(p.a, i);
                int b = Integer.parseInt(p.b, i);
                int result = Integer.parseInt(p.result, i);
                if(p.op == '+' && (a + b != result)){
                    radix[i] = false;
                    continue w;
                }
                else if(p.op == '-' && (a - b != result)){
                    radix[i] = false;
                    continue w;
                }
            }
            
            for(Problem p : hidden){
                if(!radixCheck(p.a, i) || !radixCheck(p.b, i)){
                    radix[i] = false;
                    continue w;
                }
            }
            
        }
    }
    
    private static boolean radixCheck(String s, int radix){
        for(int i = 0; i < s.length(); i++){
            int n = s.charAt(i) - '0';
            if(n >= radix){
                return false;
            }
        }
        return true;
        
    }
    
    
    private static int transferTo10Radix(String n, int radix) throws Exception{
        try{
            return Integer.parseInt(n, radix);
    
        }catch(Exception e){
            return 10;
        }
    }
    
    private static void findAnswer() throws Exception{
        w : for(Problem p : hidden){
            String check = "";
            for(int i = 2; i <= 9; i++){
                if(!radix[i]) continue;
                
                int a = Integer.parseInt(p.a, i);
                int b = Integer.parseInt(p.b, i);
                int sum = (p.op == '+') ? a + b : a - b;
                String result = Integer.toString(sum, i);
                
                if(check.equals("")){
                    check = result;
                }else{
                    if(!check.equals(result)){
                        continue w;
                    }
                }
            }
            p.result = check;
        }
    }
    
}