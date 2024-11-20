import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for(int i = 0; i < n; i++) {
				sum += Integer.parseInt(st.nextToken());
			}
			System.out.println(sum);
		}
	}
}