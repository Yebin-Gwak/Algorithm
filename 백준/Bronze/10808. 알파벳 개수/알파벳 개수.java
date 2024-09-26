import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int[] arr = new int[26];
		for(int i = 0; i < n.length(); i++)
			arr[n.charAt(i) - 97]++;
		for(int i = 0; i < 26; i++)
			System.out.print(arr[i] + " ");
	}
}