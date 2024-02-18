import java.util.*;
import java.io.*;

public class Main {
	static int[] durable;
	static boolean[] robot;

	static int N, K;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		durable = new int[2 * N];
		robot = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++)
			durable[i] = Integer.parseInt(st.nextToken());

		while(true) {
			ans++;
			move();
			downCheck();

			walk();
			downCheck();

			upCheck();
			if(!replay()) break;
		}

		System.out.println(ans);
	}

	private static void move() {
		int temp = durable[(2 * N) - 1];

		for (int i = 2 * N - 1; i > 0; i--) {
			durable[i] = durable[i - 1];
		}
		durable[0] = temp;

		
		for (int i = N - 1; i > 0; i--)
			robot[i] = robot[i - 1];
		robot[0] = false;
		
	}

	private static void walk() {
		for (int i = N - 2; i >= 0; i--) {
			if (robot[i] && !robot[i + 1] && durable[i + 1] > 0) {
				durable[i + 1]--;
				
				robot[i] = false;
				robot[i + 1] = true;
			}
		}

	}

	private static void upCheck() {
		if (durable[0] > 0) {
			durable[0]--;
			robot[0] = true;

		}

	}

	private static void downCheck() {
		if (robot[N - 1] == true)
			robot[N - 1] = false;
	}
	
	private static boolean replay() {
		int cnt = 0;
		for(int i = 0; i < (2 * N); i++) {
			if(durable[i] == 0) cnt++;
			if(cnt >= K)
				return false;
		}
		
		return true;
		
	}

}