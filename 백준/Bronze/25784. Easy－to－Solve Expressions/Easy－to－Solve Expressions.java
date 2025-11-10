import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		for(int i = 0; i < 3; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int a = arr[0];
		int b = arr[1];
		int c = arr[2];
		if(a + b == c)
			System.out.println(1);
		else if(a * b == c)
			System.out.println(2);
		else
			System.out.println(3);
		
	}
}