import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Set<Long> set = new HashSet<>();
    Map<Long, Integer> map = new HashMap<>();
    int n = Integer.parseInt(br.readLine());
    long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(el->Long.parseLong(el)).toArray();
    for(long i : input) set.add(i);
    Long[] sorted = Arrays.stream(set.toArray(Long[]::new)).sorted().toArray(Long[]::new);
    for(int i=0;i<sorted.length;i++)  map.put(sorted[i], i);
    for(int i=0;i<n;i++) sb.append(map.get(input[i])).append(i!=n-1?" ":"");

    System.out.println(sb.toString());
  }
}
