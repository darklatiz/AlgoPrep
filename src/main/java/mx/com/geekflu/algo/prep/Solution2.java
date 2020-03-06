package mx.com.geekflu.algo.prep;

import java.io.IOException;



class Result {

    /*
     * Complete the 'decryptPassword' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String decryptPassword(String s) {
    // Write your code here
        char[] chars = s.toCharArray();
        int nums2remove = 0;
        for(int i = 0 ; i < chars.length ; i++){
            if(Character.isDigit(chars[i])){
                int lastZero = s.lastIndexOf('0');
                if(lastZero > -1) {
                	chars[lastZero] = chars[i];
                	s = new String(chars);
                	nums2remove++;
                }
            }else if(i + 1 < s.length() && Character.isUpperCase(chars[i]) && Character.isLowerCase(chars[i + 1])){
                char swap = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = swap;
                i = i + 2;
                s = new String(chars);
            }
        }
        String ret = new String(chars);
        ret = ret.replaceAll("\\*", "");
        ret = ret.substring(nums2remove, ret.length());
        return ret;
    }
}

public class Solution2 {
    public static void main(String[] args) throws IOException {

        //aP1pL5e
    	System.out.println(Result.decryptPassword("51Pa*0Lp*0e"));
        //poTaTO
        System.out.println(Result.decryptPassword("pTo*Ta*O"));

    }
}
