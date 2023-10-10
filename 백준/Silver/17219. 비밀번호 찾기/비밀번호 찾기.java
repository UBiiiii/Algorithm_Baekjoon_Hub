import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Map<String, String> map = new HashMap<>();
    int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(el -> Integer.parseInt(el)).toArray();
    for (int i = 0; i < nm[0]; i++) {
      String[] input = br.readLine().split(" ");
      map.put(input[0], input[1]);
    }

    for (int i = 0; i < nm[1]; i++)
      sb.append(map.get(br.readLine())).append(i != nm[1] - 1 ? "\n" : "");
    System.out.println(sb.toString());
  }
}
