package exercises;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import static java.lang.Integer.parseInt;

public class Chapter6 {

    static StringBuilder numbersList;
    static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    public static int factorial(int number) {
        int total = 1;
        int aux = 1;

        /*
        //WHILE loop
        while(aux <= number) {
            total = total * aux;
            aux++;
        }
        */

        /*
        //FOR loop
        for (; aux <= number; aux++) {
            total = total * aux;
        }
        */

        /*
        //DO loop
        do {
            total = total * aux;
            aux++;
        } while(aux <= number);
        */

        //WHILE(TRUE)
        while(true) {
            total = total * aux;
            aux++;
            if(aux > number) {
                break;
            }
        }

        return total;
    }


    public static String divisibleByFive(int... numbers) {
        numbersList = new StringBuilder();
        for(int number : numbers) {
            numbersList.append(number);
            if(number % 5 != 0) {
                numbersList.append(' ');
                continue;
            }
            numbersList.append('*');
            numbersList.append(' ');
        }
        numbersList.deleteCharAt(numbersList.length() - 1);
        return numbersList.toString();
    }

    public static Vector<String> splitString() {
        Vector<String> splitString = new Vector<>();
        for(String number : divisibleByFive(numbers).split(" ")) {
            splitString.add(number);
        }
        return splitString;
    }

    public static String iterate() {
        Vector<String> numbers = splitString();
        StringBuilder string = new StringBuilder();
        numbers = splitString();
        for (Iterator<String> it = numbers.iterator(); it.hasNext(); ) {
            string.append(it.next());
            string.append(" ");
        }
        string.deleteCharAt(string.length() - 1);
        return string.toString();
    }
}

