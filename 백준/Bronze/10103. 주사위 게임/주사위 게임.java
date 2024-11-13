import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int a = 100;
		int b = 100;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			if(f == s) continue;
			if(f > s) b -= f;
			else a -= s;
		}
		
		System.out.println(a + " " + b);
	}
}
