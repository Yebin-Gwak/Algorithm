import java.io.*;
import java.util.*;

public class Main {
	
	static int[] min = new int[26];
	static int[] sum = new int[26];
	static int[] nums = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String s = br.readLine();
		nums[0] = 'A' - 'A';
		nums[1] = 'C' - 'A';
		nums[2] = 'G' - 'A';
		nums[3] = 'T' - 'A';
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			min[nums[i]] = Integer.parseInt(st.nextToken());
		}
		
		sum = new int[26];
		for(int i = 0; i < M; i++) {
			sum[s.charAt(i) - 'A']++;
		}
		
		int ans = check();
		for(int i = 0; i < N - M; i++) {
			sum[s.charAt(i) - 'A']--;
			sum[s.charAt(i + M) - 'A']++;
			ans += check();
		}
		
		System.out.println(ans);
	}

	private static int check() {
		for(int i = 0; i < 4; i++) {
			if(sum[nums[i]] < min[nums[i]]) {
				return 0;
			}
		}
		return 1;
	}
}