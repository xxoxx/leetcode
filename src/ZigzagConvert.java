import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by szhu on 2/8/2014.
 */
public class ZigzagConvert {

    public static void main(String [] args){
        ZigzagConvert zigzagConvert = new ZigzagConvert();
        //String s = "oxjpkcpdekyazevyzxudsirvddoxmptaodryfhdltcmuijsigolaxevcimbwduwrzqrhxvssxgmhpgpxvdyujvwrhzpktmdvcvcbquvpbhwsposktsecncwxbljxznsdiugaqbprknmabekwwrzltxixiuwihonrkutaviuixgibkuxinythvcgewcofsbycxrctbydyelzqhzyvxsetwkzuonbgqziosmjvnmtrzvkiuidrcjkavlwjaxrrybhsqsndghwhegpyrvrvgcwcpsnqsfjqgqjykwbqfyzjeojxlbtsfpwujjkbqtuzldxxbznjxmuddedqhwioneiwqvygqufezdbacrlbfggkmjbvfjjsqtrgormhlulkxombfyengkxuwypdkyyarpiiiwptqcdnsrqypunxfkrdlggvggxaxhifdzyuddjvvcvkwikdvbggkpbqvyqvfaakzzgecsazuxmqgwwbxchhtkarkqmrrmbsnixsczrwwdoebkfzpoikyibkbpbuedmrnllpkfnjkbnmovnfjxpkitwjiydmdrgqdthpywyjzmvnhksshkepdbylbdaexiwabfrabqlaegqnskhzumpzpplqvnwsvsuwxlyabjchruujhclbqcbhtozobviypcwmoxoriqbanvluzyxpaawwovkrsvrhxotnnjhvcivpfjjfjgwkhtgxqsrjpiqnymclvlhxveobpxgzgclnxtmqndzdmrsmduybifadlpebomaurljoewerzfwnxoacjydrfeuqvbtjnteegnvmjbgljcygraicamvfspynsrwgnamvqjiblomuqlcjnkloygvsytfqneycglxwwfyhtkdmxhvlujbspwlnqsefwchdpezmmzvfkbtjirwcaxxpukfmcltznaefgdtsdqaprvacmxemubeoljcquvpjxvqeajwfcyutuvvgscv";
        String s = "0123456789";

        System.out.println(zigzagConvert.convert(s, 1));
    }
    public String convert(String s, int nRows) {
        int length = s.length();
        String result = new String("");
        if(nRows == 1)
            return s;
       for(int i = 0; i < nRows; i++){
           int j = i, padding1 = 0, padding2=0;
           boolean flag = false;
           padding1 = (j == 0 || j == nRows - 1) ? (2 * nRows -  2) : (nRows - j - 1)*2;
           padding2 = 2 * nRows - 2 - padding1;
           while(j < length){
               result += s.charAt(j);
               j += flag?padding2:padding1;
               if(padding1 == 0)
                    flag =true;
               else if(padding2 == 0)
                   flag = false;
               else
                   flag = !flag;
           }
       }
        return result;
    }
}
