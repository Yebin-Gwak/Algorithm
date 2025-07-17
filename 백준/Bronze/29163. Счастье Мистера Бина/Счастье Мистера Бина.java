import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for(int i = 0; i < N; i++)
			cnt += (Integer.parseInt(st.nextToken()) % 2 == 0) ? 1 : -1;
		System.out.println(cnt > 0 ? "Happy" : "Sad");
	}
}