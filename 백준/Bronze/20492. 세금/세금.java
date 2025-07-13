import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int f = N * 78 / 100;
		int s = (N * 80 / 100) + (N * 20 / 100) * 78 / 100;
		System.out.println(f + " " + s);
	}

}
