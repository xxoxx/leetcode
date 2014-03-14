import java.util.*;

/**
 * Created by szhu on 2014-03-06.
 */
public class WordBreak {
    public static void main(String []args){
        //String [] array = {"cat","cats","and","sand","dog"};
        String [] array = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        HashSet<String> dict = new HashSet<String>();
        dict.addAll(Arrays.asList(array));
        String s = new String("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        WordBreak wordBreak = new WordBreak();
        wordBreak.wordBreakII(s, dict);
    }


/*   TLE problem
 public boolean wordBreak(String s, Set<String> dict) {
        if(dict.contains(s))
            return true;
        if(s.equals(""))
            return false;
        for(int i = 0; i < s.length() - 1; i++){
            String substring = s.substring(0, i);
            if(dict.contains(substring))
                if(wordBreak(s.substring(i), dict))
                    return true;
        }
        return false;
    }*/
    public boolean wordBreak(String s, Set<String> dict) {
        if(s.equals(""))
            return false;

        int length = s.length();
        boolean [] dp = new boolean[length + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i = 1; i <= length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }

    public ArrayList<String> wordBreakII(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        if(s.equals("") || !wordBreak(s, dict))
            return result;

        int length = s.length();
        boolean [] dp = new boolean[length + 1];
        HashMap<Integer, ArrayList<String>> segmentedString = new HashMap<Integer, ArrayList<String>>();
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i = 0; i <= length; i++){
            segmentedString.put(i, new ArrayList<String>());
            segmentedString.get(i).add("");
        }

        for(int i = 1; i <= length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    segmentedString.get(i).remove("");
                    for(String item: segmentedString.get(j)){
                        if(item.equals(""))
                            segmentedString.get(i).add(s.substring(j, i));
                        else
                            segmentedString.get(i).add(item + " " + s.substring(j, i));
                    }
                }
            }
        }
        return segmentedString.get(length);
    }
}
