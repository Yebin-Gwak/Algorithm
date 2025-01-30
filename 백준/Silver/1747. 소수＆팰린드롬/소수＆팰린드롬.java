import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int L = 10000000;
		boolean[] prime = new boolean[L + 1];
		prime[1] = true;
		for(int i = 2; i <= Math.sqrt(L); i++) {
			if(prime[i]) continue;
			for(int j = i * 2; j <= L; j += i)
				prime[j] = true;
		}
		
		for(int i = N; i <= L; i++) {
			if(prime[i]) continue;
			if(check(i)) {
				System.out.println(i);
				return;
			}
		}
	}

	private static boolean check(int n) {
		String s = Integer.toString(n);
		for(int i = 0; i < s.length() / 2; i++) {
			if(s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
	}
}
