import java.util.*;

class Solution {
    static int answer = 0;
    static int[] sp = {}, lp = {}, ep = {}, dx={0, 1, 0, -1}, dy={1, 0, -1, 0};
    static char[][] m = {};
    static boolean[][] isVisited = {};
    static Queue<Pos> pq = new PriorityQueue<>();
    
    static class Pos implements Comparable<Pos> {
        int x, y, w;
        
        Pos(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
        
        @Override
        public int compareTo(Pos p) {
            return this.w - p.w;
        }
        
        @Override
        public String toString() {
            return "x: "+x+", y: "+y+", w: "+w;
        }
    }
    
    public int solution(String[] maps) {
        int move = 0;
        char[] row = {};
        m = new char[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++) {
            row = new char[maps[0].length()];
            for(int j=0;j<maps[i].length();j++) {
                row[j]=maps[i].charAt(j);
                switch(row[j]) {
                    case 'S':
                        sp = new int[] {i, j};
                        break;
                    case 'L':
                        lp = new int[] {i, j};
                        break;
                    case 'E':
                        ep = new int[] {i, j};
                        break;
                }
            }
            m[i] = row;
        }
        
        move = bfs(sp, lp);
        if(move==-1)    return -1;
        answer += move;
        
        move = bfs(lp, ep);
        if(move==-1)    return -1;
        answer += move;
        
        return answer;
    }
    
    private static int bfs(int[] sp, int[] ep) {
        int nx = 0, ny = 0;
        isVisited = new boolean[m.length][m[0].length];
        pq.clear();
        
        pq.offer(new Pos(sp[0], sp[1], 0));
        while(!pq.isEmpty()) {
            Pos p = pq.poll();
            if(p.x==ep[0]&&p.y==ep[1])  return p.w;
            
            if(isVisited[p.x][p.y]) continue;
            isVisited[p.x][p.y] = true;
            
            for(int i=0;i<4;i++) {
                nx = p.x + dx[i];
                ny = p.y + dy[i];
                if(nx < 0 || nx > m.length-1
                   || ny < 0 || ny > m[0].length-1
                   || isVisited[nx][ny] || m[nx][ny]=='X'
                )    continue;
                pq.offer(new Pos(nx, ny, p.w+1));
            }
        }
        
        return -1;
    }
}