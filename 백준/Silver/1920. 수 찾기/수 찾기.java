import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer, Boolean> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            map.put(Integer.parseInt(st.nextToken()), true);
        }
        br.readLine();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            System.out.println(map.getOrDefault(Integer.parseInt(st.nextToken()), false) ? 1 : 0);
        }
    }
}
