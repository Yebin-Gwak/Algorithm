import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int d = 0;
		for(int i = 0; i < 10; i++) {
			int c = Integer.parseInt(br.readLine());
			if(c != 3)
				d = (d + c) % 4;
			else
				d = (d == 0) ? 3 : d - 1;
		}
		
		String[] arr = new String[] {"N", "E", "S", "W"};
		System.out.println(arr[d]);
	}
}
