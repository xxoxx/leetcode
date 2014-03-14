/**
 * I:  Given an array of integers, every element appears twice except for one. Find that single one.
 * II: Given an array of integers, every element appears three times except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    public static void main(String []args){
        int [] A = new int[7];
        A[0] = 1;
        A[1] = 1;
        A[2] = 30;
        A[3] = 1;
        A[4] = 30;
        A[5] = 1;
        A[6] = 1;
        SingleNumber singleNumber = new SingleNumber();
        singleNumber.singleNumberIII(A);
    }

    public int singleNumber(int[] A) {
        int result = 0;
        for(int i = 0; i < A.length; i++){
            result ^= A[i];
        }
        return result;
    }

    public int singleNumberII(int[] A) {
        int result = 0;
        int ones = 0, twos = 0, threes = 0;
        for(int i = 0; i < A.length; i++){
            twos |= (ones & A[i]);
            ones ^= A[i];
            threes = ~(ones & twos);
            ones &= threes;
            twos &= threes;
        }
        return ones==0?twos:ones;
    }
    // all the numbers occur four times, except one number, but not sure how many time it occurs
    public int singleNumberIII(int[] A) {
        int result = 0;
        int ones = 0, twos = 0, threes = 0, fours = 0;
        for(int i = 0; i < A.length; i++){
            twos |= (ones & A[i]);
            ones ^= A[i];
            threes |= (twos & ones);
            fours = ~(threes & ~ones & twos);
            ones &= fours;
            twos &= fours;
            threes &= fours;
        }
        return ones==0?twos:ones;
    }
}
