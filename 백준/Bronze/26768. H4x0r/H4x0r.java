import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s = s.replaceAll("a", "4");
		s = s.replaceAll("e", "3");
		s = s.replaceAll("i", "1");
		s = s.replaceAll("o", "0");
		s = s.replaceAll("s", "5");
		System.out.println(s);
	}
}