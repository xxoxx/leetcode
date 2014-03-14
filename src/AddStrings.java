import java.util.Arrays;

/**
 * Created by szhu on 2/27/2014.
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 *Note: The numbers can be arbitrarily large and are non-negative.
 */

public class AddStrings {
    public static void main(String []args){
        AddStrings addStrings = new AddStrings();
        String str1 = "999", str2="1234563";
        char [] array = new char [1];
        array[0]='0';
        System.out.println(addStrings.add(str2, str1));
        str1 = str1.copyValueOf(array, 0, 1);
        System.out.println(str1);
    }
    public String add(String str1, String str2){
        //str1 should be longer than str2
        String result = new String(str1);
        int carrier = 0;
        int add = 0;
        if(str2.length() > str1.length()){
            str1 = str2;
            str2 = result;
        }
        char [] arr = new char[str1.length() - str2.length()];
        Arrays.fill(arr, '0');
        str2 = new String(arr) + str2;
        result = new String("");
        for(int i = str1.length() - 1; i >= 0; i--){
            add = str1.charAt(i) - '0' + str2.charAt(i) - '0' + carrier;
            carrier = add / 10;
            add %= 10;
            result  = String.valueOf(add) + result;
        }


        if(result.charAt(0) == '0')
            result = result.substring(1);

        return result;
    }

}
