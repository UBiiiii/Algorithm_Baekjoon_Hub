import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<>();
        int tmp;
        br.readLine();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            tmp = Integer.parseInt(st.nextToken());
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }
        br.readLine();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            tmp = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(tmp, 0));
            if(st.hasMoreTokens()) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
