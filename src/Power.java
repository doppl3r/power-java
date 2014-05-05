public class Power {
    public Power(){

    }
    public void calculate(double[][] a, double[][] x, double tol, int n){
        int k = 1;
        int p = (int)getHighestValue(x);
        x = getDividedMatrix(x, p);

        while (k <= n){
            double[][] y  = multiplyMatrix(a, x);
            //double[][] mu =
        }
    }
    public double getHighestValue(double[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        double p = 0;


        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                if (p < matrix[row][col]) p = matrix[row][col];
            }
        }
        return p;
    }
    public double[][] getDividedMatrix(double[][] matrix, double denominator){
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                matrix[row][col] = matrix[row][col]/denominator;
            }
        }
        return matrix;
    }
    public double[][] multiplyMatrix(double[][] A, double[][] B) {

        int aRows = A.length;
        int aCols = A[0].length;
        int bRows = B.length;
        int bCols = B[0].length;

        if (aCols != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aCols + " did not match B:Columns " + bRows + ".");
        }

        double[][] matrix = new double[aRows][bCols];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bCols; j++) { // bColumn
                for (int k = 0; k < aCols; k++) { // aColumn
                    matrix[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return matrix;
    }
}
