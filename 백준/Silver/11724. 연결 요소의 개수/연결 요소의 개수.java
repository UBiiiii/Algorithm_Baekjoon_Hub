import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, cnt;
	static ArrayList<Integer>[] adjList;
	static boolean[] isVisited;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[n];
		isVisited = new boolean[n];
		cnt = 0;
		
		for(int i=0;i<n;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adjList[u-1].add(v-1);
			adjList[v-1].add(u-1);
		}
		
		for(int i=0;i<n;i++) {
			if(isVisited[i]) continue;
			
			BFS(i);
			
			cnt++;
		}
		
		System.out.println(cnt);
		
	}
	
	private static void BFS(int startNode) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(startNode);
		isVisited[startNode] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int node : adjList[curr]) {
				if(isVisited[node]) continue;
				q.offer(node);
				isVisited[node] = true;
			}
		}
	}

}
