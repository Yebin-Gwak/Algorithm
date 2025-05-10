import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		long N = Long.parseLong(br.readLine());
		long n = (N - 1) * N / 2;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
		    n -= Integer.parseInt(st.nextToken());

		System.out.println(n * -1);
	}

}