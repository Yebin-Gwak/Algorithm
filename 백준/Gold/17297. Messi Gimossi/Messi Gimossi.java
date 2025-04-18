import java.io.*;

public class Main {

	static int[] dp;
	static String s = "Messi Gimossi";
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		dp = new int[1000];
		
		dp[1] = 5;
		dp[2] = 13;
		if(M <= 13) {
	        char c = s.charAt(M - 1);
	        System.out.println(c == ' ' ? "Messi Messi Gimossi" : c);
			return;
		}
		
		int idx = 3;
		for(int i = 3; i < 1000; i++) {
			dp[i] = dp[i - 1] + 1 + dp[i - 2];
			if(dp[i] >= M)
				break;
			idx++;
		}
		
		recur(idx, M);
		
	}
	
	private static void recur(int idx, int v) {
	    if (idx <= 2) {
	        char c = s.charAt(v - 1);
	        System.out.println(c == ' ' ? "Messi Messi Gimossi" : c);
	        return;
	    }
		
	    if (v <= dp[idx - 1])
	        recur(idx - 1, v);
	    else if (v == dp[idx - 1] + 1)
	        System.out.println("Messi Messi Gimossi");
	    else 
	        recur(idx - 2, v - dp[idx - 1] - 1);
		
	}

}
