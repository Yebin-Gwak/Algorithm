import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[202];
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
			arr[sc.nextInt() + 100]++;
		System.out.println(arr[sc.nextInt() + 100]);
	}
}