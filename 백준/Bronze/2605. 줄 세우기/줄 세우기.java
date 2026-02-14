import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			list.add(list.size() - Integer.parseInt(st.nextToken()), i + 1);
		
		for(int v : list)
			sb.append(v + " ");
		System.out.println(sb);
		
	}

}