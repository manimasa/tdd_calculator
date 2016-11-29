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

    String value;

    public int add(String numbers) {
        int answer = 0;
        
        if (numbers.length() >= 1) {
            int lenght = numbers.length();
          answer =  sumOfNumbers(numbers, lenght);
        }
        return answer;
    }


    int sumOfNumbers(String numbers, int lenght) {
        int current_val;
        int answer = 0;
        for (int i = 0; i < lenght; i++) {
            current_val = Character.getNumericValue(numbers.charAt(i));
            if (numbers.charAt(i) != ',' || numbers.charAt(i) != '\n') {
                answer += current_val;
            }
        }
        return answer;
    }

}
