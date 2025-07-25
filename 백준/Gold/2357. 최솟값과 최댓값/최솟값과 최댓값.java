import java.util.*;
import java.io.*;

public class Main {
	
	static class SegTree{
		StringBuilder sb = new StringBuilder();
		int N;
		int[] min;
		int[] max;
		
		int minValue;
		int maxValue;
		
		SegTree(int[] arr){
			N = arr.length;
			min = new int[N * 4];
			max = new int[N * 4];
			
			init(1, 1, N, arr);
		}
		
		void init(int idx, int start, int end, int[] arr) {
			if(start == end) {
				min[idx] = arr[start - 1];
				max[idx] = arr[start - 1];
				return;
			}
			int mid = (start + end) / 2;
			init(idx * 2, start, mid, arr);
			init(idx * 2 + 1, mid + 1, end, arr);
			min[idx] = Math.min(min[idx * 2], min[idx * 2 + 1]);
			max[idx] = Math.max(max[idx * 2], max[idx * 2 + 1]);
		}
		
		public void query(int left, int right) {
			minValue = Integer.MAX_VALUE;
			maxValue = Integer.MIN_VALUE;
			query(1, 1, N, left, right);
			sb.append(minValue).append(" ").append(maxValue).append("\n");
		}
		
		void query(int idx, int start, int end, int left, int right) {
			if(start > right || end < left)
				return;
			if(left <= start && end <= right) {
				minValue = Math.min(minValue, min[idx]);
				maxValue = Math.max(maxValue, max[idx]);
				return;
			}
			int mid = (start + end) / 2;
			query(idx * 2, start, mid, left, right);
			query(idx * 2 + 1, mid + 1, end, left, right);
		}
		
		public String toString() {
			return sb.toString();
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		SegTree segTree = new SegTree(arr);
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			segTree.query(Math.min(a, b), Math.max(a, b));
		}
		
		System.out.print(segTree.toString());
		
		
	}
}
