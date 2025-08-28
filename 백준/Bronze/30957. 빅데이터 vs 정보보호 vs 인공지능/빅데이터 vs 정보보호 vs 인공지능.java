import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[26];
		int N = Integer.parseInt(br.readLine());
		String w = br.readLine();
		for(int i = 0; i < N; i++)
			arr[w.charAt(i) - 'A']++;
		int a = arr[0];
		int b = arr[1];
		int s = arr[18];
		
        if (a == b && b == s) {
            System.out.println("SCU");
            return;
        }

        int max = Math.max(a, Math.max(b, s));
        if (b == max) sb.append('B');
        if (s == max) sb.append('S');
        if (a == max) sb.append('A');
        System.out.println(sb.toString());
		
	}
}