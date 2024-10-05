import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			String s = sc.next();
			if(s.contains("S")) {
				System.out.println(s);
				return;
			}	
		}
	}
}