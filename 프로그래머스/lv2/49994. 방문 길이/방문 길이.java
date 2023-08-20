import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer=0, x=5, y=5, nx=0, ny=0;
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        Map<Character, Integer> commands = new HashMap<>();
        boolean[][][] map = new boolean[11][11][4];
        
        commands.put('U', 0);
        commands.put('R', 1);
        commands.put('D', 2);
        commands.put('L', 3);
        
        for(String c : dirs.split("")) {
            int d = commands.get(c.charAt(0));
            nx = x+dx[d]; ny = y+dy[d];
            if(nx < 0 || nx > 10 || ny < 0 || ny > 10)  continue;
            if(!map[x][y][d]) {
                map[x][y][d] = true;
                map[nx][ny][(d+2)%4] = true;
                answer++;
            }
            x = nx; y = ny;
        }
        
        return answer;
    }
}