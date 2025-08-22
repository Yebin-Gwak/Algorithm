import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++)
			N -= Integer.parseInt(st.nextToken());
		System.out.println(N <= 0 ? "Padaeng_i Happy" : "Padaeng_i Cry");
	}
}
