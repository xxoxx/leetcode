import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

        P   A   H   N
        A P L S I I G
        Y   I   R
        And then read line by line: "PAHNAPLSIIGYIR"
        Write the code that will take a string and make this conversion given a number of rows:

        string convert(string text, int nRows);
        convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".*/
/**
 * Created by szhu on 2/8/2014.
 */
public class ZigzagConvert {

    public static void main(String [] args){
        ZigzagConvert zigzagConvert = new ZigzagConvert();
        //String s = "oxjpkcpdekyazevyzxudsirvddoxmptaodryfhdltcmuijsigolaxevcimbwduwrzqrhxvssxgmhpgpxvdyujvwrhzpktmdvcvcbquvpbhwsposktsecncwxbljxznsdiugaqbprknmabekwwrzltxixiuwihonrkutaviuixgibkuxinythvcgewcofsbycxrctbydyelzqhzyvxsetwkzuonbgqziosmjvnmtrzvkiuidrcjkavlwjaxrrybhsqsndghwhegpyrvrvgcwcpsnqsfjqgqjykwbqfyzjeojxlbtsfpwujjkbqtuzldxxbznjxmuddedqhwioneiwqvygqufezdbacrlbfggkmjbvfjjsqtrgormhlulkxombfyengkxuwypdkyyarpiiiwptqcdnsrqypunxfkrdlggvggxaxhifdzyuddjvvcvkwikdvbggkpbqvyqvfaakzzgecsazuxmqgwwbxchhtkarkqmrrmbsnixsczrwwdoebkfzpoikyibkbpbuedmrnllpkfnjkbnmovnfjxpkitwjiydmdrgqdthpywyjzmvnhksshkepdbylbdaexiwabfrabqlaegqnskhzumpzpplqvnwsvsuwxlyabjchruujhclbqcbhtozobviypcwmoxoriqbanvluzyxpaawwovkrsvrhxotnnjhvcivpfjjfjgwkhtgxqsrjpiqnymclvlhxveobpxgzgclnxtmqndzdmrsmduybifadlpebomaurljoewerzfwnxoacjydrfeuqvbtjnteegnvmjbgljcygraicamvfspynsrwgnamvqjiblomuqlcjnkloygvsytfqneycglxwwfyhtkdmxhvlujbspwlnqsefwchdpezmmzvfkbtjirwcaxxpukfmcltznaefgdtsdqaprvacmxemubeoljcquvpjxvqeajwfcyutuvvgscv";
        String s = "ABCD";

        System.out.println(zigzagConvert.convert(s, 4));
    }
    public String convert(String s, int nRows) {
        int length = s.length();
        String result = new String("");
        if(nRows == 1)
            return s;
        for(int i = 0; i < nRows; i++){
            int j = i, padding1 = 0, padding2=0;
            boolean flag = false;

            padding1 = (nRows - j - 1)*2;
            padding2 = j * 2;
            if(padding1 == 0)
                flag =true;
            else if(padding2 == 0)
                flag = false;
            while(j < length){
                result += s.charAt(j);
                j += flag?padding2:padding1;
                if(padding1 != 0 && padding2 != 0)
                    flag = !flag;
            }
        }
        return result;
    }

}
