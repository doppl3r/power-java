public class Power {
    public Power(){

    }
    public void calculate(double[][] a, double[][] x, double tol, int n){
        //declare and initialize variables
        int k = 1;
        double yp;
        double err;
        double mu = 0;
        double[][] y;
        //mutate vars
        x = divideMatrix(x,getHighestValue(x));


        //loop through
        while (k <= n){
            y  = multiplyMatrix(a, x);
            mu = getHighestValue(y);
            yp = getHighestValue(y);
            if (yp == 0){
                System.out.println("A");
                System.out.println("A has a zero eigenvalue with corresponding e_vect");
                break;
            }
            err = norm(subtractMatrix(x, divideMatrix(y, getHighestValue(y))));
            x = divideMatrix(y, getHighestValue(y));
            if (err < tol){
                System.out.println("err: "+err+", tol: "+tol);
                break;
            }
            k++;
        }
        System.out.println("Converges to mu="+mu);
    }
    public double getHighestValue(double[][] matrix){ return matrix[getHighestValueIndex(matrix)][0]; }
    public int getHighestValueIndex(double[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int index = 0;
        double p = 0;

        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                if (p < matrix[row][col]){
                    p = matrix[row][col];
                    index = row;
                }
            }
        }
        return index;
    }
    public double[][] divideMatrix(double[][] matrix, double denominator){
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                matrix[row][col] = matrix[row][col]/denominator;
            }
        }
        return matrix;
    }
    public double norm(double[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        double total = 0;

        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                total += Math.pow(matrix[row][col], 2);
            }
        }
        return Math.sqrt(total);
    }
    public double[][] subtractMatrix(double[][] A, double[][] B){
        int aRows = A.length;
        int aCols = A[0].length;
        int bRows = B.length;
        int bCols = B[0].length;

        double[][] matrix = new double[aRows][bCols];
        for (int row = 0; row < aRows; row++) {
            for (int col = 0; col < bCols; col++) {
                matrix[row][col] = A[row][col]-B[row][col];
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
    public void matrixToString(double[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                System.out.print(matrix[row][col]);
                if (col != cols && row != rows) System.out.print(",");
            }
            System.out.println("");
        }
    }
}
