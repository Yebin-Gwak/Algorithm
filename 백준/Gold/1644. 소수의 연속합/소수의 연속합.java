import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int range = 4000000;
		boolean[] arr = new boolean[range + 1];
		int[] primeNums = new int[283148];
		int idx = 1;
		for(int i = 2; i <= range; i++) {
			if(!arr[i]) {
				primeNums[idx++] = i;
				for(int j = 2 * i; j <= range; j += i) {
					arr[j]= true;
				}
			}
		}
		primeNums[283147] = Integer.MAX_VALUE;
		
		int N = Integer.parseInt(br.readLine());
		int start = 1;
		int end = 1;
		int answer = 0;
		long sum = 2;
		while(true) {
			if(primeNums[start] > N)
				break;
				
			if(sum < N) 
				sum += primeNums[++end];
			else if(sum > N)
				sum -= primeNums[start++];
			else if(sum == N) {
				answer++;
				sum += primeNums[++end];
			}
			
		}
		System.out.println(answer);

	}

}