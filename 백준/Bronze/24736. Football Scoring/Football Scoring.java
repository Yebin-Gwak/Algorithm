import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] arr = new int[2];
		for(int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] += Integer.parseInt(st.nextToken()) * 6;
			arr[i] += Integer.parseInt(st.nextToken()) * 3;
			arr[i] += Integer.parseInt(st.nextToken()) * 2;
			arr[i] += Integer.parseInt(st.nextToken()) * 1;
			arr[i] += Integer.parseInt(st.nextToken()) * 2;
		}
		
		System.out.println(String.format("%d %d", arr[0], arr[1]));
		
	}

}