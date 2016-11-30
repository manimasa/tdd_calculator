/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Martins
 */
public class Calculator {

    private final int NEW_LINE = 0, COMMA = 1, DEL_TO_REPLACE = 3, USER_DEL = 2;
    private char[] delimeters = {'\n', ','};
    private boolean change_delimiter;
    private boolean negative;

    public int add(String numbers) {
        int answer = 0;
        if (numbers.length() >= 1) {
            if (getDelimeterChanged(numbers)) {
                numbers = changeDelimiter(numbers);
            }
            answer = sumOfNumbers(numbers);
        }
        return answer;
    }

    private int sumOfNumbers(String numbers) {
        int current_val;
        int answer = 0;
        String negatives = "";
        String aNumberString = "";
        int number;

        for (int i = 0; i < numbers.length(); i++) {
            current_val = Character.getNumericValue(numbers.charAt(i));

            if (numbers.charAt(i) == '-') {
                negative = true;
                negatives += " -" + numbers.charAt(i + 1);
            }

            if (numbers.charAt(i) != delimeters[NEW_LINE] && numbers.charAt(i) != delimeters[COMMA]) {
                aNumberString += numbers.charAt(i);
            }else if (numbers.charAt(i) == delimeters[NEW_LINE] || numbers.charAt(i) == delimeters[COMMA]) {
                number = Integer.parseInt(aNumberString);
                if(number < 1000){
                        answer += number;
                }
                aNumberString = "";
            }

            if (i + 1 == numbers.length()) {
                number = Integer.parseInt(aNumberString);
                answer += number;
            }
        }
        if (negative) {
            throw new NumberFormatException("negative not allowed:".concat(negatives));
        }
        return answer;
    }

    private String changeDelimiter(String numbers) {
        if (numbers.charAt(DEL_TO_REPLACE) == delimeters[COMMA]) {
            delimeters[COMMA] = numbers.charAt(USER_DEL);
        } else if (numbers.charAt(DEL_TO_REPLACE) == delimeters[NEW_LINE]) {
            delimeters[NEW_LINE] = numbers.charAt(USER_DEL);
        }
        return numbers.substring(4);
    }

    private boolean getDelimeterChanged(String numbers) {
        int counter = 0;
        for (int i = 0; i < numbers.length(); i++) {
            if (!Character.isDigit(numbers.charAt(i)) && i < 3) {
                counter++;
            }
        }
        return (counter == 3);
    }

}
