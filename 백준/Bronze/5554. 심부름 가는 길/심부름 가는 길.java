import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		for(int i = 0; i < 4; i++)
			a += sc.nextInt();
		System.out.println(a / 60);
		System.out.println(a % 60);
	}
}