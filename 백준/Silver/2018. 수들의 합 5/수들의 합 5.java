import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		int sum = 1;
		int start = 1;
		int end = 1;
		while(end <= N) {
			if(sum == N) {
				ans++;
				end++;
				sum += end;
				continue;
			}
			if(sum < N) {
				end++;
				sum += end;
				continue;
			}
			sum -= start;
			start++;
		}
		System.out.println(ans);
	}
}