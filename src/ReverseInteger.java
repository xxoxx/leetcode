/**
 * Created by szhu on 2014-03-15.
 */
public class ReverseInteger {
    public static void main(String []args){
        ReverseInteger reverseInteger = new ReverseInteger();
        reverseInteger.reverseII(100);
    }
    public int reverse(int x) {
        int result = 0;
        int temp = Math.abs(x);
        while(temp >= 10){
            result = result * 10 + temp % 10;
            temp /= 10;
        }
        result = result * 10 + temp;
        if(x < 0)
            result = -result;
        return result;
    }

    public int reverseII(int x) {
        int result = 0;
        String temp = String.valueOf(Math.abs(x));
        temp = new StringBuilder(temp).reverse().toString();
        result = Integer.valueOf(temp);
        if(x < 0)
            result = -result;
        return result;
    }
}
