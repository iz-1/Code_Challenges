package com.company;

import java.text.MessageFormat;

public class Main {
// Create a function that takes a number as an argument and returns true if the number is a valid credit card number, false otherwise.
//
// Credit card numbers must be between 14-19 digits in length, and pass the Luhn test, described below:
//
// Remove the last digit (this is the "check digit").
//    Reverse the number.
//    Double the value of each digit in odd-numbered positions. If the doubled value has more than 1 digit, add the digits together (e.g. 8 x 2 = 16 ➞ 1 + 6 = 7).
//    Add all digits.
//    Subtract the last digit of the sum (from step 4) from 10. The result should be equal to the check digit from step 1.
//    Examples
//    validateCard(1234567890123456) --> false
//
//// Step 1: check digit = 6, num = 123456789012345
//// Step 2: num reversed = 543210987654321
//// Step 3: digit array after selective doubling: [1, 4, 6, 2, 2, 0, 9, 8, 5, 6, 1, 4, 6, 2, 2]
//// Step 4: sum = 58
//// Step 5: 10 - 8 = 2 (not equal to 6) --> false
//
//        validateCard(1234567890123452) --> true

    public static boolean validateCard(long num) {
        String cardNum = new Long(num).toString();
        //System.out.println(MessageFormat.format("card: {0}", cardNum));

        // Credit card numbers must be between 14-19 digits in length
        if(cardNum.length() < 14 || cardNum.length() > 19)
            return false;

        // Luhn test
        // step 1: Remove the last digit (this is the "check digit").
        int checkDigit = Character.getNumericValue(cardNum.charAt(cardNum.length()-1));
        //System.out.println(MessageFormat.format("check: {0}", checkDigit));

        // step 2: Reverse the number.
        StringBuilder sb = new StringBuilder();
        sb.append(cardNum.substring(0, cardNum.length()-1));
        String reversed = sb.reverse().toString();

        //System.out.println(MessageFormat.format("reversed: {0}", reversed));

        // step 3: Double the value of each digit in odd-numbered positions.
        // If the doubled value has more than 1 digit, add the digits together (e.g. 8 x 2 = 16 ➞ 1 + 6 = 7).
        // Add all digits.

        Integer sum = 0;
        //for(char c : reversed.toCharArray()){
        for(int i=0; i<reversed.length(); ++i) {
            int val = Character.getNumericValue(reversed.charAt(i));
            Integer result = 0;

            if((i & 1) == 0) { // odd meaning 0 is odd/first
                //System.out.println(MessageFormat.format("d: {0}", i));
                switch (val) {
                    case 5:
                        result = 1;
                        break; // 5 => 10
                    case 6:
                        result = 3;
                        break; // 6 => 12
                    case 7:
                        result = 5;
                        break; // 7 => 14
                    case 8:
                        result = 7;
                        break; // 8 => 16
                    case 9:
                        result = 9;
                        break; // 9 => 18
                    default:
                        result = val << 1;
                }
                sum += result;
            } else {
                sum += val;
            }
        }

        //System.out.println(MessageFormat.format("sum: {0}", sum));

        // get last digit of sum
        sb.setLength(0);
        sb.append(sum.toString());
        String sumString = sb.toString();
        char charDigit = sumString.charAt(sumString.length()-1);
        int digit = Character.getNumericValue(charDigit);

        //System.out.println(MessageFormat.format("lastdigit: {0}", digit));

        // step 4: Subtract the last digit of the sum (from step 4) from 10.
        // The result should be equal to the check digit from step 1.
        int result = 10 - digit;

        //System.out.println(MessageFormat.format("result: {0} check: {1}", result, checkDigit));

        if(result == checkDigit)
            return true;
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(validateCard(1234567890123456L));
        System.out.println(validateCard(1234567890123452L));
    }
}
