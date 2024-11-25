import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashMap<Character, Character>[] map = new HashMap[3];
        map[1] = new HashMap<>();
        map[2] = new HashMap<>();
        
        map[1].put('d', 'q');
        map[1].put('b', 'p');
        map[1].put('q', 'd');
        map[1].put('p', 'b');
        
        map[2].put('d', 'b');
        map[2].put('b', 'd');
        map[2].put('q', 'p');
        map[2].put('p', 'q');
        
        for(int i = 0; i < n; i++) {
        	String s = br.readLine();
        	
        	for(int j = 0; j < n; j++) {
        		sb.append(map[m].get(s.charAt(j)));
        	}
        	sb.append("\n");
        }
        System.out.println(sb.toString());
        
    }
}