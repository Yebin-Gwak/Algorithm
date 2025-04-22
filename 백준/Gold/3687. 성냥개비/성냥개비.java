import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		String[] first = new String[] {"", "", "1", "7", "4", "2", "6", "8"};
		String[] mod = new String[] {"", "10", "1", "200", "20", "2", "6"};
		int[] div = new int[] {0, 1, 0, 2, 1, 0, 0};
		
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			// min
			if(N == 10)
				sb.append("22 ");
			else
				sb.append(((N <= 7) ? first[N] : mod[N % 7] + "8".repeat(Math.max(0, N / 7 - div[N % 7]))) + " ");
			
			// max
			if(N % 2 == 1) {
				sb.append(7);
				N -= 3;
			}
			sb.append("1".repeat(N / 2) + "\n");
		}
		
		System.out.print(sb.toString());
		
	}
}