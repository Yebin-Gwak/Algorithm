import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		if(a >= 3 && b <= 4)
			System.out.println("TroyMartian");
		if(a <= 6 && b >= 2)
			System.out.println("VladSaturnian");
		if(a <= 2 && b <= 3)
			System.out.println("GraemeMercurian");
	}
}