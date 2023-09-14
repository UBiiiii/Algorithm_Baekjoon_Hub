import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        List<int[]> lst = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            lst.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        lst.sort((a,b)->a[1]==b[1] ? a[0] - b[0] : a[1] - b[1]);
        for(int i=0;i<lst.size();i++) {
            int[] tmp = lst.get(i);
            sb.append(tmp[0]).append(" ").append(tmp[1]);
            if(i!=lst.size()-1) sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
