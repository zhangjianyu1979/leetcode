public class Rotate{
public static void main(String args[]){
    int[][] matrix = {{1,2,3},{4,5,6}};
    Rotate r = new Rotate();
    int[][] ret = r.Solution(matrix,1);
    r.printMatrix(ret);
}
    public void printMatrix(int[][] matrix){
        for(int i =0; i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.println(matrix[i][j]);
            }
        }
    }
    public int[][] Solution(int[][] matrix, int flag){
        if((matrix == null)||(matrix.length ==0)||(matrix[0].length == 0))
            return matrix;
        int m = matrix.length, n = matrix[0].length;
        int[][] retVal = transpose(matrix);
        flip(retVal, flag);
        return retVal;
    }

    private int[][] transpose(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        int[][] ret = new int[n][m];
        for(int i = 0; i< n; i++)
            for(int j = 0; j < m; j++)
                ret[i][j] = matrix[j][i];
        return ret;
    }

    private void flip(int[][] matrix, int flag){
        int m = matrix.length, n = matrix[0].length;
        if(flag == 1){
            // clock wise
            for(int i = 0; i < m; i++)
                for(int j = 0; j < n/2; j++){
                    matrix[i][j] ^= matrix[i][n-j-1];
                    matrix[i][n-j-1]^= matrix[i][j];
                    matrix[i][j] ^=  matrix[i][n-j-1];
                }
        }else{
            for(int i = 0; i < m/2; i++)
                for(int j = 0; j < n; j++){
                    matrix[i][j] ^= matrix[m-1-i][j];
                    matrix[m-1-i][j]^= matrix[i][j];
                    matrix[i][j] ^=  matrix[m-1-i][j];
                }
        }
    }
}

