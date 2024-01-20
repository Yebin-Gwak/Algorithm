import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int ans = 0;
		
		String str = br.readLine();
		for(int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - '0';
			if(num == 6 || num == 9) {
				arr[6] += 1;
			}
			else
				arr[num] += 1;
		}
		
		arr[6] = (arr[6] / 2) + (arr[6] % 2);
		
		for(int x : arr) {
			ans = Math.max(ans, x);
		}
		System.out.println(ans);

	}

}