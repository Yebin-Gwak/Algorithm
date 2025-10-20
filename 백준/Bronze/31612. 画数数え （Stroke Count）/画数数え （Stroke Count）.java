import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String s = br.readLine();
		int cnt = 0;
		for(char c : s.toCharArray()) 
			cnt += (c == 'o') ? 1 : 2;
		System.out.println(cnt);
		
	}
}