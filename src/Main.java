public class Main {
    //declare variables
    static double[][] a; //matrix #1
    static double[][] x; //matrix #2
    static double tol; //tolerance z^x
    static int n; //iterations
    public static void main(String[] args){
        //These stay the same per test
        Power power = new Power();
        x = new double[][]{ //row, column
            {500},
            {300},
            {150},
            { 50}
        };
        tol = Math.pow(10,-5);
        n = 100;

        //Test1
        a = new double[][]{
                { 0, 0.75, 2.4, 0.3},
                { 0.4, 0, 0, 0},
                { 0, 0.7, 0, 0},
                { 0, 0, 0.8, 0}
        };
        power.calculate(a,x,tol,n);
    }
}
