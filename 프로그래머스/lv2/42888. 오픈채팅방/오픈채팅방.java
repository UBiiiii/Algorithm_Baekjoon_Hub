import java.util.*;

class Solution {
    static Map<String, String> nickname = new HashMap<>();
    static List<String[]> log = new ArrayList<>();
    
    public String[] solution(String[] record) {
        String[] answer, tmp = {};
        StringBuilder sb;
        for(String r : record) {
            tmp = r.split(" ");
            if(!tmp[0].equals("Change")) log.add(new String[] {tmp[0], tmp[1]});
            if(!tmp[0].equals("Leave"))  nickname.put(tmp[1], tmp[2]);
        }
        
        answer = new String[log.size()];
        
        for(int i=0;i<log.size();i++) {
            sb = new StringBuilder();
            tmp = log.get(i);
            answer[i] = sb.append(nickname.get(tmp[1])).append("님이 ").append(tmp[0].equals("Enter") ? "들어왔습니다." : "나갔습니다.").toString();
        }
        return answer;
    }
}