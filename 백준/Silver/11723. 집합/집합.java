import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    Map<Integer, Boolean> set = new HashMap<>();
    int tmp, m = Integer.parseInt(br.readLine());
    for(int i=0;i<m;i++) {
      st = new StringTokenizer(br.readLine());
      switch(st.nextToken()) {
        case "add":
          set.put(Integer.parseInt(st.nextToken()), true);
          break;
        case "remove":
          tmp = Integer.parseInt(st.nextToken());
          if(set.getOrDefault(tmp, false)) set.remove(tmp);
          break;
        case "check":
          sb.append(set.getOrDefault(Integer.parseInt(st.nextToken()), false) ? 1 : 0).append("\n");
          break;
        case "toggle":
          tmp = Integer.parseInt(st.nextToken());
          if(set.getOrDefault(tmp, false))  set.remove(tmp);
          else  set.put(tmp, true);
          break;
        case "all":
          for(int j=1;j<=20;j++)  set.put(j, true);
          break;
        case "empty":
          set.clear();
          break;
      }
    }
    if(sb.length()>1) sb.replace(sb.length()-1,sb.length(),"");
    System.out.println(sb.toString());
  }
}

