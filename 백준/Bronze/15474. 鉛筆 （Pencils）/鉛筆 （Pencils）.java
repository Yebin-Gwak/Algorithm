import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		a = (N / a) + (N % a == 0 ? 0 : 1);
		c = (N / c) + (N % c == 0 ? 0 : 1);
		
		System.out.println(Math.min(a * b, c * d));
		
	}
}