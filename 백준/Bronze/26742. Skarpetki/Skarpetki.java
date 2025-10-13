import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int b = 0;
		int w = 0;
		for(char c : s.toCharArray()) {
			if(c == 'B')
				b++;
			else if(c == 'C')
				w++;
		}
		System.out.println((b / 2) + (w / 2));
		
	}
}
