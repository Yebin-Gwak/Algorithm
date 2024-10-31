import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
		arr[1] = 1;
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == b) continue;
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
		for(int i = 1; i <= 3; i++) {
			if(arr[i] == 1) {
				System.out.println(i);
			}
		}
	}
}