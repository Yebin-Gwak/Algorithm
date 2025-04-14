import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		
		int korean = (A / C);
		korean += (A % C != 0) ? 1 : 0;
		int math = (B / D);
		math += (B % D != 0) ? 1 : 0;
		
		System.out.println(L - Math.max(korean, math));
	}

}