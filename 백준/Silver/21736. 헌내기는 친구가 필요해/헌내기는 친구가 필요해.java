import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sx = 0, sy = 0, answer = 0, nx =0, ny=0;
    Queue<int[]> q = new LinkedList<>();
    int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
    int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(el -> Integer.parseInt(el)).toArray();
    char[][] map = new char[nm[0]][nm[1]];
    for (int i = 0; i < nm[0]; i++) {
      map[i] = br.readLine().toCharArray();
      for (int j = 0; j < nm[1]; j++)
        if (map[i][j] == 'I') {
          sx = i;
          sy = j;
        }
    }

    q.offer(new int[] {sx, sy});
    map[sx][sy] = 'X';

    while(!q.isEmpty()) {
      int[] curr = q.poll();
      for(int i=0;i<4;i++)  {
        nx = curr[0]+dx[i];
        ny = curr[1]+dy[i];
        if(nx>-1&&nx<nm[0]&&ny>-1&&ny<nm[1]&&map[nx][ny]!='X')  {
          q.offer(new int[] {nx, ny});
          if(map[nx][ny]=='P')  answer++;
          map[nx][ny] = 'X';
        }
      }
    }

    System.out.println(answer>0?answer:"TT");

  }
}
