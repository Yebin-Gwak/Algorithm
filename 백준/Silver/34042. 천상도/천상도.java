import java.util.*;
import java.io.*;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      StringBuilder sb = new StringBuilder();

      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      for (int i = 0; i < M; i++) {
    	 PriorityQueue<Integer> neg = new PriorityQueue<>();
         st = new StringTokenizer(br.readLine());
         if(N == 1) {
            sb.append(Integer.parseInt(st.nextToken()) + "\n");
            continue;
         }
         long pos = 0;
         
         boolean zero = false;
         for (int j = 0; j < N; j++) {
            int v = Integer.parseInt(st.nextToken());
            if (v == 0)
               zero = true;
            else if (v < 0)
               neg.add(v);
            else {
               if(pos == 0)
                  pos = v;
               else
                  pos *= v;
            }
         }
         
         long sum = 0;
         
         if(pos != 0)
            sum = pos;
         else if(zero)
            sum = 0;
         
         if(sum == 0 && neg.size() >= 2)
        	 sum = neg.poll() * neg.poll();
         
         if(neg.size() >= 2) {
        	 int cnt = neg.size() - (neg.size() % 2);
        	 for (int j = 0; j < cnt; j++)
        		 sum *= neg.poll();
         }
         
         sb.append(sum + "\n");
      }
      System.out.print(sb.toString());
   }
}
