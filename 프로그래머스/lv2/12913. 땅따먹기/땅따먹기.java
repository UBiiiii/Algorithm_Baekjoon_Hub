class Solution {

    public static int solution(int[][] land) {

        int[][] d = new int[land.length][land[0].length];
        for (int i = 0; i < land[0].length; i++) {
            d[0][i] = land[0][i];
        }

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                for (int k = 0; k < land[i].length; k++) {
                    if (j == k)
                        continue;
                    d[i][j] = Math.max(d[i][j], d[i - 1][k] + land[i][j]);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < land[0].length; i++) {
            ans = Math.max(ans, d[land.length - 1][i]);
        }

        return ans;
    }

}