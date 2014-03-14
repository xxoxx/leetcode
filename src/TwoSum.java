/*
* Given an array of integers, find two numbers such that they add up to a specific target number.
* The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
* You may assume that each input would have exactly one solution.
* Input: numbers={2, 7, 11, 15}, target=9
* Output: index1=1, index2=2
*/

import java.util.Arrays;

/**
 * Created by szhu on 3/1/2014.
 */
public class TwoSum {
    public static void main(String []args){
        int [] numbers = {5,75,25};
        TwoSum twoSum = new TwoSum();
        twoSum.twoSum(numbers, 100);
    }

    public boolean binarySearch(int[] array, int imin, int imax, int target){
        boolean find = false;
        if(imax < imin)
            return find;
        if(array[(imin+imax)/2] == target){
            find = true;
        }else if(array[(imin+imax)/2] > target){
            find = binarySearch(array, imin, (imin+imax)/2 - 1, target);
        }else{
            find = binarySearch(array, (imin+imax)/2 + 1, imax, target);
        }
        return find;
    }
    public int[] twoSum(int[] numbers, int target) {
        int []numbers_ = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(numbers_);
        int []result= {-1, -1};
        int i = 0, j = 0, temp = 0;
        Label:
        for(i = 0; i < numbers_.length - 1; i++){
            temp = target - numbers_[i];
            if(binarySearch(numbers_, 0, numbers_.length - 1, temp))
                break;
        }
        for(j = 0; j < numbers.length; j++){
            //because we shuffled the sequence of numbers_, the first number should be assigned to result[0]
            //there might a possibility that temp==numbers_[i], to avoid we assign result[0] twice, we initialize it to -1
            if((numbers[j] == numbers_[i] || numbers[j] == temp) && result[0] == -1){
                result[0]= j + 1;
                continue;
            }
            //
            if((numbers[j] == numbers_[i] || numbers[j] == temp) && result[1] == -1){
                result[1] = j + 1;
                continue;
            }
        }
        return result;
    }

//
    public int[] twoSum1(int[] numbers, int target){
        int [] result = new int[2];


        return result;
    }

}
