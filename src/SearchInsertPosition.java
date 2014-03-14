/**
 * Created by szhu on 2/12/2014.
 */
public class SearchInsertPosition {
    public static void main(String []args){

    }

    public int searchPosition(int [] A, int target){
        int i = 0, length = A.length;
        for(i = 0; i < length; i++){
            if(A[i] >= target)
                return i;
        }
        return length;
    }
}
