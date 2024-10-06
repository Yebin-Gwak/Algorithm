import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.next(), "/");
		int K = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		
		if(D == 0 || (K + A) < D)
			System.out.println("hasu");
		else
			System.out.println("gosu");
	}
}