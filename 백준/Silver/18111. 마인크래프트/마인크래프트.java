import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m, b, sum = 0, h = 0, time = 0, tmp = 0;
        int[][] map;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }

        h = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > h)
                    time += 2 * (map[i][j] - h);
                else
                    time += h - map[i][j];
            }
        }

        while (true) {
            h += 1;
            if(h*n*m > sum+b)   break;
            tmp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > h)
                        tmp += 2 * (map[i][j] - h);
                    else
                        tmp += h - map[i][j];
                }
            }
            if(tmp <= time)  time = tmp;
            else            break;
        }

        System.out.println(time + " " + (h-1));
    }
}
