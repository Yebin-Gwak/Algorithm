import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i = 0; i < N; i++)
			sum += Integer.parseInt(br.readLine());
		System.out.println(sum);
		
	}
}