package exercises;

public class Chapter6 {

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
        StringBuilder numbersList = new StringBuilder();
        for(int number : numbers) {
            numbersList.append(number);
            if(number % 5 != 0) {
                numbersList.append(' ');
                continue;
            }
            numbersList.append('*');
            numbersList.append(' ');
        }

        return numbersList.toString();
    }
}

