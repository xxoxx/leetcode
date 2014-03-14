
import java.util.ArrayList;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class PalindromPartition {
    public static void main(String []args){
        PalindromPartition palindromPartition = new PalindromPartition();
        boolean flg = palindromPartition.isPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        palindromPartition.minCutII("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        //palindromPartition.minCutII("ccaacabacb");
        //palindromPartition.minCut("ccaacabacb");
    }
    private boolean isPalindrome(String s){
        if(s.equals(""))
            return true;
        if(s.length() == 1)
            return true;
        int length = s.length();
        for(int i  = length - 1; i >= length/2; i-- ){
            if(s.charAt(i) != s.charAt(length - 1 - i))
                return false;
        }
        return true;
    }
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(s.equals(""))
            return result;
        result.add(new ArrayList<String>());
        for(int i = 0; i < s.length(); i++){
            ArrayList<ArrayList<String>> copyResult = new ArrayList<ArrayList<String>>();
            copyResult.addAll(result);
            for(ArrayList<String> item: copyResult){

                int size = item.size();
                if(size >= 2 && isPalindrome(item.get(size - 2) + item.get(size - 1) + s.substring(i, i+1))){
                    ArrayList<String> arrayList1 = new ArrayList<String>();
                    arrayList1.addAll(item);
                    arrayList1.remove(size - 1);
                    arrayList1.remove(size - 2);
                    arrayList1.add(item.get(size - 2) + item.get(size - 1) + s.substring(i, i+1));
                    if(!result.contains(arrayList1))
                        result.add(arrayList1);
                }
                if(size >= 1 && isPalindrome(item.get(size - 1) + s.substring(i, i+1))){
                    ArrayList<String> arrayList1 = new ArrayList<String>();
                    arrayList1.addAll(item);
                    arrayList1.remove(size - 1);
                    arrayList1.add(item.get(size - 1) + s.substring(i, i + 1));
                    if(!result.contains(arrayList1))
                        result.add(arrayList1);
                }
                item.add(s.substring(i, i+1));
            }
        }
        return result;
    }

    int minCut(String s) {
        int N = s.length();
        ArrayList<ArrayList<Boolean>> dp1 = new ArrayList<ArrayList<Boolean>>();
        ArrayList<Integer> dp2 = new ArrayList<Integer>();
        for(int i = 0; i < N; i++){
            ArrayList<Boolean> arrayList = new ArrayList<Boolean>();
            for(int j = 0; j < N; j++){
                arrayList.add(false);
            }
            dp1.add(arrayList);
            dp2.add(N);
        }

        for (int j = 0; j < N; j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp1.get(i+1).get(j-1))) {
                    dp1.get(i).set(j, true);
                    if (i == 0) {
                        dp2.set(j, 0);
                    }
                    else {
                        dp2.set(j, Math.min(dp2.get(j), dp2.get(i - 1) + 1 ));
                    }
                }
            }
        }
        return dp2.get(N - 1);
    }

    public int minCutII(String s) {
        if(s.equals("") || isPalindrome(s))
            return 0;
        int length = s.length();
        ArrayList<Integer> minCutNumber = new ArrayList<Integer>();
        for(int i = 0; i < length; i++){
            minCutNumber.add(i);
        }
        for(int i = 0; i < length; i++){
            for(int j = 0; j <= i; j++){
                if(isPalindrome(s.substring(j, i + 1))){
                    if(j == 0)
                        minCutNumber.set(i, 0);
                    else
                        minCutNumber.set(i, Math.min(minCutNumber.get(i), minCutNumber.get(j - 1) + 1));
                }
            }
        }
        return minCutNumber.get(length - 1);
    }
}
