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
    
    public int add(String numbers){
        
        if(numbers.isEmpty()){
                return 0;
        }else if(numbers.length() == 1){
           return Integer.parseInt(numbers);
        }else if(numbers.length() == 2){
            int val_one = Character.getNumericValue(numbers.charAt(0));
            int val_two = Character.getNumericValue(numbers.charAt(1));
            
            return val_one + val_two;
        }else{
            return 0;
        }
    }
    
}
