import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			list.add(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N - 1; i++)
			list.remove(st.nextToken());
		
		System.out.println(list.get(0));
		
	}

}