class Solution {
    public void rotate(int[][] matrix) {
        if((matrix == null) || (matrix.length < 2))
            return;

        int temp =0;
        int len = matrix.length;
        int xl = 0, yl = 0, xr = len - 1, yr = len - 1;

        for(int i = 0; i < len / 2 ; i++){
            rotateEdge(matrix, xl++, yl++, xr--,yr--);
        }
    }
    private void rotateEdge(int[][] matrix, int xl, int yl, int xr, int yr){
        int temp;
        int len = xr - xl; // len 错用了整个数组的长度，应该用当前圈的长度
        for(int i = 0; i < len; i++){
            temp = matrix[xl+i][yl];
            matrix[xl + i][yl] = matrix[xr][yl + i];
            matrix[xr][yl + i] = matrix[xr - i][yr];
            matrix[xr - i][yr] = matrix[xl][yr - i];
            matrix[xl][yr-i] = temp;
        }
    }
}
