import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for(int i = 0; i < N; i++)
			arr[i] = br.readLine();
		int cnt = 0;
		for(int i = 0; i < N; i++)
			cnt += arr[i].equals(br.readLine()) ? 1 : 0;
		System.out.println(cnt);
	}
}