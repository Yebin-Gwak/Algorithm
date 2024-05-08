import java.util.*;
import java.io.*;

public class Main {
	static class Counter implements Comparable<Counter>{
		int number;
		int count;
		
		public Counter(int number, int count) {
			this.number = number;
			this.count = count;
		}

		@Override
		public int compareTo(Counter o) {
			if(this.count == o.count)
				return this.number - o.number;
			return this.count - o.count;
		}
	}
	static int N, M, K;
	static int garo = 3;
	static int sero = 3;
	static int[][] arr = new int[101][101];
	static int[] numCount = new int[101];
	static PriorityQueue<Counter> pq = new PriorityQueue<>();
	static Deque<Integer> deque = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 3; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		if(arr[N][M] == K) {
			System.out.println(0);
			return;
		}
		
		int time = 0;
		while(++time <= 100) {
			if(garo >= sero) 
				operR();
			else
				operC();

			if(arr[N][M] == K) {
				System.out.println(time);
				return;
			}
		}
		System.out.println(-1);
	}
	
	private static void operR() {
		int tempSero = 0;
		for(int i = 1; i <= 100; i++) {
			Arrays.fill(numCount, 0);
			for(int j = 1; j <= 100; j++) {
				numCount[arr[i][j]]++;
			}
			
			for(int j = 1; j <= 100; j++) {
				if(numCount[j] != 0)
					pq.add(new Counter(j, numCount[j]));
			}
			
			tempSero = Math.max(tempSero, (pq.size() * 2 > 100) ? 100 : pq.size() * 2);
			Arrays.fill(arr[i], 0);
			for(int j = 1; j <= 100; j += 2) {
				if(pq.isEmpty())
					break;
				Counter c = pq.poll();
				arr[i][j] = c.number;
				arr[i][j + 1] = c.count;
			}
			pq.clear();
		}
		sero = tempSero;
		
	}
	private static void operC() {
		int tempGaro = 0;
		for(int i = 1; i <= 100; i++) {
			
			Arrays.fill(numCount, 0);
			for(int j = 1; j <= 100; j++) {
				numCount[arr[j][i]]++;
			}
			
			for(int j = 1; j <= 100; j++) {
				if(numCount[j] != 0)
					pq.add(new Counter(j, numCount[j]));
			}
			
			tempGaro = Math.max(tempGaro, (pq.size() * 2 > 100) ? 100 : pq.size() * 2);
			for(int k = 1; k <= 100; k++)
				arr[k][i] = 0;
			for(int j = 1; j <= 100; j += 2) {
				if(pq.isEmpty())
					break;
				Counter c = pq.poll();
				arr[j][i] = c.number;
				arr[j + 1][i] = c.count;
			}
			pq.clear();
			
		}
		garo = tempGaro;
		
	}


}