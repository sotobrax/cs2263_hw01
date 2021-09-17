package edu.isu.cs2263.hw01;
import java.util.ArrayList;
import java.util.Scanner;


import static com.google.common.math.IntMath.pow;

public class Eval {
    public static void eval(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter expression:");
        String expression = scan.nextLine();
        String numbers = expression.replaceAll("[^0-9]", " ");
        System.out.println(expression);
        char[] str = expression.toCharArray();
        int a = numbers.length();
        ArrayList<Double> nums = new ArrayList<>();
        int count = 0;
        int ex =0;
        double num= 0;
        char[] chars = numbers.toCharArray();
        int x = 0;
        int nc = 0;
        int oc = 0;
        // Pulls numbers out of string, into array list
        for (int i = 0; i <a; i++){
            if (chars[i] == ' ' || oc + 1  == a){
                int jc = i - count - 1;
                //Process whole number
                for(int j = i ; j > jc ; j--) {
                    //Process individual digits
                    if (chars[j] >= '0' && chars[j] <= '9') {
                        x = chars[j] - '0';
                        x = (x * pow(10, ex));
                        num = num + x;
                        x = 0;
                        ex = ex + 1;
                    }
                    count--;
                }

                   if(num != 0) {
                       nums.add(num);
                       nc++;
                   }
                ex = 0;

            }
            num = 0;
            count++;
            oc++;
        }
        ArrayList<Character> ch = new ArrayList<>();
        int cc = 0;
        for (int i = 0; i < a; i++){
            if (str[i] == '+' || str[i] == '-' || str[i] == '/' || str[i] == '*') {
                ch.add(str[i]);
                cc++;
            }
        }
        double answer = 0;
        double v = 0;
        double c = 0;
        for (int i = 0; i < cc; i++){
             if (ch.get(i) == '+') {
                 for (int j = 0; j < 2; j++) {
                     if (j == 0) {
                         v = nums.get(0);
                         nums.remove(0);
                     }


                     else {
                         c = nums.get(0);
                         c = c + v;
                         nums.set(0, c);
                         c = 0;
                         v = 0;

                     }


                 }
             }
           else if (ch.get(i) == '-'){
                for(int j = 0; j < 2; j++){
                    if (j == 0){
                        v = nums.get(0);
                        nums.remove(0);
                    }
                    else{
                        c = nums.get(0);
                        c = v - c;
                        nums.set(0, c);
                        c = 0;
                        v = 0;

                    }


                }
            }
             else if (ch.get(i) == '*'){
                 for(int j = 0; j < 2; j++){
                     if (j == 0){
                         v = nums.get(0);
                         nums.remove(0);
                     }
                     else{
                         c = nums.get(0);
                         c = v * c;
                         nums.set(0, c);
                         c = 0;
                         v = 0;

                     }


                 }
             }
             else if (ch.get(i) == '/'){
                 for(int j = 0; j < 2; j++){
                     if (j == 0){
                         v = nums.get(0);
                         nums.remove(0);
                     }
                     else{
                         c = nums.get(0);
                         c = v / c;
                         nums.set(0, c);
                         c = 0;
                         v = 0;

                     }


                 }
             }
             answer = nums.get(0);
        }

        System.out.println("Answer: " + answer);

    }
}
