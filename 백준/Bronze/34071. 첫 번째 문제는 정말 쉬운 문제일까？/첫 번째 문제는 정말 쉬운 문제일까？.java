import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int first = Integer.parseInt(br.readLine());
		int min = first;
		int max = first;
		
		for(int i = 0; i < N - 1; i++) {
			int v = Integer.parseInt(br.readLine());
			min = Math.min(min, v);
			max = Math.max(max, v);
		}
		if(first == min)
			System.out.println("ez");
		else if(first == max)
			System.out.println("hard");
		else
			System.out.println("?");
	}
}