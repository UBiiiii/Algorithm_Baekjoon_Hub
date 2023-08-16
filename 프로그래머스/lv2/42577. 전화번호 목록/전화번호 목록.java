import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Boolean> map = new HashMap<>();
        Arrays.sort(phone_book, (a, b) -> a.length() - b.length());
        for(String phone : phone_book) {
            for(int i=1;i<phone.length();i++) {
                if(map.containsKey(phone.substring(0, i)))  {
                    return false;
                }
            }
            map.put(phone, false);
        }
        return true;
    }
}