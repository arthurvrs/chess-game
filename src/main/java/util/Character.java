package util;

public class Character {

    /*static String NEWLINE = "\n";
    public boolean isWhitespace(char character) {
        if(character == '\n' || character == '\t' || character == '\b') {
            return true;
        }
        return false;
    }

    public String getNEWLINE() {
        return NEWLINE;
    }*/

    public static int[] getLocation(String location) {
        int[] aux = new int[2];
        int auxRank = 0;
        int auxFile = 0;
        String rank = location.substring(1,2);
        String files = location.substring(0,1);
        switch (rank) {
            case "1" -> auxRank = 7;
            case "2" -> auxRank = 6;
            case "3" -> auxRank = 5;
            case "4" -> auxRank = 4;
            case "5" -> auxRank = 3;
            case "6" -> auxRank = 2;
            case "7" -> auxRank = 1;
            case "8" -> {}
        }
        switch (files) {
            case "a" -> {}
            case "b" -> auxFile = 1;
            case "c" -> auxFile = 2;
            case "d" -> auxFile = 3;
            case "e" -> auxFile = 4;
            case "f" -> auxFile = 5;
            case "g" -> auxFile = 6;
            case "h" -> auxFile = 7;
        }
        aux[0] = auxRank;
        aux[1] = auxFile;
        return aux;
    }

    public static String getLocation(int[] location) {
        StringBuilder aux = new StringBuilder();
        char auxRank = ' ';
        char auxFile = ' ';
        int rank = location[1];
        int files = location[0];
        switch (files) {
            case 7 -> auxRank = '1';
            case 6 -> auxRank = '2';
            case 5 -> auxRank = '3';
            case 4 -> auxRank = '4';
            case 3 -> auxRank = '5';
            case 2 -> auxRank = '6';
            case 1 -> auxRank = '7';
            case 0 -> auxRank = '8';
        }
        switch (rank) {
            case 0 -> auxFile = 'a';
            case 1 -> auxFile = 'b';
            case 2 -> auxFile = 'c';
            case 3 -> auxFile = 'd';
            case 4 -> auxFile = 'e';
            case 5 -> auxFile = 'f';
            case 6 -> auxFile = 'g';
            case 7 -> auxFile = 'h';
        }
        aux.append(auxFile);
        aux.append(auxRank);
        return aux.toString();
    }
}
