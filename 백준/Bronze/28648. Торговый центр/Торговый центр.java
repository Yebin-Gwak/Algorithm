import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int min = 10000;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			min = Math.min(min, sum);
		}
			System.out.println(min);
	}
}
