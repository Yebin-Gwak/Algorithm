import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		for(int i = 0; i < 5; i++)
			arr[Integer.parseInt(br.readLine())]++;
		for(int i = 0; i < 10; i++)
			if(arr[i] % 2 == 1)
				System.out.println(i);
		
	}
}