class Solution {
    public int solution(int n) {
        int answer = n, acnt = 0;

        int bn = Integer.bitCount(n);
        while(true) 
            if(Integer.bitCount(++answer)==bn)   
                break;
        return answer;
    }
}