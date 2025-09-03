import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] arr = new boolean[26];
		for(int i = 0; i < 3; i++) {
			int c = br.readLine().charAt(0) - 'a';
			if(c >= 0) arr[c] = true;
		}
		System.out.println((arr[10] && arr[11] && arr[15]) ? "GLOBAL" : "PONIX");
	}
}