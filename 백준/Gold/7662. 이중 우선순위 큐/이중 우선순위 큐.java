import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine()), k, curr, tmp;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      k = Integer.parseInt(br.readLine());
      map.clear();

      for(int j=0; j<k; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        if(st.nextToken().charAt(0)=='I') {
          curr = Integer.parseInt(st.nextToken());
          map.put(curr, map.getOrDefault(curr, 0)+1);
        }

        else {
          if(map.size()==0) continue;

          if(st.nextToken().length()==2) {
            tmp = map.firstKey();
            if(map.get(tmp)==1)  map.remove(tmp);
            else        map.put(tmp, map.get(tmp)-1);
          } else {
            tmp = map.lastKey();
            if(map.get(tmp)==1)  map.remove(tmp);
            else        map.put(tmp, map.get(tmp)-1);
          }
          
        }
      }

      if(map.keySet().size()==0)  sb.append("EMPTY");
      else                        sb.append(map.lastKey()).append(" ").append(map.firstKey());

      if(i!=n-1)  sb.append("\n");
    }

    System.out.println(sb.toString());
  }
}
