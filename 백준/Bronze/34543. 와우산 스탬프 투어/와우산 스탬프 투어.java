import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int score = N * 10;
		if(N >= 3)
			score += 20;
		if(N == 5)
			score += 50;
		if(M > 1000)
			score -= 15;
		System.out.println(Math.max(0, score));
		
	}
}