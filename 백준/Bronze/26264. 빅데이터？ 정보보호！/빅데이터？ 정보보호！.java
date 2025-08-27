import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String s = br.readLine();
		int a = 0;
		int b = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 's')
				a++;
			else if(s.charAt(i) == 'b')
				b++;
		}
		if(a > b)
			System.out.println("security!");
		else if(a < b)
			System.out.println("bigdata?");
		else
			System.out.println("bigdata? security!");
		
	}
}
