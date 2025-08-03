import java.io.*;
import java.util.*;

public class Main {
	
	static class SegTree{
		int N;
		int[] min;
		int[] max;
		int[] lazy;
		int[] lastQ;
		int[] result;
		
		int INF = Integer.MAX_VALUE;
		
		SegTree(int[] arr){
			N = arr.length;
			min = new int[N * 4];
			max = new int[N * 4];
			lazy = new int[N * 4];
			lastQ = new int[N * 4];
			Arrays.fill(lazy, INF);
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
		
		void update(int left, int right, int v, int qID) {
			update(1, 1, N, left, right, v, qID);
		}
		
		// left   start    end    right
		void update(int idx, int start, int end, int left, int right, int v, int qID) {
			propagate(idx, start, end);
			if(start > right || end < left)
				return;
			if(left <= start && end <= right) {
				if(max[idx] < v)
					return;
				if(v < min[idx]) {
					lazy[idx] = v;
					lastQ[idx] = qID;
					propagate(idx, start, end);
					return;
				}
				if(start == end)
					return;
			}
			int mid = (start + end) / 2;
			update(idx * 2, start, mid, left, right, v, qID);
			update(idx * 2 + 1, mid + 1, end, left, right, v, qID);
			min[idx] = Math.min(min[idx * 2], min[idx * 2 + 1]);
			max[idx] = Math.max(max[idx * 2], max[idx * 2 + 1]);
		}

		private void propagate(int idx, int start, int end) {
			if(lazy[idx] == INF)
				return;
			if(start != end) {
				lazy[idx * 2] = lazy[idx];
				lazy[idx * 2 + 1] = lazy[idx];
				min[idx * 2] = lazy[idx];
				min[idx * 2 + 1] = lazy[idx];
				max[idx * 2] = lazy[idx];
				max[idx * 2 + 1] = lazy[idx];
				lastQ[idx * 2] = lastQ[idx];
				lastQ[idx * 2 + 1] = lastQ[idx];
			}
			min[idx] = lazy[idx];
			max[idx] = lazy[idx];
			lazy[idx] = INF;
			
		}
		
		public int[] getResult(int Q) {
			result = new int[Q];
			for(int i = 1; i <= N; i++)
				query(1, 1, N, i);
			
			return result;
		}
		
		public void query(int idx, int start, int end, int target) {
			propagate(idx, start, end);
			if(start == end) {
				sb.append(min[idx]).append(" ");
				result[lastQ[idx]]++;
				return;
			}
			int mid = (start + end) / 2;
			if(target <= mid)
				query(idx * 2, start, mid, target);
			else
				query(idx * 2 + 1, mid + 1, end, target);
		}
		
		
	}

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(br.readLine());
		
		SegTree segTree = new SegTree(arr);
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			segTree.update(left, right, v, i);
		}
		
		int[] result = segTree.getResult(Q);
		sb.append("\n");
		int sum = 0;
		for(int i = 0; i < Q; i++) {
			sum += result[i];
			sb.append(sum).append(" ");
		}
		
		System.out.print(sb.toString());
		
	}
}
