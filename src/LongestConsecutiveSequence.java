import java.util.HashMap;

/**
 * Created by szhu on 2014-03-15.
 */
public class LongestConsecutiveSequence {
    public static void main(String []args){
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int [] num = {1, 12, 2, 3, 4, 5, 6, 10, 9, 11, 13, 14, 8, 15, 16, 17};
        longestConsecutiveSequence.longestConsecutive(num);
    }
    public int longestConsecutive(int[] num) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++){
            map.put(num[i], 1);
        }
        for(int item: num){
            int length = 0;
            int temp_item = item;
            while(map.containsKey(temp_item)){
                length++;
                map.remove(temp_item);
                temp_item++;
            }
            temp_item = --item;
            while(map.containsKey(temp_item)){
                length++;
                map.remove(temp_item);
                temp_item--;
            }
            if(length > result)
                result = length;
        }
        return result;
    }
}
