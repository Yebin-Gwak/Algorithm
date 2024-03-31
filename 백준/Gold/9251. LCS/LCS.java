import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String data1 = br.readLine();
		char[] arr1 = new char[data1.length()];
		for (int i = 0; i < data1.length(); i++)
			arr1[i] = data1.charAt(i);

		String data2 = br.readLine();
		char[] arr2 = new char[data2.length()];
		for (int i = 0; i < data2.length(); i++)
			arr2[i] = data2.charAt(i);

		int[][] dp = new int[arr2.length + 1][arr1.length + 1];

		for(int i = 1; i <= arr2.length; i++) {
			for(int j = 1; j <= arr1.length; j++) {
				if(arr2[i - 1] == arr1[j - 1]) 
					dp[i][j] = dp[i-1][j-1] + 1;
				else 
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		System.out.println(dp[arr2.length][arr1.length]);
	}

}