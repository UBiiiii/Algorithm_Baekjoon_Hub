import java.util.Map;
import java.util.HashMap;


class Solution {
    static int idx;
    static char max;
    static String[] head;
    static Map<Character, Integer> map;
    static StringBuilder sb;
    
    public String solution(String number, int k) {
        return greedy(number, 0, k);
    }
    
    private static String greedy(String number, int p, int k) {
        if(k==0)    return number;
        if(p+k==number.length()) return number.substring(0,number.length()-k);
        
        sb = new StringBuilder(number);
        map = new HashMap<>();
        max = '0';
            
        for(int i=0;i<k+1;i++) {
            map.put(number.charAt(p+i), map.getOrDefault(number.charAt(p+i), i));
            max = number.charAt(p+i) - max > 0 ? number.charAt(p+i) : max;
            if(max=='9')    break;
        }
        
        idx = map.get(max);
        sb.replace(p, p+idx, "");

        return greedy(sb.toString(), p+1, k-idx);
    }
}