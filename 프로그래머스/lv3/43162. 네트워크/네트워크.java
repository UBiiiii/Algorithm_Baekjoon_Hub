import java.util.*;

class Solution {
    static boolean[] isVisited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        isVisited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(isVisited[i])    continue;
            answer++;
            dfs(i, n, computers);
        }
        return answer;
    }
    
    private void dfs(int i, int n, int[][] computers) {
        isVisited[i] = true;
        for(int j=0; j<n; j++) {
            if(computers[i][j]==1 && !isVisited[j]) dfs(j, n, computers);
        }
    }
}