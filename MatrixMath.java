import java.text.DecimalFormat ;
            
public class MatrixMath
{
    public static String toString(double[][] mat)
    {
        int n = mat.length;
        int m = mat[0].length;
        
        DecimalFormat fmt = new DecimalFormat("#.00  ");
        
        String result = "";
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < m; col++)
                result = result + fmt.format(mat[row][col]);
            result = result + "\n";
        }
        
        return result;
    }
            
    public static double[][] scalarMult(double[][] mat, double c)
    {
        int n = mat.length;
        int m = mat[0].length;
        double[][] result = new double[n][m];
        
        for (int row = 0; row < n; row++)
            for (int col = 0; col < m; col++)
                result[row][col] = mat[row][col]*c;
                
        return result;
    
    }
    
    public static double[][] add(double[][] mat1, double[][]mat2)
    {
        int n1 = mat1.length;
        int m1 = mat1[0].length;
        double[][] result = new double[n1][m1];
        
        for (int row = 0; row < n1; row++)
            for (int col = 0; col < m1; col++)
                result[row][col] = mat1[row][col] + mat2[row][col];

        return result;
    }
    
    
        public static double[][] multiply(double[][] mat1, double[][]mat2)
    {
        int n1 = mat1.length;
        int m1 = mat1[0].length;
        int m2 = mat2[0].length;
        
        double[][] result = new double[n1][m2];
        
        for (int row = 0; row < n1; row++)
            for (int col = 0; col < m2; col++)
            {
                double sum = 0;
                for(int k = 0; k < m1; k++)
                    sum = sum + mat1[row][k]*mat2[k][col];
                result[row][col] = sum;
            }
        return result;
    }
    
        public static double[][] invert(double[][] mat)
    {
        double[][] result = new double[2][2];
        
        double determinant = mat[0][0]*mat[1][1] - mat[1][0]*mat[0][1];
        result[0][0] = mat[1][1] / determinant;
        result[1][1] = mat[0][0] / determinant;
        result[0][1] = -mat[0][1] / determinant;
        result[1][0] = -mat[1][0] / determinant;                

        return result;
    }
}
