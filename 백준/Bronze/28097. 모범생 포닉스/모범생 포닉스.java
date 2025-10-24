import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int t = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			t += Integer.parseInt(st.nextToken());
		t += (N - 1) * 8;
		System.out.println(t / 24 + " " + t % 24);
	}
}