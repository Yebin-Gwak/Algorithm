import java.io.*;
import java.util.*;

public class Main {

	static long A, B, C, D, K;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		C = Long.parseLong(st.nextToken());
		D = Long.parseLong(st.nextToken());
		K = Long.parseLong(br.readLine());
		
		if(K == 0) {
			long toka = A / B + ((A % B == 0) ? 0 : 1);
			long dol = (A + C) / D + (((A + C) % D == 0) ? 0 : 1);
			System.out.println((toka < dol) ? toka : -1);
			return;
		}
		
		long min = 0;
		long max = B / K + ((B % K == 0) ? 0 : 1);
		long ans = -1;
		
		while(min <= max) {
			long mid = (min + max) / 2 + (min + max) % 2;
			long toka = mid * (2 * B - K * (mid - 1)) / 2;
			
			if(toka >= A) {
				max = mid - 1;
				ans = mid;
			}else {
				min = mid + 1;
			}
		}
		long dol = ans * D;
		
		System.out.println((dol >= A + C) ? -1 : ans);
		
	}

}