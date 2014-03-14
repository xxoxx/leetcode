/**
 * Created by szhu on 2014-03-07.
 */
public class ReverseWords {
    public static void main(String []args){
        String s = "   a   b ";
        ReverseWords reverseWords = new ReverseWords();
        reverseWords.reverseWords(s);
    }
    public String reverseWords(String s) {
        if(s.equals(""))
            return  s;
        String result = new String("");
        String [] split = s.split(" ");
        for(int i = split.length - 1; i >= 0; i--){
            if(split[i].equals(""))
                continue;
            result += split[i] + " ";
        }
        result = result.trim();
        return result;
    }
}
