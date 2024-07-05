import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int[][] energy;
	static int[][] robot;
	static int[][] extra;
	
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static PriorityQueue<Integer>[][] pq;
	static List<Integer> temp = new ArrayList<Integer>();
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		energy = new int[N][N];
		robot = new int[N][N];
		extra = new int[N][N];
		for(int i = 0; i < N; i++)
			Arrays.fill(energy[i], 5);
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				robot[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pq = new PriorityQueue[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				pq[i][j] = new PriorityQueue<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			pq[x][y].add(age);
		}
		
		
		for(int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		
		System.out.println(calc());
		
	}
	private static int calc() {
		int answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				answer += pq[i][j].size();
		}
		return answer;
	}
	private static void spring() {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				temp.clear();
				while(!pq[i][j].isEmpty()) {
					int tree = pq[i][j].poll();
					if(tree > energy[i][j]) {
						pq[i][j].add(tree);
						break;
					}else {
						energy[i][j] -= tree;
						temp.add(tree + 1);
					}
				}
				while(!pq[i][j].isEmpty()) {
					extra[i][j] += pq[i][j].poll() / 2;
				}
				
				for(int tree : temp)
					pq[i][j].add(tree);
			}
		}
		
	}
	
	private static void summer() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(extra[i][j] != 0)
				energy[i][j] += extra[i][j];
				extra[i][j] = 0;
			}
		}
	}
	
	private static void fall() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!pq[i][j].isEmpty()) {
					for(int tree : pq[i][j]) {
						if(tree % 5 == 0) {
							for(int k = 0; k < 8; k++) {
								int nx = i + dx[k];
								int ny = j + dy[k];
								if(0 <= nx && nx < N && 0 <= ny && ny < N)
									pq[nx][ny].add(1);
							}
						}
					}
					
				}
			}
		}
	}
	
	private static void winter() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				energy[i][j] += robot[i][j];
			}
		}
		
	}

}