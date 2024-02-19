import java.util.*;
import java.io.*;

public class Main {
	static int N, L;
	static int[][] map;
	static int[][] sero;
	static int count;
	
	static boolean[] setted;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		sero = new int[N][N];
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sero[i][j] = map[j][i];
			}
		}
		
		for(int i = 0; i < N; i++) {
			checker(map[i]);
			checker(sero[i]);
		}
		
		System.out.println(count);

	}
	
	private static void checker(int[] line) {
		setted = new boolean[N];
		
		for(int i = 0; i < N - 1; i++) {
			int now = line[i];
			int next = line[i + 1];
			if(now == next) continue;
			else if(now == next + 1) { // 다음 땅이 현재 땅보다 1 낮은 경우
				if(!setDown(line, i)) return; // 경사로 설치 실패 시, 해당 line은 통행 불가, 수행 종료
				i += L -1; // 경사로 설치한 땅 길이만큼 인덱스를 이동시켜 다음 땅 검사
			}
			
			else if(now == next -1) { // 다음 땅이 현재 땅보다 1 높은 경우
				if(!setUp(line, i + 1)) return;
			}
			else
				return; // 높이차이가 1보다 큰 경우는 놓을 수 없으므로 종료
			
		}
		
		count++;
		
		
		
	}
	
	private static boolean setUp(int[] line, int start) {
		if(start - L < 0) return false; // 경사로 길이가 인덱스 범위 벗어나면 종료
		int height = line[start]; // 경사로를 설치하는 위치(높은 땅)
		
		for(int i = 1; i <= L; i++) {
			if(line[start - i] + 1 == height && !setted[start - i]) { // 경사로가 설치될 땅을 검사, 높이가 전부 동일해야 하고, 기존에 경사로가 설치되있지 않은 땅이어야 함.
				setted[start - i] = true; //경사로 설치
			}
			else
				return false; // 조건 불충족시 경사로 설치 불가, false 리턴
		}
		
		//경사로 설치 완료 후 true 리턴
		return true;
	}

	private static boolean setDown(int[] line, int start) {
		if(start + L >= N) return false;
		int height = line[start];
		
		for(int i = 1; i <= L; i++) {
			if(line[start + i] == height -1 && !setted[start + i]) {
				setted[start + i] = true;
			}
			else
				return false;
		}
		
		return true;
	}
	
}