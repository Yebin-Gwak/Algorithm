import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		long ans = 0L;

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			ans += cnt += (Integer.parseInt(st.nextToken()) == 1) ? 1 : -1;
			
		System.out.println(ans);
		
	}
}