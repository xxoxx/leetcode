/**
 * Created by szhu on 2014-03-12.
 */
public class ValidPalindrome {
    public static void main(String []args){
        String s = "1a1";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        validPalindrome.isPalindrome(s);
    }
    public boolean isPalindrome(String s){
        s = s.toLowerCase();
/*        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) < 'a' || s.charAt(i) > 'z'){
                if(i == 0)
                    s = s.substring(i+1);
                else if(i == s.length() - 1)
                    s = s.substring(0, s.length() - 1);
                else
                    s = s.substring(0, i) + s.substring(i + 1);
            }
        }*/

        if(s.length() <= 1)
            return true;
        int j = s.length() - 1;
        for(int i = 0; i <  j; ){
            if((s.charAt(i) < 'a' || s.charAt(i) > 'z') && (s.charAt(i) < '0' || s.charAt(i) > '9')){
                i++;
                continue;
            }
            if((s.charAt(j) < 'a' || s.charAt(j) > 'z')  && (s.charAt(j) < '0' || s.charAt(j) > '9')){
                j--;
                continue;
            }
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
