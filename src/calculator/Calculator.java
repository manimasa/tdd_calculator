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

    private final int NEW_LINE = 0, COMMA = 1;
    private char[] delimeters = {'\n', ','};
    private boolean change_delimiter;

    public int add(String numbers) {
        int answer = 0;
        if (numbers.length() >= 1) {
            for (int i = 0; i < 4; i++) {
                change_delimiter = !Character.isDigit(numbers.charAt(0));
                if (change_delimiter) {
                    numbers = changeDelimiter(numbers);
                }
                answer = sumOfNumbers(numbers);
            }
        }
        return answer;
    }

    private int sumOfNumbers(String numbers) {
        int current_val;
        int answer = 0;
        for (int i = 0; i < numbers.length(); i++) {
            current_val = Character.getNumericValue(numbers.charAt(i));
            if (numbers.charAt(i) != delimeters[NEW_LINE] && numbers.charAt(i) != delimeters[COMMA]) {
                answer += current_val;
            }
        }
        return answer;
    }

    private String changeDelimiter(String numbers) {
        if (numbers.charAt(3) == delimeters[COMMA]) {
            delimeters[COMMA] = numbers.charAt(2);
        } else if (numbers.charAt(3) == delimeters[NEW_LINE]) {
            delimeters[NEW_LINE] = numbers.charAt(2);
        }
        return numbers.substring(4);
    }

}
