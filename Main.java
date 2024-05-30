/* An codergym exercise of static classes/methods */



import java.util.*;
/***Main */
public class Main
{
    public static void main(String[] args) 
    {
            //
            boolean isNullOrEmpty = StringUtils.Validator.isNullOrEmpty("Hello");
            boolean isPalindrome = StringUtils.Validator.isPalindrome("radar");
            //
            String capitalized = StringUtils.Formatter.capitalize("hello world");
            String reversed = StringUtils.Formatter.reverse("Java");
            //
            String encoded = StringUtils.Encoder.encodeBase64("secret");
            String decoded = StringUtils.Encoder.decodeBase64(encoded);

            // OUTPUT OF VALIDATOR CLASS
            System.out.println("isNullOrEmpty: "+isNullOrEmpty);
            System.out.println("isPalindrome: "+isPalindrome);
            //OUTPUT FORMATTER CLASS
            System.out.println("capitalized: "+capitalized);
            System.out.println("reversed: "+reversed);
            //OUTPUT ENCODER CLASS
            System.out.println("encoded: "+encoded);
            System.out.println("decoded: "+decoded);


    }

    public static boolean checkWhetherPalindrome(String str)
    {
        if(str==null)
        {
            return false;
        }

        str = str.replaceAll("\\s","").toLowerCase();
        int left=0 ,right =str.length()-1;
        while(left<right)
        {   
            if(str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true; 
    }
    public static String giveReverseOfIt(String str)
    {
        if(str==null)
        {
            return null;
        }
        char[] reversedStr = new char[str.length()];
        char[] givenStr = str.toLowerCase().toCharArray();
        int rightOfStr =givenStr.length-1;
        for(int leftOfReversed=0 ; leftOfReversed<givenStr.length ; leftOfReversed++)
        {   
            reversedStr[leftOfReversed] = givenStr[rightOfStr];
            rightOfStr--;
        }
        reversedStr[0] = (char)((int) reversedStr[0] - 32);
        String reversedResult = new String(reversedStr);
        return reversedResult;
    }
    
}   



class StringUtils
{

    static class Validator
    {
        static boolean isNullOrEmpty(String parameter)
        {
            return ( parameter == null || parameter.isEmpty() );
        }
        static boolean isPalindrome(String parameter)
        {
            return Main.checkWhetherPalindrome(parameter);
        }
    }
    static class Formatter
    {
         static String capitalize(String parameter)
        {
            return parameter.toUpperCase();
        }
        static String reverse(String parameter)
        {
            return Main.giveReverseOfIt(parameter);
        }
        
    }
    static class Encoder
    {
        static String encodeBase64(String parameter)
        {
            byte[] paramArray = parameter.getBytes();
            return Base64.getEncoder().encodeToString(paramArray);
        }
        static String decodeBase64(String parameter)
        {
            byte[] paramArray = parameter.getBytes();
            paramArray= Base64.getDecoder().decode(paramArray);
            return new String(paramArray);
        }
    }

}
