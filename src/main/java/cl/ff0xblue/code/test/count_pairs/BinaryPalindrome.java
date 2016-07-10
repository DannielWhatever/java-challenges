package cl.ff0xblue.code.test.count_pairs;

/**
 * @author daniel
 */
public class BinaryPalindrome {


    public static void main(String[] args) {
        int[] inputs = new int[]{9,10};
        for (int i : inputs){
            System.out.println(isBinaryPalindrome(i));
        }
    }

    static boolean isBinaryPalindrome(int x) {
        String binaryRepresentation = Integer.toBinaryString(x);
        return isPalindromeV2(binaryRepresentation);
    }

    static boolean isPalindrome(String word){
        return word.equals(new StringBuilder(word).reverse().toString());
    }

    static boolean isPalindromeV2(String word){
        int len = word.length() - 1 ;
        for(int i = 0; i <=  len/2; i++){
            if(word.charAt(i) != word.charAt(len-i)){
                return false;
            }

        }
        return true;
    }



}
