/*Given two numbers represented as strings, return multiplication of the numbers as a string.

        Note: The numbers can be arbitrarily large and are non-negative.*/
import java.util.Arrays;
public class MultiplyString {
    public static void main(String []args){
        MultiplyString multiplyString = new MultiplyString();
        String str1 = "123", str2="4563";

        System.out.println(multiplyString.multiply(str1, str2));
    }

    public String multiply(String num1, String num2) {
        String result = null;
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        char [] resultArray = new char [num1.length() + num2.length() + 1];
        Arrays.fill(resultArray,'0');
        int dig1 = 0, dig2 = 0, carry = 0, temp = 0;
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for(int i = 0; i < num1.length(); i++){
            dig1 = num1.charAt(i) - '0';
            for(int j = 0; j < num2.length(); j++){
                dig2 = num2.charAt(j) - '0';
                temp = dig1 * dig2 + carry + resultArray[i + j] - '0';
                carry = temp / 10;
                temp %= 10;
                resultArray[i + j] = (char) (temp + '0');
            }
            if(carry != 0){
                resultArray[i + num2.length()]=(char) (carry+'0');
                carry = 0;
            }
        }
        result = new String(resultArray);
        result = new StringBuilder(result).reverse().toString();
        while(result.charAt(0) == '0'){
            result = result.substring(1);
        }
        return result;
    }
}
