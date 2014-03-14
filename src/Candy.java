import java.util.Arrays;

/**
 * Created by szhu on 2014-03-11.
 */
public class Candy {
    public static void main(String []args){
        Candy candy = new Candy();
        int [] array = {1,2,4,4,3};
        candy.candy(array);

    }
    public int candy(int[] ratings) {
        if(ratings.length == 0 || ratings.length == 1)
            return ratings.length;
        int result = 0;
        int [] candyNumber = new int[ratings.length];
        for(int i = 0; i < ratings.length; i++){
            candyNumber[i] = 1;
        }
        for(int i  = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1] && candyNumber[i] <= candyNumber[i - 1]){
                candyNumber[i] = candyNumber[i - 1]+1;
            }
        }

        for(int i = ratings.length - 2 ; i >= 0; i--){
            if(ratings[i] > ratings[i + 1] && candyNumber[i] <= candyNumber[i + 1]){
                candyNumber[i] = candyNumber[i+1] + 1;
            }
            if(i-1 >= 0 && ratings[i-1] > ratings[i] && candyNumber[i-1] <= candyNumber[i]){
                candyNumber[i - 1] = candyNumber[i] + 1;
            }
        }
        for(int i = 0; i < candyNumber.length; i++){
            result += candyNumber[i];
        }
        return result;
    }
}
