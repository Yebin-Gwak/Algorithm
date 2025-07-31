import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			System.out.println(Integer.parseInt(st.nextToken()) >= Integer.parseInt(st.nextToken()) ? "MMM BRAINS" : "NO BRAINS");
		}
	}
}