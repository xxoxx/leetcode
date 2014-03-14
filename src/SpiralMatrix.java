import java.util.ArrayList;
import java.util.Random;

/**
 * Created by szhu on 2/11/2014.
 */

public class SpiralMatrix {
    public static void main(String [] args){
        int m = 2, n = 3;
        Random random = new Random();
        random.setSeed(52325345);
        int [][] matrix = new int [m+1][n+1];
        for(m = 2; m >= 0; m--)
            for(n = 3; n >= 0; n--)
                matrix[m][n] = random.nextInt(10);
        SpiralMatrix spiralMatrix = new SpiralMatrix();
       // System.out.println(spiralMatrix.spiralReading(matrix));
        System.out.println(spiralMatrix.createSpiralMatrix(1));

    }

    public ArrayList<Integer> spiralReading(int [][] matrix){
        ArrayList<Integer> result =  new ArrayList<Integer>();
        int a, a1, a2, b, b1, b2;

        b1 = 0;
        b2 = matrix.length - 1;
        if(b2 < 0)
            return result;
        a1 = 0;
        a2 = matrix[0].length - 1;

        while((a2 - a1 >= 0) && (b2 - b1 >= 0)){
            for(a = a1; a <= a2; a++)
                result.add(matrix[b1][a]);
            if(b1 == b2)
               break;
            for(b = b1 + 1; b <= b2; b++)
                result.add(matrix[b][a2]);
            if(a1==a2)
                break;
            for(a = a2 - 1; a >= a1; a--)
                result.add(matrix[b2][a]);
            for(b = b2 - 1; b > b1; b-- )
                result.add(matrix[b][a1]);
            a1++;
            a2--;
            b1++;
            b2--;
        }
        return result;
    }
    public int[][] createSpiralMatrix(int n){
        int [][] array = new int[n][n];
        int a, a1, a2, b, b1, b2, i = 0;
        a1 = 0;
        a2 = n - 1;
        b1 = 0;
        b2 = n - 1;

        if(n==0)
            return array;
        while((a2 - a1 >= 0) && (b2 - b1 >= 0)){
            for(a = a1; a <= a2; a++)
                array[b1][a] = ++i;
            if(b1 == b2)
                break;
            for(b = b1 + 1; b <= b2; b++)
                array[b][a2] = ++i;
            if(a1==a2)
                break;
            for(a = a2 - 1; a >= a1; a--)
                array[b2][a] = ++i;
            for(b = b2 - 1; b > b1; b-- )
                array[b][a1] = ++i;
            a1++;
            a2--;
            b1++;
            b2--;
        }
        return array;
    }
}
