class Solution {
    public long solution(int n) {
        int answer = 1;
        int[] num = new int[n+1];
        num[0] = 1;
        num[1] = 1;
        for(int i=2;i<=n;i++) {
            num[i] = (num[i-1] + num[i-2])%1_000_000_007;
        }
        
        return num[n];
    }
}