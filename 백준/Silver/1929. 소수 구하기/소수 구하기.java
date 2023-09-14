import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), tmp = 0;
        boolean[] arr = new boolean[m+1];
        arr[0] = true;
        arr[1] = true;
        for(int i=2;i<=m;i++) if(!arr[i]) {
            if(i>=n && i<=m) {
                if(sb.length()!=0)  sb.append("\n");
                sb.append(i);
            }
            tmp = i;
            while(tmp<=m) {
                arr[tmp] = true;
                tmp += i;
            }
        }
        System.out.println(sb.toString());
    }
}
