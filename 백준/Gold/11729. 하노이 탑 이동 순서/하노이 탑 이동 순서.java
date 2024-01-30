import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		hanoi(cnt, 1, 2, 3);
		System.out.println((1<<cnt)-1);
		System.out.println(sb.toString());

	}
	
	private static void hanoi(int cnt, int from, int temp, int to) {
		if(cnt == 0) return;
		
		hanoi(cnt -1, from, to, temp);
		sb.append(from + " " + to + "\n");
		hanoi(cnt-1, temp, from, to);
	}
}