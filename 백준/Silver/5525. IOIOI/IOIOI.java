import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m, start = -1, end = -1, answer = 0;
    List<String> lst = new ArrayList<>();
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    String input = br.readLine();
    for (int i = 0; i < m; i++) {
      char tmp = input.charAt(i);
      if (tmp == 'I') {
        if (i<m-1&&input.charAt(i + 1) == 'O')
          if (start == -1)
            start = i;
          else
            continue;
        else {
          if (start != -1) {
            end = i;
            lst.add(input.substring(start, end + 1));
            start = -1;
            end = -1;
          }
        }
      } else {
        if(i<m-1&&input.charAt(i+1)=='O'&&start!=-1) {
          end = i-1;
          lst.add(input.substring(start, end + 1));
          start = -1;
          end = -1;
        } else if (i==m-1&&start!=-1) {
          end = i-1;
          lst.add(input.substring(start, end + 1));
          start = -1;
          end = -1;
        }
      }
    }

    for(String s : lst) if(s.length() >= 2*n+1) {
      int tmp = s.length() - (2*n+1);
      answer += tmp/2+1;
    }

    System.out.println(answer);
  }

}
