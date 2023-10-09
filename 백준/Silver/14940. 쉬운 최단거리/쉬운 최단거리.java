import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int sx = 0, sy = 0, nx, ny;
    int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
    Queue<int[]> q = new LinkedList<>();
    int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(el -> Integer.parseInt(el)).toArray();
    int[][] map = new int[nm[0]][nm[1]];
    boolean[][] isChecked = new boolean[nm[0]][nm[1]];
    for (int i = 0; i < nm[0]; i++) {
      map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(el -> Integer.parseInt(el)).toArray();
      for (int j = 0; j < nm[1]; j++)
        if (map[i][j] == 2) {
          sx = i;
          sy = j;
        }
    }

    q.offer(new int[] { sx, sy });
    isChecked[sx][sy] = true;
    map[sx][sy] = 0;
    while (!q.isEmpty()) {
      int[] curr = q.poll();
      for (int i = 0; i < 4; i++) {
        nx = curr[0] + dx[i];
        ny = curr[1] + dy[i];
        if (nx > -1 && nx < nm[0] && ny > -1 && ny < nm[1] && !isChecked[nx][ny] && map[nx][ny] == 1) {
          isChecked[nx][ny] = true;
          map[nx][ny] = map[curr[0]][curr[1]] + 1;
          q.offer(new int[] {nx, ny});
        }
      }
    }

    for (int i = 0; i < nm[0]; i++) {
      for (int j = 0; j < nm[1]; j++) {
        sb.append(map[i][j] == 1 && !isChecked[i][j] ? -1 : map[i][j]).append(j!=nm[1]-1 ? " " : "");
      }
      if(i!=nm[0]-1)  sb.append("\n");
    }

    System.out.println(sb.toString());
  }
}
