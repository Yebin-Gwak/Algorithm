import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for(int i = 1000; i <= 10000; i += 100) {
			if(i + (i / 10) == a) {
				System.out.println(i);
				return;
			}
		}
	}
}