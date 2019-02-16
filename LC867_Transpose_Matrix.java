class Solution {
    public int[][] transpose(int[][] A) {
        int xLen = A.length, yLen = A[0].length;
        int[][] Res = new int[yLen][xLen];

        for(int i = 0; i < yLen; i++)
            for(int j = 0; j < xLen; j++)
                Res[i][j] = A[j][i];
        return Res;
    }
}
// An unknown error occurred. Please try again later, or contact us if this problem persists.

